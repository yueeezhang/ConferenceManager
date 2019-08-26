package Factor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Conference.ConferenceAttr;
import DAO.PersonDAO;
import DAO.RootDAO;
import Person.AdminAttr;
import Person.PersonAttr;
import Person.UserAttr;

public class PersonDecorate extends PersonDAO{
	private static ArrayList<UserAttr> userArray;
	private static ArrayList<AdminAttr>adminArray;
	private static ArrayList<PersonAttr>personArray;
	private static Connection conn;
	private static String USER_INSERT_OPT = "insert into userattr values(?,?,?,?,?,?,?,?)";
	private static String PERSON_INSERT_OPT = "insert into personattr values(?,?,?,?)";
	private static String ADMIN_INSERT_OPT = "insert into adminattr values(?,?,?,?)";
	
	private static String PERSON_UPDATE_PW="update personattr set password=? where UID=?";
	private static String ADMIN_UPDATE_PW="update adminattr set password=? where UID=?";
	private static String USER_UPDATE_PW="update userattr set password=? where UID=?";
	private static String USER_UPDATE_OPT="update userattr set NAME=?, TEL=?,"
			+ "`E-MAIL`=?, SEX=?, AGE=?, TURENAME=? where UID=?";
	
	private static String USER_DELETE_OPT="delete from userattr where UID=?";
	private static String PEROSON_DELETE_OPT="delete from personattr where UID=?";
	
	protected PersonDecorate(){
		userArray = new ArrayList<UserAttr>();
		adminArray = new ArrayList<AdminAttr>();
		personArray = new ArrayList<PersonAttr>();
		conn = getConnection();
	}
	
	protected int getNowID(){		//返回最后一个人的uid
		return personArray.get(personArray.size()-1).GetUid();
	}
	protected PersonAttr SearchPerson(String name){
		PersonAttr per ;
		for(int i = 0; i < personArray.size(); i ++){
			per = personArray.get(i);
			if(per.GetUserName().equals(name))return per;
		}
		return null;
	}
	
	private PersonAttr SearchPerson(int UID){
		PersonAttr per;
		for(int i=0;i<personArray.size();i++){
			per=personArray.get(i);
			if(per.GetUid()==UID)return per;
		}
		return null;
	}
	
	// from database to list
	protected void addUser(UserAttr user){
		userArray.add(user);
	}
	protected void addAdmin(AdminAttr admin){
		adminArray.add(admin);
	}
	protected void addPerson(PersonAttr person){
		personArray.add(person);
	}
	
	protected void printUser(){
		for(int i = 0; i < userArray.size() ; i++){
			UserAttr user = userArray.get(i);
			System.out.println(user.GetUID()+ " " +user.GetUserName());
		}
	}
	
	//from list to database
	protected void InsertUser(UserAttr user){
		addUser(user);
	    PreparedStatement pstmt = null;
	    try{
		 	pstmt = conn.prepareStatement(USER_INSERT_OPT);
		 	pstmt.setInt(1, user.GetUID());
		 	pstmt.setString(2, user.GetUserName());
		 	pstmt.setString(3, user.GetTel());
		 	pstmt.setString(4, user.GetEmail());
		 	pstmt.setString(5,user.GetSex() + " ");
		 	pstmt.setInt(6,user.GetAge());
		 	pstmt.setString(7, user.GetTrueName());
		 	pstmt.setString(8, user.GetPassword());
			pstmt.executeUpdate();
			pstmt.close();
	       }catch(SQLException e){
		        e.printStackTrace();
       }
	    PersonAttr person = new PersonAttr(user.GetUID(),user.GetUserName(),user.GetPassword(),'0');
	    
	    InsertPerson(person);
	}
	protected void InsertAdmin(AdminAttr admin){
		addAdmin(admin);
	    PreparedStatement pstmt = null;
	    try{
	 	pstmt = conn.prepareStatement(ADMIN_INSERT_OPT);
	 	pstmt.setInt(1, admin.GetUID());
	 	pstmt.setString(2, admin.GetName());
	 	pstmt.setString(3, admin.GetEmail());
	 	pstmt.setString(4, admin.GetPassword());
		pstmt.executeUpdate();
		pstmt.close();
       }catch(SQLException e){
	        e.printStackTrace();
       }
	    PersonAttr person = new PersonAttr(admin.GetUID(),admin.GetName(),admin.GetPassword(),'1');
	    
	    InsertPerson(person);
	}
	
	protected void InsertPerson(PersonAttr person){
		addPerson(person);
		PreparedStatement pstmt = null;
	    try{
	 	pstmt = conn.prepareStatement(PERSON_INSERT_OPT);
	 	pstmt.setInt(1, person.GetUid());
	 	pstmt.setString(2, person.GetUserName());
	 	pstmt.setString(3, person.GetPassword());
	 	pstmt.setString(4, person.GetPermission()+" ");
		pstmt.executeUpdate();
		pstmt.close();
       }catch(SQLException e){
	        e.printStackTrace();
       }
		
	}
	
