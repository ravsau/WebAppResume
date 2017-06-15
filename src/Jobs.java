import java.util.ArrayList;

public class Jobs {


	private ArrayList jobs;
	private String position;
	private String employer;
	private String startDate;
	private String endDate;
	private String dutyOne;
	private String dutyTwo;




	public Jobs(){



	}


	public void addJob(String position, String employer,String startDate,String endDate, String dutyOne,String dutyTwo){

		jobs.add(position+"\n"+employer+","+startDate+"-"+endDate+"\n"+"duty 1 : "+dutyOne+"\n"+"duty 2 : "+dutyTwo);


	}

	public ArrayList getEdu(){

		return jobs;

	}

	public int getLength(){

		return jobs.size();
	}


}
