import java.util.ArrayList;

public class Education {


	private ArrayList edu;
	private String major;
	private String schoolName;
	private String gradYear;



	public Education(){



	}


	public void addEducation(String major, String schoolName,String gradYear){

		edu.add(major+"\n"+schoolName+","+gradYear);


	}

	public ArrayList getEdu(){

		return edu;

	}

	public int getLength(){

		return edu.size();
	}


}
