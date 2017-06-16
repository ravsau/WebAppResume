<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Work Experience</title>
</head>
<body>
	<h3>Enter your information below.</h3>
	<form action="JobServlet" method="post">

		<b> Work Experience</b>

		Position : <input type="text" name="position"></input>
		<p></p>



		Employer: <input type="text" name="employer"></input>
		<p></p>

		Start Date: <input type="text" name="startYear"></input><br> End Date: <input
			type="text" name="endYear"></input> <br>Job Duty 1: <input type="text"
			name="dutyOne"></input> <br>Job Duty 2: <input type="text" name="dutyTwo"></input>





	<p>Enter More Jobs?</p>
	
		<input type="radio" name="yesOrNo" value="Yes"> Yes<br> <input
			type="radio" name="yesOrNo" value="No"> No<br> <input
			type="submit" value="Submit">
	</form>

</body>
</html>