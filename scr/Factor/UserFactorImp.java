package Factor;

import java.util.ArrayList;
import Conference.ApplyDetailAttr;
import Conference.ConferenceAttr;
import Person.PersonAttr;
import Person.UserAttr;

public class UserFactorImp implements UserFactor{
	private Factor factor;
	public  UserFactorImp(){
		factor = Factor.GetInstance();
	}
	public void InsertUser(UserAttr user) {
		factor.InsertUesr(user);
	}
	public void EditApply(ApplyDetailAttr apply) {
		factor.EditApply(apply);
	}
	public void EditPersonalData(UserAttr user) {
		factor.EditUser(user);
	}
	public void AttendMeeting(ApplyDetailAttr apply, ConferenceAttr conf) {
		factor.AttendConf(apply, conf);
	}
	public void CancleApply(int UID ,int CID, ConferenceAttr conf) {
		factor.CancleApply(UID, CID, conf);
	}
	public ArrayList<ConferenceAttr> SearchConf(String req, String str) {
		return factor.SearchConf_ByPerson(req, str);
	}
	public ConferenceAttr ViewConfApply(int CID) {
		return factor.ViewConfDetail_ByPerson(CID);
	}
	public ArrayList<ApplyDetailAttr> ViewApplyHistory(int UID) {
		return factor.ViewApplyHistory(UID);
	}
	public PersonAttr SearchPerson(String name) {
		return factor.SearchPerson(name);
	}
	public UserAttr SearchUser(String username) {
		return factor.SearchUser(username);
	}
	public int GetNowUID() {
		return factor.GetNowUID();
	}
	public ArrayList<ConferenceAttr> ShowAllConf(int UID) {
		return factor.ShowAllOpenNotAttendConf(UID);
	}
	public ArrayList<UserAttr> ShowAllUser() {
		return factor.ShowAllUser();
	}
	public ArrayList<ConferenceAttr> GetRecommend(int UID){
		return factor.Recommend(UID);
	}
	public boolean ApplyOrNot(int UID,int CID){
		return factor.ApplyOrNot(UID,CID);
	}
}