	protected void EditUserPassword(int UID, String pw){
		for(int i=0;i<personArray.size();i++){
			if(personArray.get(i).GetUid()==UID)
				personArray.get(i).SetPassword(pw);
		}
		for(int i=0;i<userArray.size();i++){
			if(userArray.get(i).GetUID()==UID)
				userArray.get(i).update_PW(pw);
		}
		PreparedStatement pstmt_p=null;
		PreparedStatement pstmt_u=null;
		try {
			pstmt_p=conn.prepareStatement(PERSON_UPDATE_PW);
			pstmt_u=conn.prepareStatement(USER_UPDATE_PW);
			pstmt_p.setString(1, pw);
			pstmt_p.setInt(2, UID);
			pstmt_u.setString(1, pw);
			pstmt_u.setInt(2, UID);
			
			pstmt_p.executeUpdate();
			pstmt_u.executeUpdate();
			
			pstmt_p.close();
			pstmt_u.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void EditAdminPassword(int UID, String pw){
		for(int i=0;i<personArray.size();i++){
			if(personArray.get(i).GetUid()==UID)
				personArray.get(i).SetPassword(pw);
		}
		for(int i=0;i<adminArray.size();i++){
			if(adminArray.get(i).GetUID()==UID)
				adminArray.get(i).update_PW(pw);
		}
		PreparedStatement pstmt_p=null;
		PreparedStatement pstmt_u=null;
		try {
			pstmt_p=conn.prepareStatement(PERSON_UPDATE_PW);
			pstmt_u=conn.prepareStatement(ADMIN_UPDATE_PW);
			pstmt_p.setString(1, pw);
			pstmt_p.setInt(2, UID);
			pstmt_u.setString(1, pw);
			pstmt_u.setInt(2, UID);
			
			pstmt_p.executeUpdate();
			pstmt_u.executeUpdate();
			
			pstmt_p.close();
			pstmt_u.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void EditUser(UserAttr user){
		for(int i=0;i<userArray.size();i++){
			if(userArray.get(i).GetUID()==user.GetUID())
				userArray.get(i).update(user);
		}
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(USER_UPDATE_OPT);
			pstmt.setInt(7, user.GetUID());
		 	pstmt.setString(1, user.GetUserName());
		 	pstmt.setString(2, user.GetTel());
		 	pstmt.setString(3, user.GetEmail());
		 	pstmt.setString(4,user.GetSex() + " ");
		 	pstmt.setInt(5,user.GetAge());
		 	pstmt.setString(6, user.GetTrueName());
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void EditAdmin(AdminAttr admin){
		for(int i=0;i<adminArray.size();i++){
			if(adminArray.get(i).GetUID()==admin.GetUID())
				adminArray.get(i).update(admin);
		}
	}
	
	protected void DeleteUser(UserAttr user){
		for(int i=0;i<userArray.size();i++){
			if(userArray.get(i).GetUID()==user.GetUID()){
				userArray.remove(i);
				break;
			}
		}
		for(int i=0;i<personArray.size();i++){
			if(personArray.get(i).GetUid()==user.GetUID()){
				personArray.remove(i);
				break;
			}
		}
		PreparedStatement pstmt_p=null;
		PreparedStatement pstmt_u=null;
		try {
			pstmt_p=conn.prepareStatement(PEROSON_DELETE_OPT);
			pstmt_u=conn.prepareStatement(USER_DELETE_OPT);
			
			pstmt_p.setInt(1, user.GetUID());
			pstmt_u.setInt(1, user.GetUID());
			
			pstmt_p.executeUpdate();
			pstmt_u.executeUpdate();
			
			pstmt_p.close();
			pstmt_u.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected ArrayList<UserAttr> SearchUser_ById(int str){
		ArrayList<UserAttr> result = new ArrayList<UserAttr>();
		for(int i = 0;i < userArray.size(); i++){
			if(userArray.get(i).GetUID()== str){
				result.add(userArray.get(i));
			}
		}
		if(str == -1)return userArray;
		return result;
	}
	protected ArrayList<UserAttr> SearchUser_ByName(String str){
		ArrayList<UserAttr> result = new ArrayList<UserAttr>();
		for(int i = 0;i < userArray.size(); i++){
			if(userArray.get(i).GetUserName().equals(str)){
				result.add(userArray.get(i));
			}
		}
		return result;
	}
	protected ArrayList<UserAttr> SearchUser_ByAge(String str){
		ArrayList<UserAttr> result = new ArrayList<UserAttr>();
		for(int i = 0;i < userArray.size(); i++){
			int age = Integer.parseInt(str);
			if(userArray.get(i).GetAge()== age){
				result.add(userArray.get(i));
			}
		}
		return result;
	}
	protected ArrayList<UserAttr> SearchUser_BySex(char str){
		ArrayList<UserAttr> result = new ArrayList<UserAttr>();
		for(int i = 0;i < userArray.size(); i++){
			if(userArray.get(i).GetSex()== str){
				result.add(userArray.get(i));
			}
		}
		return result;
		
	}
	
	
	protected ArrayList<UserAttr> ShowAllUser(){
		return userArray;
	}
}
