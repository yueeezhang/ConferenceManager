package Factor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import DAO.ConfDAO;
import DAO.RootDAO;
import Conference.*;

public class ConferCateDecorate extends ConfDAO{
	
	private static Map<String,ArrayList<Integer>> mp;
	private static ArrayList<ConferenceAttr> conferList;
	private static ArrayList hotconf;
	
	private Connection conn;
	
	private String CONFERENCE_INSERT = "insert conferenceattr values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String CONFERENCE_DELETE = "delete from conferenceattr where CID=?";
	private String CONFERENCE_UPDATE = "update conferenceattr set CName=?,"
			+ " StartTime=?, City=?, Members=?, CTel=?, `CE-mail`=?, Organizer=?,"
			+ " Addr=?, Introduction=?, EndOrNot=?, MemLimit=?, EndTime=?"
			+ "where CID=?";
	
	private String CATEGORY_INSERT="insert category values(?,?)";
	private String CATEGORY_DELETE="delete from category where CID=?";
	private String CATEGORY_UPDATE="update category set sort=? "
			+ "where CID=?";

	public ConferCateDecorate(){
		mp = new HashMap<String,ArrayList<Integer>>();
		conferList=new ArrayList<ConferenceAttr>();
		conn = getConnection();
	}
	
	
	//InsertConference里直接调用
	private void InsertCategory(int CID, String cat){
		if(mp.get(cat) == null){
			ArrayList<Integer> li_temp = new ArrayList<Integer>();
			li_temp.add(new Integer(CID));
			mp.put(cat, li_temp);
		}
		else{
			if(mp.get(cat).isEmpty()){
				ArrayList<Integer> li_temp = new ArrayList<Integer>();
				li_temp.add(new Integer(CID));
				mp.put(cat, li_temp);
			}
			else mp.get(cat).add(new Integer(CID));
		}
		try {
			PreparedStatement pstmt = conn.prepareStatement(CATEGORY_INSERT);
			pstmt.setInt(1, CID);
			pstmt.setString(2, cat);
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//DeleteConference里直接调用。
	private void DeleteCategory(int CID){
		System.out.println(CID);
		System.out.println(SearchConference(CID).GetCategory());
		ArrayList<Integer> confTemp = mp.get(SearchConference(CID).GetCategory());
		for(int i = 0;i < confTemp.size();i++){
			if(confTemp.get(i) == CID){
				confTemp.remove(i);
				break;
			}
		}

		try {
			PreparedStatement pstmt = conn.prepareStatement(CATEGORY_DELETE);
			pstmt.setInt(1, CID);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//UpdateConference里直接调用。
	private void UpdateCategory(int CID, String cat){
		System.out.println(CID);
		System.out.println(SearchConference(CID).GetCategory());
		ArrayList<Integer> ar1 = mp.get(SearchConference(CID).GetCategory());
		ArrayList<Integer> ar2;
		if(mp.get(cat) == null){
			ar2 = new ArrayList<Integer>();
		}
		else{
			ar2 = mp.get(cat);
		}
		for(int i = 0;i < ar1.size();i++){
			if(CID == ar1.get(i)){
				ar1.remove(i);
				break;
			}
		}
		ar2.add(new Integer(CID));
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(CATEGORY_UPDATE);
			pstmt.setInt(1, CID);
			pstmt.setString(2, cat);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected ConferenceAttr SearchConference(int CID){
		ConferenceAttr confr = null;
		for(int i = 0;i < conferList.size(); i++){
			if(conferList.get(i).GetCID() == CID){
				confr = conferList.get(i);
				break;
			}
		}
		return confr;
	}
	
	protected ArrayList<ConferenceAttr> ShowOpenConference(){
		ArrayList<ConferenceAttr> conf=new ArrayList<ConferenceAttr>();
		for(int i=0;i<conferList.size();i++){
			if(conferList.get(i).GetEndOrNot()=='0')
				conf.add(conferList.get(i));
		}
		return conf;
	}
	
	protected void AddMembers(int CID){
		SearchConference(CID).AddMembers();
	}
	
	protected void SubstactMembers(int CID){
		SearchConference(CID).SubstactMembers();
	}

	//从数据库往mp和conferList加
	protected void addConference(ConferenceAttr Confr){
		conferList.add(Confr);
	}
	
	protected void addCat(String Cat,int CID){
		System.out.println(Cat+" "+CID +" " );
		System.out.println(SearchConference(CID));
		SearchConference(CID).SetCategory(Cat);
		System.out.println(SearchConference(CID).GetCategory());
		if(mp.get(Cat) == null){
			ArrayList<Integer> al = new ArrayList<Integer>();
			mp.put(Cat, al);
		}
		mp.get(Cat).add(new Integer(CID));
	}
	
	
	protected ArrayList<ConferenceAttr> SearchConf_ByEndOrNot(char eon){
		if(eon =='2')return null;
		ArrayList<ConferenceAttr> result=new ArrayList<ConferenceAttr>();
		for(int i=0;i<conferList.size();i++){
			if(conferList.get(i).GetEndOrNot()==eon){
				result.add(conferList.get(i));
			}
		}
		return result;
	}
	
	protected ArrayList<ConferenceAttr> SearchConf_ByCity(String city){
		ArrayList<ConferenceAttr> result = new ArrayList<ConferenceAttr>();
		for(int i = 0;i < conferList.size(); i++){
			if(conferList.get(i).GetCity().equalsIgnoreCase(city)){
				result.add(conferList.get(i));
			}
		}
		return result;
	}
	
	protected ArrayList<ConferenceAttr> SearchConf_ByOrgnz(String Organizer){
		ArrayList<ConferenceAttr> result = new ArrayList<ConferenceAttr>();
		for(int i = 0;i < conferList.size(); i++){
			if(conferList.get(i).GetOrganizer().equalsIgnoreCase(Organizer)){
				result.add(conferList.get(i));
			}
		}
		return result;
	}
	
	protected ArrayList<ConferenceAttr> SearchConf_ByName(String cname){
		ArrayList<ConferenceAttr> result = new ArrayList<ConferenceAttr>();
		for(int i = 0;i < conferList.size(); i++){
			if(conferList.get(i).GetCName().contains(cname)){
				result.add(conferList.get(i));
			}
		}
		return result;
	}
	protected ArrayList<ConferenceAttr> SearchConf_ByCID(int CID){
		ArrayList<ConferenceAttr> result = new ArrayList<ConferenceAttr>();
		for(int i = 0;i < conferList.size(); i++){
			if(conferList.get(i).GetCID() == CID){
				result.add(conferList.get(i));
			}
		}
		return result;
	}
	protected ConferenceAttr SearchConf(int CID){
		for(int i = 0 ; i < conferList.size();i++)
			if(conferList.get(i).GetCID()==CID){
				return conferList.get(i);
			}
		return null;
	}
	protected ArrayList<Integer> getConference(String sort){
		return mp.get(sort);
	}
	
	protected int getNum(String sort){
		return mp.get(sort).size();
	}
	
	protected void InsertConference(ConferenceAttr Confr){
		conferList.add(Confr);
		try {
			PreparedStatement pstmt=conn.prepareStatement(CONFERENCE_INSERT);
			pstmt.setInt(1, Confr.GetCID());
			pstmt.setString(2, Confr.GetCName());
			pstmt.setString(3, Confr.GetStartTime());
			pstmt.setString(4, Confr.GetCity());
			pstmt.setInt(5, Confr.GetMembers());
			pstmt.setString(6, Confr.GetTel());
			pstmt.setString(7, Confr.GetEmail());
			pstmt.setString(8, Confr.GetOrganizer());
			pstmt.setString(9, Confr.GetAddr());
			pstmt.setString(10, Confr.GetIntro());
			pstmt.setString(11, Confr.GetEndOrNot()+"");
			pstmt.setInt(12, Confr.GetMemLimit());
			pstmt.setString(13, Confr.GetEndTime());
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InsertCategory(Confr.GetCID(), Confr.GetCategory());
	}
	
	protected void DeleteConference(int CID){
		DeleteCategory(CID);
		for(int i = 0;i < conferList.size(); i++){
			if(conferList.get(i).GetCID() == CID){
				conferList.remove(i);
				break;
			}
		}
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(CONFERENCE_DELETE);
			pstmt.setInt(1, CID);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void UpdateConference(ConferenceAttr Confr){
		SearchConference(Confr.GetCID()).update(Confr);
		try {
			PreparedStatement pstmt=conn.prepareStatement(CONFERENCE_UPDATE);
			pstmt.setInt(13, Confr.GetCID());
			pstmt.setString(1, Confr.GetCName());
			pstmt.setString(2, Confr.GetStartTime());
			pstmt.setString(3, Confr.GetCity());
			pstmt.setInt(4, Confr.GetMembers());
			pstmt.setString(5, Confr.GetTel());
			pstmt.setString(6, Confr.GetEmail());
			pstmt.setString(7, Confr.GetOrganizer());
			pstmt.setString(8, Confr.GetAddr());
			pstmt.setString(9, Confr.GetIntro());
			pstmt.setString(10, Confr.GetEndOrNot()+"");
			pstmt.setInt(11, Confr.GetMemLimit());
			pstmt.setString(12, Confr.GetEndTime());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UpdateCategory(Confr.GetCID(), Confr.GetCategory());
	}
	
	
	protected ArrayList<ConferenceAttr> SearchCategory(String cat){
		ArrayList<ConferenceAttr> classify=null;
		ArrayList<Integer> temp=mp.get(cat);
		if(temp.isEmpty()||!mp.containsKey(cat)){
			return null;
		}
		else{
			classify=new ArrayList<ConferenceAttr>();
			for(int i=0;i<temp.size();i++){
				classify.add(SearchConference(temp.get(i).intValue()));
			}
		}
		return classify;
	}
	
	protected int GetNowID(){
		return conferList.get(conferList.size()-1).GetCID();
	}
	
	@SuppressWarnings("unchecked")
	protected void GetNowHotConf(){
		Map<Integer,Integer> oldMap=new HashMap<Integer,Integer>();
		for(int i=0;i<conferList.size();i++){
			System.out.println("123");
			oldMap.put(conferList.get(i).GetCID(), conferList.get(i).GetMembers());
		}
		ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>();  
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {   
            public int compare(Entry<java.lang.Integer, Integer> arg0,  
                    Entry<java.lang.Integer, Integer> arg1) {  
                return arg0.getValue() - arg1.getValue();  
            }  
        });  
        hotconf=new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {  
			System.out.println("123^^^^");
            hotconf.add(list.get(i).getKey());  
        }  
	}
	
	protected ArrayList<ConferenceAttr> GetHotConf(){
		GetNowHotConf();
		return hotconf;
	}
	
	protected String RecommendCate(ArrayList<Integer> recoCID){
		Map<String,Integer> satic=new HashMap<String,Integer>();
		String cat;
		for(int i=0;i<recoCID.size();i++){
			System.out.println(recoCID.get(i)+"**");
			cat=SearchConference(recoCID.get(i)).GetCategory();
			if(!satic.containsKey(cat)){
				satic.put(cat, 1);
			}
			else
				satic.put(cat, satic.get(cat)+1);
		}
		String result = null;
		int k=0;
		for (Entry<String, Integer> entry : satic.entrySet()){
			if(entry.getValue()>k){
				k=entry.getValue();
				result=entry.getKey();
			}
		}
		System.out.println(result);
		return result;
	}
	
	protected ArrayList<ConferenceAttr> GetRecommend(ArrayList<Integer> hist, String cate){
		ArrayList<ConferenceAttr> reconf=new ArrayList<ConferenceAttr>();
		for(int i=0;i<conferList.size();i++){
			if(conferList.get(i).GetCategory()==cate
					&&!hist.contains(conferList.get(i).GetCID())
					&&conferList.get(i).GetEndOrNot()=='0'){
				System.out.println(conferList.get(i).GetCName()+"111");
				reconf.add(new ConferenceAttr(conferList.get(i)));
			}
		}
		if(reconf.isEmpty())
			System.out.println("NULL!!!");
		return reconf;
	}
	
	protected ArrayList<ConferenceAttr> GetRandom(ArrayList<Integer> hist){
		ArrayList<ConferenceAttr> reconf=new ArrayList<ConferenceAttr>();
		int tempCID;
		for(int i=0;reconf.size()<5&&i<conferList.size();i++){
			if(conferList.get(i).GetEndOrNot()=='0'){
				tempCID=conferList.get(i).GetCID();
				if(!hist.contains(tempCID))
					reconf.add(conferList.get(i));
			}
		}
		return reconf;
	}
} 