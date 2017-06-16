

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
public class EducationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EducationServlet() {
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
		String degree=request.getParameter("Degree");
		String university=request.getParameter("University");
		String graduationDate=request.getParameter("GraduationDateYear");
		String nextUrl="/moreEducation.jsp";
		Education edu = new Education();


		HttpSession session = request.getSession();
        
		
		
		edu= (Education)session.getAttribute("education");

		edu.addEducation(degree, university, graduationDate);


		session.setAttribute("education", edu);










//&& edu.getLength()<10


		System.out.println(edu.getEdu());
		String yesOrNo=request.getParameter("yesOrNo");
		if (yesOrNo.isEmpty()){
			
			yesOrNo="no";
		}
		
		System.out.println(edu.getLength());
		if( yesOrNo.equalsIgnoreCase("yes")){


			nextUrl="/moreEducation.jsp";
			//eduNumber++;
			//session.setAttribute("eduNumber",eduNumber);


		}

		else if ( yesOrNo.equalsIgnoreCase("no")){
			nextUrl="/Jobs.jsp";

		}
		
		else {
			
			nextUrl="/Jobs.jsp";
		}

		getServletContext().getRequestDispatcher(nextUrl).forward(request,response);
	}

}
