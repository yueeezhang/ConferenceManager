package Factor;

import java.util.ArrayList;

import Conference.ApplyDetailAttr;
import Conference.ConferenceAttr;
import Person.AdminAttr;
import Person.UserAttr;

public interface AdministratorFactor {
	public void InsertConf(ConferenceAttr conf);
	public void DelConf(int CID);
	public void EditConf(ConferenceAttr conf);
	
	public ArrayList<ConferenceAttr> SearchConf(String req,String str);
	public ConferenceAttr ViewConfDetail(int CID);
	public ArrayList<ApplyDetailAttr> ViewApplyDetail(int CID);
	public ArrayList<ApplyDetailAttr> ViewUserApply(int UID);
	public ArrayList<ConferenceAttr> ShowAllConf();
	public ArrayList<UserAttr>ShowAllUser();
	public ArrayList<ApplyDetailAttr> ViewApplyDetail_ByName(String name);
	public void EditUser(UserAttr user);
	public void DelUser(UserAttr user);
	public int GetNowCID();
	public int GetNowUID();
	
	public void EditInfo(AdminAttr admin);
	public void EditPaWd(int UID, String pw);
	public UserAttr SearchUser(String name);
	public ConferenceAttr SearchConf(int CID);
	
}
