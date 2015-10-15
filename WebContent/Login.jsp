<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Auction-Login</title>
<script type="text/javascript">
	function runScript(form) {
		enabledCookies();
		checkField(form);
	}

	function enabledCookies() {
		var cookieEnabled = (navigator.cookieEnabled) ? true : false;
		if (typeof navigator.cookieEnabled == "undefined" && !cookieEnabled) {
			document.cookie = "testcookie";
			cookieEnabled = (document.cookie.indexOf("testcookie") != -1) ? true
					: false;
		}
		return (cookieEnabled) ? true : alert("To use this site you must have enabled cookies. Please check your browser settings.");
	}

	function checkField(form) {
		if (form.user.value == "") {
			alert("Field 'Username' is empty");
			return false;
		} else if (form.pwrd.value == "") {
			alert("Field 'Password' is empty");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<form name="login" action="LoginServlet" method="post" onsubmit="runScript(this)">
		Username: <input type="text" name="user"> <br> Password:
		<input type="password" name="password"> <br> <input
			type="submit" value="Login" name="button">
	</form>
</body>
</html>