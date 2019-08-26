package Factor;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Conference.ApplyDetailAttr;
import Conference.ConferenceAttr;
import DAO.ApplyDAO;
import DAO.RootDAO;

public class ApplyDetailDecorate extends ApplyDAO{
	private static ApplyDetailDecorate metDtDeco;
	private static ArrayList<ApplyDetailAttr> medetlist;
	
	private Connection conn;
	private String MEETINGDETAIL_INSERT="insert applydetailattr values(?,?,?,?,?,?,?)";
	private String MEETINGDETAIL_DELETE="delete from applydetailattr where UID=? and CID=?";
	private String MEETINGDETAIL_UPDATE="update applydetailattr set TrainNum=?, "
			+ "InvHead=?, InvCon=?, Hotel=?, Remark=? where UID=? and CID=?";
	private String MEETINGDETAIL_SELECT="select UID,CID from applydetailattr where UID=? and CID=?";
	private String UPDATE_CONF="update conferenceattr set members=? where CID=?";

	protected ApplyDetailDecorate(){
		medetlist=new ArrayList<ApplyDetailAttr>();
	}
	
	protected void addMeetingDetail(ApplyDetailAttr met){
		medetlist.add(met);
	}
	
	protected void UpdateMeetingDetail(ApplyDetailAttr met){
		for(int i=0;i<medetlist.size();i++){
			if(medetlist.get(i).GetCID()==met.GetCID()&&medetlist.get(i).GetUID()==met.GetUID()){
				medetlist.get(i).update(met);
			}
		}
		
		conn = getConnection();
		try {
			PreparedStatement pstmt=conn.prepareStatement(MEETINGDETAIL_UPDATE);
			pstmt.setInt(1, met.GetUID());
			pstmt.setInt(2, met.GetCID());
			pstmt.setInt(3, met.GetTrainNum());
			pstmt.setString(4, met.GetInvHead());
			pstmt.setString(5, met.GetInvCon());
			pstmt.setString(6, met.GetHotel());
			pstmt.setString(7, met.GetRemark());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void InsertMeetingDetail(ApplyDetailAttr met,ConferenceAttr conf){
		medetlist.add(met);
		
		conn = getConnection();
		try {
			PreparedStatement pstmt=conn.prepareStatement(MEETINGDETAIL_INSERT);
			pstmt.setInt(1, met.GetUID());
			pstmt.setInt(2, met.GetCID());
			pstmt.setInt(3, met.GetTrainNum());
			pstmt.setString(4, met.GetInvHead());
			pstmt.setString(5, met.GetInvCon());
			pstmt.setString(6, met.GetHotel());
			pstmt.setString(7, met.GetRemark());
			pstmt.executeUpdate();
			
			PreparedStatement ptt2 = conn.prepareStatement(UPDATE_CONF);
			ptt2.setInt(1, conf.GetMembers()+1);
			ptt2.setInt(2, conf.GetCID());
			ptt2.executeUpdate();
			conf.AddMembers();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void DeleteMeetingDetail(int UID, int CID,ConferenceAttr conf){

		System.out.println(UID+"    "+CID);
		for(int i=0;i<medetlist.size();i++){
			if(medetlist.get(i).GetCID()==CID&&medetlist.get(i).GetUID()==UID){
				medetlist.remove(i);
				break;
			}
		}
		
		conn = getConnection();
		try {
			PreparedStatement pstmt=conn.prepareStatement(MEETINGDETAIL_DELETE);
			pstmt.setInt(1, UID);
			pstmt.setInt(2, CID);
			pstmt.executeUpdate();
			
			PreparedStatement ptt2 = conn.prepareStatement(UPDATE_CONF);
			ptt2.setInt(1, conf.GetMembers()-1);
			ptt2.setInt(2, conf.GetCID());
			ptt2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conf.SubstactMembers();
	}
	
	protected void DeleteMeeting_ByUID(int UID){
		for(int i=0;i<medetlist.size();i++){
			if(medetlist.get(i).GetUID()==UID){
				medetlist.remove(i);
				i--;
			}
		}
	}
	
	protected void DeleteMeeting_ByCID(int CID){
		for(int i=0;i<medetlist.size();i++){
			if(medetlist.get(i).GetCID()==CID)
				medetlist.remove(i);
		}
	}
	
	protected ArrayList<ApplyDetailAttr> SearchMeetingDetail_ByCID(int CID){
		ArrayList<ApplyDetailAttr> result=new ArrayList<ApplyDetailAttr>();
		for(int i=0;i<medetlist.size();i++){
			if(medetlist.get(i).GetCID()== CID)
				result.add(medetlist.get(i));
		}
		return result;
	}
	
	protected ArrayList<ApplyDetailAttr> SearchMeetingDetail_ByUID(int UID){
		ArrayList<ApplyDetailAttr> result=new ArrayList<ApplyDetailAttr>();
		for(int i=0;i<medetlist.size();i++){
			if(medetlist.get(i).GetUID()==UID)
				result.add(medetlist.get(i));
		}
		return result;
	}
	
	protected ArrayList<Integer> ViewHistoryCID(int UID){
		ArrayList<Integer> recoCID=new ArrayList<Integer>();
		for(int i=0;i<medetlist.size();i++){
			if(medetlist.get(i).GetUID()==UID){
				int CID=medetlist.get(i).GetCID();
				recoCID.add(new Integer(CID));
			}
		}
		return recoCID;
	}
	protected boolean ContainApply(int UID, int CID){
		boolean s=false;
		for(int i=0;i<medetlist.size();i++)
			if(medetlist.get(i).GetCID()==CID&&medetlist.get(i).GetUID()==UID){
				s=true;
				break;
			}
		return s;
	}
	protected boolean ApplyOrNot(int UID,int CID){
		conn = getConnection();
		try {
			PreparedStatement pstm = conn.prepareStatement(MEETINGDETAIL_SELECT);
			pstm.setInt(1, UID);
			pstm.setInt(2, CID);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				if(rs.getInt(1)==UID && rs.getInt(2)==CID){
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
