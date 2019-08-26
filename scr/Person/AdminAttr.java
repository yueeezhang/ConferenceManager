package Person;

public class AdminAttr {
	private int UID;
	private String Name;
	private String AEmail;
	private String Password;
	public AdminAttr(int UID,String Name,String AEmail,String Password){
		this.UID = UID;
		this.Name = Name;
		this.AEmail = AEmail;
		this.Password = Password;
	}
	public AdminAttr(int UID,String Name,String AEmail){
		this.UID = UID;
		this.Name = Name;
		this.AEmail = AEmail;
		this.Password=null;
	}
	public void SetUID(int UID){
		this.UID = UID;
	}
	public int GetUID(){
		return this.UID;
	}
	
	public void SetName(String Name){
		this.Name = Name;
	}
	public String GetName(){
		return this.Name;
	}
	
	public void SetEmail(String Email){
		this.AEmail = Email;
	}
	public String GetEmail(){
		return this.AEmail;
	}
	
	public void SetPassword(String Password){
		this.Password = Password;
	}
	public String GetPassword(){
		return this.Password;
	}
	public void update(AdminAttr admin) {	//此处更新不会改变密码
		this.AEmail = admin.GetEmail();
	}
	public void update_PW(String pw){
		this.Password=pw;
	}
}
