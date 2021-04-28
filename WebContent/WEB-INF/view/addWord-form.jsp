<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
	<head>
		<title>Adding word..</title>
		
		<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css">
		
		<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
	
	</head>

	<body>
		<h2>Adding a word to your dictionary..</h2>
		
		<div>
			<form:form action="saveWord" modelAttribute="word" method="POST">	
				
				<form:hidden path="id"/>
				
				<table>
					<tbody>
						<tr>
							<td><label>Polish word:</label></td>
							<td><form:input path="polishWord"/></td>
						</tr>
						
						<tr>
							<td><label>Foreign word:</label></td>
							<td><form:input path="foreignWord"/></td>
						</tr>
					</tbody>
				</table>
			
			<div style="clear; both'"></div>
			
			<p>
				<a href="${pageContext.request.contextPath}/words/list">Back to dictionary</a>
			</p>
			
			</form:form>
		</div>
	</body>

</html>