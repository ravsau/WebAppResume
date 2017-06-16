<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>More Education</title>

</head>
<body>

	<h1>${name}</h1>
	<h3>Enter your education information</h3>

	<form action="EducationServlet" method="post">
		Degree : <input type="text" name="Degree"></input>
		<p></p>

		<p></p>
		University: <input type="text" name="University"></input>
		<p></p>

		Graduation year: <input type="text" name="GraduationDateYear"></input>


	<p>Enter More Education?</p>
	
		<input type="radio" name="yesOrNo" value="yes"> Yes
		<input type="radio" name="yesOrNo" value="no" > No
		<input type="submit" value="Submit">
	</form>
</body>
</html>