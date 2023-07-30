


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<input type="hidden" id="status" value="<%= request.getAttribute("status") %>" >

	<div class="main">

		<!-- Sing in  Form -->
		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="data:image/png;base64,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" alt="sing up image">
						</figure>
						<a href="registration.jsp" class="signup-image-link">Create an
							account</a>
					</div>

					<div class="signin-form">
						<h2 class="form-title">Sign in</h2>
						<form method="post" action="login" class="register-form"
							id="login-form">
							<div class="form-group">
								<label for="username"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="username" id="username"
									placeholder="Your Name" />
							</div>
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="password" id="password"
									placeholder="Password" />
							</div>
							<div class="form-group">
								<input type="checkbox" name="remember-me" id="remember-me"
									class="agree-term" /> <label for="remember-me"
									class="label-agree-term"><span><span></span></span>Remember
									me</label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signin" id="signin"
									class="form-submit" value="Log in" />
							</div>
						</form>
						<div class="social-login">
							<span class="social-label">Or login with</span>
							<ul class="socials">
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-facebook"></i></a></li>
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-twitter"></i></a></li>
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-google"></i></a></li>
							</ul>
						</div>
						
					</div>
				</div>
			</div>
		</section>
		
	<!-- <c:if test="${not empty sessionScope.message}">
    <div class="alert alert-danger">${sessionScope.message}</div>
</c:if> -->	

	</div>

	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	
	<script type="text/javascript">
	
	var status = document.getElementById("status").value;
	if(status == "failed"){
		swal("Sorry","username or password is wrong", "error");
	}
	
	
	</script>
	
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>