package Conference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Category {
	private Map<String,ArrayList<ConferenceAttr>> mp;
	public Category(){
		mp = new HashMap<String,ArrayList<ConferenceAttr>>();
	}
	public ArrayList<ConferenceAttr> getConference(String sort){
		return mp.get(sort);
	}
	public int getNum(String sort){
		return mp.get(sort).size();
	}
	
}
