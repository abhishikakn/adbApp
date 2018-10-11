<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
	<head>
		<title>Home</title>
		<base href = "/"/>	
	</head>
	
	<body>
		<h1>Logout</h1>
		<form action ="login" method="POST">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<c:if test = "${param.err eq true} ">
				<p>
				<strong>incorrect username and password..access denied</strong></p>
				</c:if>
				
				<label>user name:<input type = "text" name = "unm"/> </label>
				<label>password<input type = "password" name = "pwd"/> </label>
				<button>Sign in</button>
		</form>
		
	</body>
</html>