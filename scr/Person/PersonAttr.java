package Person;

public class PersonAttr {
	private int UID;
	private String UserName;
	private String Password;
	private char Permission;
	public PersonAttr(){
		
	}
	public PersonAttr(int uid,String UserName,String Password,char Permission){
		this.UID = uid;
		this.UserName = UserName;
		this.Password = Password;
		this.Permission = Permission;
	}
	public void SetUid(int uid){
		this.UID = uid;
	}
	public int GetUid(){
		return this.UID;
	}
	public void SetUserName(String UserName){
		this.UserName = UserName;
	}
	public String GetUserName(){
		return this.UserName;
	}
	public void SetPassword(String Password){
		this.Password = Password;
	}
	public String GetPassword(){
		return this.Password;
	}
	public void SetPermission(char Permission){
		this.Permission = Permission;
	}
	public char GetPermission(){
		return this.Permission;
	}
	
	
}
