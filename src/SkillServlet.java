

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

/**
 * Servlet implementation class SkillServlet
 */
@WebServlet("/SkillServlet")
public class SkillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
    public SkillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String skill1=request.getParameter("skill1");
		String skillLevel1=request.getParameter("skillLevel1");
		
		String skill2=request.getParameter("skill2");
		String skillLevel2=request.getParameter("skillLevel2");
		
		String skill3=request.getParameter("skill3");
		String skillLevel3=request.getParameter("skillLevel3");
		
		String skill4=request.getParameter("skill4");
		String skillLevel4=request.getParameter("skillLevel4");
		
		String skill5=request.getParameter("skill5");
		String skillLevel5=request.getParameter("skillLevel5");
		
		String skill6=request.getParameter("skill6");
		String skillLevel6=request.getParameter("skillLevel6");
		
		String skill7=request.getParameter("skill7");
		String skillLevel7=request.getParameter("skillLevel7");
		
		String skill8=request.getParameter("skill8");
		String skillLevel8=request.getParameter("skillLevel8");
		
		String skill9=request.getParameter("skill9");
		String skillLevel9=request.getParameter("skillLevel9");
		
		String skill10=request.getParameter("skill10");
		String skillLevel10=request.getParameter("skillLevel10");
		
		
		ArrayList <String>skills= new ArrayList<String>();
		skills.add(skill1+","+skillLevel1+"\n");
		skills.add(skill2+","+skillLevel2+"\n");
		skills.add(skill3+","+skillLevel3+"\n");
		skills.add(skill4+","+skillLevel4+"\n");
	
		skills.add(skill5+","+skillLevel5+"\n");
		skills.add(skill6+","+skillLevel6+"\n");
		skills.add(skill7+","+skillLevel7+"\n");
		skills.add(skill8+","+skillLevel8+"\n");
		skills.add(skill9+","+skillLevel9+"\n");
		skills.add(skill10+","+skillLevel10+"\n");
		
		
		
		
		String nextUrl="/Output.jsp";
		
		HttpSession session = request.getSession();


        Jobs job =new Jobs();
		job= (Jobs)session.getAttribute("jobs");
		
		
		int joblength= job.getLength();
		
		String jobsData="";  //This will go to the database
		
		for (int i=0;i<joblength;i++){
			
			jobsData+=(job.getJob().get(i))+"<br>";
			
		}
		
		 Education edu =new Education();
			edu= (Education)session.getAttribute("education");
			
			
			int edulength= edu.getLength();
			
			String eduData="";  //This will go to the database
			
			for (int i=0;i<edulength;i++){
				
				eduData+=(edu.getEdu().get(i))+"<br>";
				
			}
			
			String skillData="";
			int skillSize=skills.size();
			for (int i=0;i<joblength;i++){
				
				if (skills.get(i)!=null)
				
				skillData+=(skills.get(i))+"<br>";
				
			}
			
			
			session.setAttribute("eduData", eduData);

			session.setAttribute("jobsData", jobsData);

			session.setAttribute("skillData", skillData);

			
		try {
			// This will load the MySQL driver, each DB has its own driver
			// The MySQL driver is a JAR file that must be in the Build Path
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/Resume?user=root&password=password");


		
            String name= (String) session.getAttribute("name");
            String email= (String) session.getAttribute("email");
            
            
			preparedStatement = connect
					.prepareStatement("INSERT INTO UserInfo (Name, Email,Education,WorkExperience,Skill) VALUES(?,?,?,?,?)");

			// "myuser, webpage, , summary, COMMENTS from feedback.comments");
			// Parameters start with 1
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, eduData);
			preparedStatement.setString(4, jobsData);
			preparedStatement.setString(5, skillData);
			preparedStatement.executeUpdate();
			
			Statement st = connect.createStatement();
			String sql = ("SELECT * FROM UserInfo ;");
			ResultSet rs = st.executeQuery(sql);
			
			 String databaseName="";
			 
			 String  databaseEmail="" ;
			 String  databaseWorkExperience="" ;
			 String  databaseEducation="" ;
			 String  databaseSkills="";
			if(rs.next()) { 
			 
			databaseName = rs.getString("Name");
			databaseEmail = rs.getString("Email");
			databaseWorkExperience= rs.getString("WorkExperience");
			databaseEducation=rs.getString("Education");
			databaseSkills=rs.getString("Skill");
			
		}
			
			
		
			/*preparedStatement=connect.prepareStatement("select * from UserInfo Where UserID=1 ");
			 resultSet = preparedStatement.executeQuery();
			 
			 String  databaseName = resultSet.getString("Name");
			 String  databaseEmail = resultSet.getString("Email");
			 String  databaseWorkExperience = resultSet.getString("WorkExperience");
			 String  databaseEducation = resultSet.getString("Education");
			 String  databaseSkills = resultSet.getString("Skill");
			 
			 */
			 
			 
			 //This is where I set the session variable to be used to print on resume. The data is retrieved from the database.
			 session.setAttribute("resumeName", databaseName);
			 session.setAttribute("resumeEmail", databaseEmail);
			 session.setAttribute("resumeWork", databaseWorkExperience);
			 session.setAttribute("resumeEdu", databaseEducation);
			 session.setAttribute("resumeSkill", databaseSkills);



		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			close(); 
		}
		
		
			
			//---------------------------------------------------------------
			
			
			
		

		getServletContext().getRequestDispatcher(nextUrl).forward(request,response);
	}
	
	
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}


}
