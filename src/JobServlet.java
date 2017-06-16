

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class JobServlet
 */
@WebServlet("/JobServlet")
public class JobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JobServlet() {
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

		String nextUrl="/Skills.jsp";
		String post=request.getParameter("post");
		String position=request.getParameter("position");
		String employer=request.getParameter("employer");
		String startDate=request.getParameter("startYear");
		String endYear=request.getParameter("endYear");
		String dutyOne=request.getParameter("dutyOne");
		String dutyTwo=request.getParameter("dutyTwo");
		Jobs job=new Jobs();

		HttpSession session = request.getSession();



		job= (Jobs)session.getAttribute("jobs");

		job.addJob(position, employer, startDate, endYear, dutyOne, dutyTwo);

		session.setAttribute("jobs", job);



		String yesOrNo=request.getParameter("yesOrNo");
		if( yesOrNo.equalsIgnoreCase("yes")){


			nextUrl="/Jobs.jsp";
			//eduNumber++;
			//session.setAttribute("eduNumber",eduNumber);


		}

		else if ( yesOrNo.equalsIgnoreCase("no")){
			nextUrl="/Skills.jsp";

		}


		getServletContext().getRequestDispatcher(nextUrl).forward(request,response);
	}

}
