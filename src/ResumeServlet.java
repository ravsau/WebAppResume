

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
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
	ArrayList<Education>final_edu = new ArrayList <Education>();
	

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
	
		



		

		session.setAttribute("name", name);
		session.setAttribute("email", email);

		
		Education edu=new Education();
		Jobs job=new Jobs();
		
		
		session.setAttribute("education", edu);
		session.setAttribute("jobs", job);







		
		String nextUrl="/moreEducation.jsp";

		
		

		int eduNumber=1;

		



		getServletContext().getRequestDispatcher(nextUrl).forward(request,response);




	}



	}


