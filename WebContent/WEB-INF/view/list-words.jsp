<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
		
			<h2> Title here..</h2>
		</div>
	
	</div>
	
	<div id="container">
	
		<div id="content">
			
			<table>
				<tr>
					<th>Polish: </th>
					<th>Foreign: </th>	
				</tr>
			<c:forEach var="tempWord" items="${words}">
			
				<tr>
					<td>${tempWord.polishWord}</td>
					<td>${tempWord.foreignWord}</td>
				</tr>
			
			</c:forEach>
			</table>
		
		</div>
	
	</div>
	
</body>

</html>