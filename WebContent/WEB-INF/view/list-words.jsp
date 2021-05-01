<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
	<title>Dictionary</title>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2> Full dictionary</h2>
		</div>
	</div>
	
	<input type="button" value="Add a word"	
					onclick="window.open(href='addWordForm','','location=yes,height=570,width=520,scrollbars=yes,status=yes')"
					class="add-button"
	/>
	
	<div id="container">
		<div id="content">
			
			<table>
				<tr>
					<th>Polish word: </th>
					<th>Foreign word: </th>
					<th>Action: </th>	
				</tr>
			<c:forEach var="tempWord" items="${words}">
				
				<c:url var="updateLink" value="/words/updateWordForm">
					<c:param name="wordId" value="${tempWord.id}"/>
				</c:url>
				
				<c:url var="deleteLink" value="/words/deleteWord">
					<c:param name="wordId" value="${tempWord.id}"/>
				</c:url>
				
				<tr>
					<td>${tempWord.polishWord}</td>
					<td>${tempWord.foreignWord}</td>
					<td>
						<a href="${updateLink}">Update</a>
						|
						<a href="${deleteLink}"
						onclick="if (!(confirm('Are you sure you want to remove this item?'))) return false">Delete</a>
					</td>
				</tr>
			
			</c:forEach>
			</table>
		</div>
	</div>
	
	
</body>

</html>