package Factor;

import java.util.ArrayList;

import Conference.ApplyDetailAttr;
import Conference.ConferenceAttr;
import Person.PersonAttr;
import Person.UserAttr;

public interface UserFactor {
	public void InsertUser(UserAttr user);	//ok
	public void EditApply(ApplyDetailAttr apply);	//根据报名会议来修改自己的报名信息
	public void EditPersonalData(UserAttr user);	//ok
	
	public void AttendMeeting(ApplyDetailAttr apply, ConferenceAttr conf);
	public void CancleApply(int UID ,int CID, ConferenceAttr conf);
	
	public ArrayList<ConferenceAttr> SearchConf(String req, String str);
	public ConferenceAttr ViewConfApply(int CID);
	public ArrayList<ApplyDetailAttr> ViewApplyHistory(int UID);
	public PersonAttr SearchPerson(String username);
	public UserAttr SearchUser(String username);
	public ArrayList<ConferenceAttr> ShowAllConf(int UID);
	public ArrayList<UserAttr> ShowAllUser();
	public int GetNowUID();
	public ArrayList<ConferenceAttr> GetRecommend(int UID);//推荐小于3个
	public boolean ApplyOrNot(int UID,int CID);
}