package Conference;

public class ApplyDetailAttr {
	private int UID;
	private int CID;
	private int TrainNum;
	private String InvHead;
	private String InvCon;
	private String Hotel;
	private String Remark;
	
	public ApplyDetailAttr(){}
	public ApplyDetailAttr(ApplyDetailAttr ap){
		this.UID = ap.GetUID();
		this.CID = ap.GetCID();
		this.TrainNum = ap.GetTrainNum();
		this.InvHead = ap.GetInvHead();
		this.InvCon = ap.GetInvCon();
		this.Hotel = ap.GetHotel();
		this.Remark = ap.GetRemark();
	}
	public ApplyDetailAttr(int UID,int CID,int TrainNum,String InvHead
			,String InvCon,String Hotel,String Remark){
		this.UID = UID;
		this.CID = CID;
		this.TrainNum = TrainNum;
		this.InvHead = InvHead;
		this.InvCon = InvCon;
		this.Hotel = Hotel;
		this.Remark = Remark;
	}
	
	public void update(ApplyDetailAttr met){
		this.TrainNum = met.GetTrainNum();
		this.InvHead = met.GetInvHead();
		this.InvCon = met.GetInvCon();
		this.Hotel =met.GetHotel();
		this.Remark = met.GetRemark();
	}
	public void SetUID(int UID){
		this.UID = UID;
	}
	public int GetUID(){
		return this.UID;
	}
	public void SetCID(int CID){
		this.CID = CID;
	}
	public int GetCID(){
		return this.CID;
	}
	public void SetTrainNum(int TrainNum){
		this.TrainNum = TrainNum;
	}
	public int GetTrainNum(){
		return this.TrainNum;
	}
	public void SetInvHead(String InvHead){
		this.InvHead = InvHead;
	}
	public String GetInvHead(){
		return this.InvHead;
	}
	public void SetInvCon(String InvCon){
		this.InvCon = InvCon;
	}
	public String GetInvCon(){
		return this.InvCon;
	}
	public void SetHotel(String Hotel){
		this.Hotel = Hotel;
	}
	public String GetHotel(){
		return this.Hotel;
	}
	public void SetRemark(String Remark){
		this.Remark = Remark;
	}
	public String GetRemark(){
		return this.Remark;
	}
	
}
