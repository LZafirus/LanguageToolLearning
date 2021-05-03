
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
	<head>
		<title>Adding</title>
		
		<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css">
		
		<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/add-style.css">
	
	</head>

	<body>
		<div id="wrapper">
		<div id="header">
		<h2>Add a word to dictionary</h2>
		
		</div>
	</div>
			<div id="container">
			<h3>Word adding:</h3>
			<form:form action="saveWord" modelAttribute="words" method="POST">	
				
			<form:hidden path="id" />	
				
				<table>
					<tbody>
						<tr>
							<td><form:label path="polishWord">Polish word:</form:label></td>
							<td><form:input path="polishWord"/></td>
						</tr>
						
						<tr>
							<td><form:label path="foreignWord">Foreign word:</form:label></td>
							<td><form:input path="foreignWord"/></td>
						</tr>
						
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save"/></td>
						</tr>
						
						<tr>
							<td><label></label></td>
							<td><input type="button" value="Close" 
								onclick="window.close()" 
								class="close-button"/></td>
						</tr>
						
					</tbody>
				</table>
			
			<div style="clear; both'"></div>
			
			</form:form>
		</div>
	</body>

</html>