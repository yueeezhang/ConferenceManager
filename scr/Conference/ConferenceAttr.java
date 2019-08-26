package Conference;


public class ConferenceAttr{
	
	private int CID;
	private String CName;
	private String StartTime;
	private String City;
	private String EndTime;
	private int Members;
	private String Tel;
	private String Email;
	private String Organizer;
	private String Addr;
	private String Intro;
	private char EndOrNot;
	private int MemLimit;
	private String Category;
	ConferenceAttr(){}
	public ConferenceAttr(ConferenceAttr conf){
		this.CID = conf.GetCID();
		this.CName = conf.GetCName();
		this.StartTime = conf.GetStartTime();
		this.City = conf.GetCity();
		this.Members = conf.GetMembers();
		this.EndTime=conf.GetEndTime();
		this.Tel = conf.GetTel();
		this.Email = conf.GetEmail();
		this.Organizer = conf.GetOrganizer();
		this.Addr = conf.GetAddr();
		this.Intro = conf.GetIntro();
		this.EndOrNot = conf.GetEndOrNot();
		this.MemLimit = conf.GetMemLimit();
		this.Category = conf.GetCategory();
	}
	public ConferenceAttr(int CID,String CName,String StartTime,String City,int Members,String EndTime,String Tel
			,String Email,String Organizer,String Addr,String Intro,char EndOrNot
			,int MemLimit){
		this.CID = CID;
		this.CName = CName;
		this.StartTime = StartTime;
		this.City = City;
		this.Members = Members;
		this.EndTime=EndTime;
		this.Tel = Tel;
		this.Email = Email;
		this.Organizer = Organizer;
		this.Addr = Addr;
		this.Intro = Intro;
		this.EndOrNot = EndOrNot;
		this.MemLimit = MemLimit;
	}
	public ConferenceAttr(int CID,String CName,String StartTime,String City,int Members,String EndTime,String Tel
			,String Email,String Organizer,String Addr,String Intro,char EndOrNot
			,int MemLimit,String Category){
		this.CID = CID;
		this.CName = CName;
		this.StartTime = StartTime;
		this.City = City;
		this.Members = Members;
		this.EndTime=EndTime;
		this.Tel = Tel;
		this.Email = Email;
		this.Organizer = Organizer;
		this.Addr = Addr;
		this.Intro = Intro;
		this.EndOrNot = EndOrNot;
		this.MemLimit = MemLimit;
		this.Category = Category;
	}
	public void update(ConferenceAttr confr){
		this.CID = confr.GetCID();
		this.CName = confr.GetCName();
		this.StartTime = confr.GetStartTime();
		this.City = confr.GetCity();
		this.Members = confr.GetMembers();
		this.EndTime=confr.GetEndTime();
		this.Tel = confr.GetTel();
		this.Email = confr.GetEmail();
		this.Organizer = confr.GetOrganizer();
		this.Addr = confr.GetAddr();
		this.Intro = confr.GetIntro();
		this.EndOrNot = confr.GetEndOrNot();
		this.MemLimit =confr.GetMemLimit();
		this.Category=confr.GetCategory();
	}
	public void SetCID(int CID){
		this.CID = CID;
	}
	public int GetCID(){
		return this.CID;
	}
	public void SetCName(String CName){
		this.CName = CName;
	}
	public String GetCName(){
		return this.CName;
	}
	public void SetStartTime(String StartTime){
		this.StartTime = StartTime;
	}
	public String GetStartTime(){
		return this.StartTime;
	}
	public void SetCity(String City){
		this.City = City;
	}
	public String GetCity(){
		return this.City;
	}
	public String GetEndTime(){
		return this.EndTime;
	}
	public void SetEndTime(String EndTime){
		this.EndTime=EndTime;
	}
	public void SetMembers(int Members){
		this.Members = Members;
	}
	public int GetMembers(){
		return this.Members;
	}
	public void SetTel(String Tel){
		this.Tel = Tel;
	}
	public String GetTel(){
		return this.Tel;
	}
	public void SetEmail(String Email){
		this.Email = Email;
	}
	public String GetEmail(){
		return this.Email;
	}
	public void SetOrganizer(String Organizer){
		this.Organizer = Organizer;
	}
	public String GetOrganizer(){
		return this.Organizer;
	}
	public void SetAddr(String Addr){
		this.Addr = Addr;
	}
	public String GetAddr(){
		return this.Addr;
	}
	public void SetIntro(String Intro){
		this.Intro = Intro;
	}
	public String GetIntro(){
		return this.Intro;
	}
	public void SetEndOrNot(char EndOrNot){
		this.EndOrNot = EndOrNot;
	}
	public char GetEndOrNot(){
		return this.EndOrNot;
	}
	public void SetMemLimit(int MemLimit){
		this.MemLimit = MemLimit;
	}
	public int GetMemLimit(){
		return this.MemLimit;
	}
	public void SetCategory(String Category){
		this.Category=Category;
	}
	public String GetCategory(){
		return this.Category;
	}
	public void AddMembers(){
		Members++;
	}
	public void SubstactMembers(){
		Members--;
	}
}
