package Person;

public class UserAttr {
	private int UID;
	private String UserName;
	private String TrueName;
	private String Tel;
	private char Sex;	// m -> male    f -> female
	private int Age;
	private String Email;
	private String Password;
	public UserAttr(){}
	public UserAttr(int UID,String UserName,String TrueName,String Tel,
			char Sex,int Age,String Email,String Password){
		this.UID = UID;
		this.UserName = UserName;
		this.TrueName = TrueName;
		this.Tel = Tel;
		this.Sex = Sex;
		this.Age = Age;
		this.Email = Email;
		this.Password = Password;
	}
	public UserAttr(int UID,String UserName,String TrueName,String Tel,
			char Sex,int Age,String Email){
		this.UID = UID;
		this.UserName = UserName;
		this.TrueName = TrueName;
		this.Tel = Tel;
		this.Sex = Sex;
		this.Age = Age;
		this.Email = Email;
		this.Password = null;
	}
	public void SetUID(int UID){
		this.UID = UID;
	}
	public int GetUID(){
		return this.UID;
	}
	public void SetUserName(String UserName){
		this.UserName = UserName;
	}
	public String GetUserName(){
		return this.UserName;
	}
	public void SetTrueName(String TrueName){
		this.TrueName = TrueName;
	}
	public String GetTrueName(){
		return this.TrueName;
	}
	public void SetTel(String Tel){
		this.Tel = Tel;
	}
	public String GetTel(){
		return this.Tel;
	}
	public void SetSex(char Sex){
		this.Sex = Sex;
	}
	public char GetSex(){
		return this.Sex;
	}
	public void SetAge(int Age){
		this.Age = Age;
	}
	public int GetAge(){
		return this.Age;
	}
	public void SetEmail(String Email){
		this.Email = Email;
	}
	public String GetEmail(){
		return this.Email;
	}
	public void SetPassword(String Password){
		this.Password = Password;
	}
	public String GetPassword(){
		return this.Password;
	}
	public void update(UserAttr user) {	//此处更新不会改变密码
		this.UserName = user.GetUserName();
		this.TrueName = user.GetTrueName();
		this.Tel = user.GetTel();
		this.Sex = user.GetSex();
		this.Age = user.GetAge();
		this.Email = user.GetEmail();
	}
	public void update_PW(String pw){
		this.Password=pw;
	}
}
