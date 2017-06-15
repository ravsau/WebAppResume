

import java.io.IOException;
import java.sql.*;

import java.util.Date;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.OutputBuffer;

/**
 * Servlet implementation class ResumeServlet
 */
@WebServlet("/ResumeServlet")
public class ResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
	private String lastName;
	private int counter =0;
	Scanner sc=new Scanner(System.in);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResumeServlet() {
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
		
		HttpSession session = request.getSession();
		
		String name=request.getParameter("name"); 
		String email=request.getParameter("email"); 
		
		System.out.println(name);
		try {
			// This will load the MySQL driver, each DB has its own driver
			// The MySQL driver is a JAR file that must be in the Build Path
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/Resume?user=root&password=password");

			

            
		    preparedStatement = connect
                    .prepareStatement("INSERT INTO UserInfo (Name, Email,Education,WorkExperience,Skill) VALUES(?,?,?,?,?)");

            // "myuser, webpage, , summary, COMMENTS from feedback.comments");
            // Parameters start with 1
            preparedStatement.setString(1, "bart simpson");
            preparedStatement.setString(2, "mail@domain.com");
            preparedStatement.setString(3, "www.domain.com");
            preparedStatement.setString(4, "ytyty");
            preparedStatement.setString(5, "ytyty");
            preparedStatement.executeUpdate();
            

				
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
	
		
		getServletContext().getRequestDispatcher("/moreEducation.jsp").forward(request,response);

	}

	

	private void writeResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		int choice=1;
		String newStreet;
		String newCity;
		String newState;
		String newZip;
		while (resultSet.next() && choice==1) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			String customerId = resultSet.getString("CustumerID");
			String fullName = resultSet.getString("FullName");
			

			
			System.out.println("Customer ID: " + customerId);
			System.out.println("Name: " + fullName);

			System.out.println("Press 1 to move to another person with the same last name. Press 2 to change the address");

	        

			choice=sc.nextInt();
			 sc.nextLine();
			if (choice==2){
				
			
 
				System.out.println("Enter the new Street Address of the person");

				newStreet=sc.nextLine();
			
				System.out.println("Enter the new City of the person");
		
				

				newCity=sc.nextLine();
			
				System.out.println("Enter the new State of the person");
		

				newState=sc.nextLine();
			
				System.out.println("Enter the new ZIP code of the person");
				
				newZip=sc.nextLine();
				preparedStatement = connect
	                    .prepareStatement("UPDATE   customer.Customers SET StreetAddress=?, City=?, State=?,"
	                    		+ " ZipCode=? WHERE customer.Customers.CustumerID='"+customerId+"'");
	                    		
				
				preparedStatement.setString(1, newStreet);
	            preparedStatement.setString(2, newCity);
	            preparedStatement.setString(3, newState);
	            preparedStatement.setString(4, newZip);
	            preparedStatement.executeUpdate();
				
				
		
				

			}





			
		}
	}


	// You need to close the resultSet
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
