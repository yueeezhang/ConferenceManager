package Factor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conference.*;
import Person.*;
import DAO.RootDAO;

public class Factor extends RootDAO{
	private String CONFERENCE_ALL_LOAD = "SELECT * FROM CONFERENCEATTR";
	private String CATEGORY_ALL_LOAD = "SELECT * FROM CATEGORY";
	private String PERSON_ALL_LOAD = "SELECT * FROM PERSONATTR";
	private String USER_ALL_LOAD = "SELECT * FROM USERATTR";
	private String ADMIN_ALL_LOAD = "SELECT * FROM ADMINATTR";
	private String DETAIL_ALL_LOAD = "SELECT * FROM APPLYDETAILATTR";
	private static Factor factor;
	
	public static ConferCateDecorate confCateDecorate;
	public static PersonDecorate personDecorate;
	public static ApplyDetailDecorate applyDecorate;
	
	
	protected Connection conn;
	
	private Factor(){
		confCateDecorate = new ConferCateDecorate();
		personDecorate = new PersonDecorate();
		applyDecorate = new ApplyDetailDecorate();
		conn = getConnection();
		conf_load();
		person_load();
		detail_load();
	}
	public static Factor GetInstance(){
		if(factor == null)
			factor = new Factor();
		return factor;
	}
	private void conf_load(){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ConferenceAttr temp;
		try {
			pstmt=conn.prepareStatement(CONFERENCE_ALL_LOAD);
			rs=pstmt.executeQuery();
			while(rs.next()){
				temp=new ConferenceAttr(rs.getInt("CID"),rs.getString("CName"),
						rs.getString("StartTime"),rs.getString("City"),rs.getInt("Members"),
						rs.getString("EndTime"),rs.getString("CTel"),
						rs.getString("CE-mail"),rs.getString("Organizer"),
						rs.getString("Addr"),rs.getString("introduction"),
						rs.getString("EndOrNot").charAt(0),rs.getInt("MemLimit"));
				
				confCateDecorate.addConference(temp);
			}
			pstmt=conn.prepareStatement(CATEGORY_ALL_LOAD);
			rs=pstmt.executeQuery();
			while(rs.next())
				confCateDecorate.addCat(rs.getString(2), rs.getInt(1));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void person_load(){
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		ResultSet rs=null;
		ResultSet rs2=null;
		PersonAttr temp_per;
		UserAttr temp_user;
		AdminAttr temp_admin;
		String password;
		try {
			pstmt=conn.prepareStatement(PERSON_ALL_LOAD);
			rs=pstmt.executeQuery();
			while(rs.next()){
				temp_per = new PersonAttr(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4).toCharArray()[0]);
				personDecorate.addPerson(temp_per);	
			}
			pstmt=conn.prepareStatement(USER_ALL_LOAD);
			rs=pstmt.executeQuery();
			while(rs.next()){
				temp_user = new UserAttr(rs.getInt(1),rs.getString(2),rs.getString(7)
						,rs.getString(3),rs.getString(5).toCharArray()[0],rs.getInt(6),rs.getString(4),rs.getString(8));
				personDecorate.addUser(temp_user);
			}
			pstmt=conn.prepareStatement(ADMIN_ALL_LOAD);
			rs=pstmt.executeQuery();
			while(rs.next()){
				temp_admin = new AdminAttr(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				personDecorate.addAdmin(temp_admin);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void detail_load(){
		ApplyDetailAttr detail;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(DETAIL_ALL_LOAD);
			rs=pstmt.executeQuery();
			while(rs.next()){
				detail = new ApplyDetailAttr(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4)
						,rs.getString(5),rs.getString(6),rs.getString(7));
				applyDecorate.addMeetingDetail(detail);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void InsertUesr(UserAttr user){
		personDecorate.InsertUser(user);
	}
	public void InsertConf_ByAdmin(ConferenceAttr conf){
		confCateDecorate.InsertConference(conf);
	}

	public void EditUser(UserAttr user){
		personDecorate.EditUser(user);
	}
	
	public void EditApply(ApplyDetailAttr apply){
		applyDecorate.UpdateMeetingDetail(apply);
	}
	
	public void EditAdmin(AdminAttr admin){
		personDecorate.EditAdmin(admin);
	}
	
	public void EditUserPW(int UID, String pw){
		personDecorate.EditUserPassword(UID, pw);
	}
	
	public void EditAdminPW(int UID, String pw){
		personDecorate.EditAdminPassword(UID, pw);
	}
	
	public void DelUser(UserAttr user){
		int UID=user.GetUID();
		applyDecorate.DeleteMeeting_ByUID(UID);
		personDecorate.DeleteUser(user);
	}
	
	public void DelConf_ByAdmin(int CID){
		confCateDecorate.DeleteConference(CID);
	}
	
	public ArrayList<ConferenceAttr> SearchConf_ByPerson(String req,String str){	//void->ArrayList<ConferenceAttr>
		if(req.equalsIgnoreCase("城市"))										//希望req传参 "City", "eon"(char改String传入), "Names", "Orgnz"
			return confCateDecorate.SearchConf_ByCity(str);
		if(req.equalsIgnoreCase("状态")){
			if(str.equals("已结束"))
				return confCateDecorate.SearchConf_ByEndOrNot('1');
			else if(str.equals("报名中")) return confCateDecorate.SearchConf_ByEndOrNot('0');
			else return confCateDecorate.SearchConf_ByEndOrNot('2');
		}
		if(req.equalsIgnoreCase("会议名称"))
			return confCateDecorate.SearchConf_ByName(str);
		if(req.equalsIgnoreCase("主办方"))
			return confCateDecorate.SearchConf_ByOrgnz(str);
		if(req.equalsIgnoreCase("会议ID"))
			return confCateDecorate.SearchConf_ByCID(Integer.parseInt(str));
		return null;
	}
	
	public ArrayList<UserAttr> SearchUser(String req,String str){
			if(req.equals("用户ID")){
				if(str!=""){
					return personDecorate.SearchUser_ById(Integer.parseInt(str));
				}
				else return personDecorate.SearchUser_ById(-1);
			}
			else if(req.equals("用户姓名")){
				return personDecorate.SearchUser_ByName(str);
			}
			else if(req.equals("用户性别")){
				return personDecorate.SearchUser_BySex(str.charAt(0));
			}
			else if(req.equals("用户年龄")){
				return personDecorate.SearchUser_ByAge(str);
			}
		return null;
	}
	public UserAttr SearchUser(String name){
		ArrayList<UserAttr> user = personDecorate.SearchUser_ByName(name);
		System.out.println(name);
		if(user.size() != 0){
			return user.get(0);
		}
		return null;
	}
	public ConferenceAttr SearchConf(int CID){
		return confCateDecorate.SearchConf(CID);
	}
/*	public void SearchConf_ByUser(String req,String str){
		
	}*/
	
	public ArrayList<ApplyDetailAttr> ViewApplyHistory(int UID){
		return applyDecorate.SearchMeetingDetail_ByUID(UID);
	}
	
	public ConferenceAttr ViewConfDetail_ByPerson(int CID){	
		return confCateDecorate.SearchConference(CID);
	}
/*	public ConferenceAttr ViewConfDetail_ByUser(int CID){
		return confCateDecorate.SearchConference(CID);
	}*/
	
	public ArrayList<ApplyDetailAttr> ViewApplyDetail(int CID){
		return applyDecorate.SearchMeetingDetail_ByCID(CID);
	}
	
	public ArrayList<ConferenceAttr> ShowAllConf(){
		return confCateDecorate.ShowOpenConference();
		
	};
	
	
	public ArrayList<UserAttr> ShowAllUser(){
		return personDecorate.ShowAllUser();
	}
/*	public PersonAttr SearchUser_ByAdmin(String username){
		return personDecorate.SearchPerson(username);
	}*/
	
	//将CID为CID的会议改为conf
	public void EditConf_ByAdmin(ConferenceAttr conf){
		confCateDecorate.UpdateConference(conf);
	}
	
	public int GetNowCID(){
		return confCateDecorate.GetNowID();
	}
	public int GetNowUID(){
		return personDecorate.getNowID();
	}
	
	public PersonAttr SearchPerson(String name){
		return personDecorate.SearchPerson(name);
	}
	public void AttendConf(ApplyDetailAttr apply, ConferenceAttr conf){
		applyDecorate.InsertMeetingDetail(apply,conf);
	}
	
	public void CancleApply(int UID, int CID, ConferenceAttr conf){
		applyDecorate.DeleteMeetingDetail(UID, CID, conf);
	}
	
	public ArrayList<ConferenceAttr> Recommend(int UID){
		ArrayList<ConferenceAttr> reconf=new ArrayList<ConferenceAttr>();
		ArrayList<Integer> histCID=applyDecorate.ViewHistoryCID(UID);
		String cate = null;
		if(!histCID.isEmpty()){
			cate=confCateDecorate.RecommendCate(histCID);
			reconf=confCateDecorate.GetRecommend(histCID, cate);
		}
		if(!reconf.isEmpty()) return reconf;
		else{
			reconf.addAll(confCateDecorate.GetRandom(histCID));
			
			return reconf;	
		}
	}
	
	public ArrayList<ApplyDetailAttr> ViewApplyDetailByName_ByAdmin(String name){
		int UID=SearchUser(name).GetUID();
		return ViewApplyHistory(UID);
	}
	public ArrayList<ConferenceAttr> ShowAllOpenNotAttendConf(int UID){
		ArrayList<ConferenceAttr> conf=confCateDecorate.ShowOpenConference();
		for(int i=0;i<conf.size();i++){
			if(applyDecorate.ContainApply(UID, conf.get(i).GetCID())){
				System.out.println("enter Factor.ShowAllOpenNotAttendConf"+i);
				conf.remove(i);
			}
		}
		return conf;
	}
	public boolean ApplyOrNot(int UID,int CID){
		return applyDecorate.ApplyOrNot(UID,CID);
	}
}