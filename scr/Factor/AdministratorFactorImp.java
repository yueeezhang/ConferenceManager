package Factor;

import java.util.ArrayList;

import Conference.ApplyDetailAttr;
import Conference.ConferenceAttr;
import Person.AdminAttr;
import Person.UserAttr;

public class AdministratorFactorImp implements AdministratorFactor{
	private Factor factor;
	public AdministratorFactorImp(){
		factor = Factor.GetInstance();
	}
	
	public void InsertConf(ConferenceAttr conf) {
		factor.InsertConf_ByAdmin(conf);
	}
	
	public void DelConf(int CID) {
		factor.DelConf_ByAdmin(CID);
	}
	public void EditConf(ConferenceAttr conf) {
		factor.EditConf_ByAdmin(conf);
	}
	public ArrayList<UserAttr> SearchUser(String req,String str){
		
		return factor.SearchUser(req,str);
	}
	public ArrayList<ConferenceAttr> SearchConf(String req, String str) {
		return factor.SearchConf_ByPerson(req, str);
	}
	public ConferenceAttr ViewConfDetail(int CID) {
		return factor.ViewConfDetail_ByPerson(CID);
	}
	public ArrayList<ApplyDetailAttr> ViewApplyDetail(int CID) {
		return factor.ViewApplyDetail(CID);
	}
	public void EditUser(UserAttr user) {
		factor.EditUser(user);
	}
	public void DelUser(UserAttr user) {
		factor.DelUser(user);
	}
	public int GetNowCID() {
		return factor.GetNowCID();
	}
	public int GetNowUID() {
		return factor.GetNowUID();
	}

	public void EditInfo(AdminAttr admin) {
		factor.EditAdmin(admin);
	}

	public void EditPaWd(int UID, String pw) {
		factor.EditAdminPW(UID, pw);
	}

	public ArrayList<ConferenceAttr> ShowAllConf() {
		return factor.ShowAllConf();
	}

	public UserAttr SearchUser(String name) {
		return factor.SearchUser(name);
	}

	public ArrayList<UserAttr> ShowAllUser() {
		return factor.ShowAllUser();
	}
	public ArrayList<ApplyDetailAttr> ViewUserApply(int UID) {
		return factor.ViewApplyHistory(UID);
	}

	public ConferenceAttr SearchConf(int CID) {
		return factor.SearchConf(CID);
	}
	
	public ArrayList<ApplyDetailAttr> ViewApplyDetail_ByName(String name){
		return factor.ViewApplyDetailByName_ByAdmin(name);
	}

	
}
