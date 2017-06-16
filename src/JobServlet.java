

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EducationServlet
 */
@WebServlet("/EducationServlet")
public class JobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JobServlet() {
		super();

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
		String post=request.getParameter("post");
		String position=request.getParameter("position");
		String employer=request.getParameter("employer");
		String startDate=request.getParameter("startYear");
		String endYear=request.getParameter("endYear");
		String dutyOne=request.getParameter("dutyOne");
		String dutyTwo=request.getParameter("dutyTwo");
		
		
		String nextUrl="/moreEducation.jsp";
		Education edu = new Education();
		HttpSession session = request.getSession();
		//session.getAttribute("eduNumber");
		
		
		
		


		System.out.println(edu.getEdu());
		String yesOrNo=request.getParameter("yesOrNo");
		if( yesOrNo.equalsIgnoreCase("yes")){


			nextUrl="/moreEducation.jsp";
			//eduNumber++;
			//session.setAttribute("eduNumber",eduNumber);


		}

		else if ( yesOrNo.equalsIgnoreCase("no")){
			nextUrl="/Jobs.jsp";

		}

		getServletContext().getRequestDispatcher(nextUrl).forward(request,response);
	}

}
