import java.util.ArrayList;

public class Skills {


	private ArrayList skills;
	private String skill;





	public Skills(){

		skills=new ArrayList();



	}


	public void addSkill(String skill){

		skills.add(skill+"\n");


	}

	public ArrayList getSkill(){

		return skills;

	}
	
	public int getLength(){
		
		return skills.size();
	}


}
