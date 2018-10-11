<html>
	<head>
		<title>Home</title>
		<base href = "/"/>	<!-- all links that we use should be done fromroot -->
	</head>
	
	<body>
		<h1>Welcome</h1>
	
	<c:choose>
			<c:when test = "${currentUserName ne null }">
				<strong>Welcome! ${currentUserName }</strong>
				<a href ="logout">Sign out</a>
			</c:when>
			<c:otherwise>
				<a href="login">sign in</a>
			</c:otherwise>
	</c:choose>
<!-- if user not logged in ask him  -->	
			
	</body>
</html>