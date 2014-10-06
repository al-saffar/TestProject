<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NumberGuess</title>


<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/bootstrap.min.css">
<style>
body {
	padding-top: 50px;
	padding-bottom: 20px;
}
</style>
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/main.css">

<script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>

</head>
<body>

	<!--[if lt IE 7]>
            <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
	<div id="fade"></div>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">NumberGuess</a>
			</div>
			<div class="navbar-collapse collapse">
				<form class="navbar-form navbar-right" role="form" name="LoginServlet" method="post" action="LoginServlet">
					<div class="form-group">
						<input type="text" name="username" placeholder="Username" class="form-control">
					</div>
					<div class="form-group">
						<input type="password" name="password" placeholder="Password" class="form-control">
					</div>

					<button type="submit" class="btn btn-success">Log in</button>
				</form>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</div>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		
		<div class="container">
			<div id="infoBox" style="color:green;"></div>
			<h1>Welcome to NumberGuess!</h1>
			<p>Here you can play a Random number guess game and challenge
				your friends :)</p>
			<p>
				<a class="btn btn-primary btn-lg" role="button"
					onclick=displayPopUp();> Create User &raquo;</a>
			</p>
		</div>
	</div>

	<div class="container">
		<form name="CreateUserServlet" method="post"
			action="CreateUserServlet">
			<div id="createUser">
				<h3 style="text-align: center">Create User</h3>
				<div style="float: left; margin-left: 25px;">
					<br>
					<table>
						<tbody>
							<tr>
								<th>* Firstname:</th>
								<th>* Lastname:</th>
							</tr>
							<tr>
								<td><input class="form-control" type="text"
									name="firstname" placeholder="Type firstname" value="<%if(request.getParameter("f") != null) out.println(request.getParameter("f")); %>"></td>
								<td><input class="form-control" type="text" name="lastname"
									placeholder="Type lastname" value="<%if(request.getParameter("l") != null) out.println(request.getParameter("l")); %>"></td>
							</tr>
							<br>
							<tr>
								<th>* Username:</th>
								<th>* Password:</th>
							</tr>
							<tr>
								<td><input class="form-control" type="text" name="username"
									placeholder="Type username" value="<%if(request.getParameter("u") != null && !request.getParameter("err").equals("user")) out.println(request.getParameter("u")); %>"></td>
								<td><input class="form-control" type="text" name="pw"
									placeholder="Type password"></td>
							</tr>
						</tbody>
					</table>
				</div>
				<br>

				<div style="float: right; margin-right: 20px;">

					<br> <input class="btn btn-success" type="submit"
						name="button" value="Create user"> <input
						class="btn btn-default" style="margin-left: 0px" type="button"
						name="button" value="Close" onClick="closePopUp()">
				</div>
		</form>
	</div>
	<!-- Example row of columns -->
	<div class="row">
		<div class="col-md-4">
			<h2>1.</h2>
			<p>Donec id elit non mi porta gravida at eget metus. Fusce
				dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
				ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
				magna mollis euismod. Donec sed odio dui.</p>
			<p>
				<a class="btn btn-default" href="#" role="button">View details
					&raquo;</a>
			</p>
		</div>
		<div class="col-md-4">
			<h2>2.</h2>
			<p>Donec id elit non mi porta gravida at eget metus. Fusce
				dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
				ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
				magna mollis euismod. Donec sed odio dui.</p>
			<p>
				<a class="btn btn-default" href="#" role="button">View details
					&raquo;</a>
			</p>
		</div>
		<div class="col-md-4">
			<h2>3.</h2>
			<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
				egestas eget quam. Vestibulum id ligula porta felis euismod semper.
				Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
				nibh, ut fermentum massa justo sit amet risus.</p>
			<p>
				<a class="btn btn-default" href="#" role="button">View details
					&raquo;</a>
			</p>
		</div>
	</div>

	<hr>

	<footer>
	<p>&copy; Company 2014</p>
	</footer>

	</div>
	<!-- /container -->
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.js"></script>
	<script>
		window.jQuery
				|| document.write(
						'<script src="js/vendor/jquery-1.11.0.js"><\/script>')
	</script>

	<script src="js/vendor/bootstrap.min.js"></script>

	<script src="js/main.js"></script>

	<!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
	<script>
		(function(b, o, i, l, e, r) {
					b.GoogleAnalyticsObject = l;
					b[l] || (b[l] = function() {
						(b[l].q = b[l].q || []).push(arguments)
					});
					b[l].l = +new Date;
					e = o.createElement(i);
					r = o.getElementsByTagName(i)[0];
					e.src = '//www.google-analytics.com/analytics.js';
					r.parentNode.insertBefore(e, r)
				}(window, document, 'script', 'ga'));
		ga('create', 'UA-XXXXX-X');
		ga('send', 'pageview');
	</script>

	<script type="text/javascript">
		function displayPopUp() {
			document.getElementById("createUser").style.display = "block";
			document.getElementById("fade").style.display = "block";

		}
		function closePopUp() {
			document.getElementById("createUser").style.display = "none";
			document.getElementById("fade").style.display = "none";
		}
		function showInfoBox(err, info)
		{
			if(err)
			{
				document.getElementById("infoBox").style.color = "red";
			}
			else
			{
				document.getElementById("infoBox").style.color = "green";
			}
			document.getElementById("infoBox").innerHTML = info;
		}
		<%out.println((String) session.getAttribute("skrivnoget"));%>
		
	</script>
	
	<% 
		try{
			String success = "";
			success = request.getParameter("success");
			if(success.equals("true"))
			{
				System.out.println("success");
				%>
				<script type="text/javascript">
				window.onload = showInfoBox(false,"<p>User successfully created!</p>")();
				</script>
				<%
			}
			else
			{
				String errType = "";
				errType = request.getParameter("err");
				
				if(errType.equals("login") || errType.equals("login-user") || errType.equals("login-length"))
				{
					if(errType.equals("login"))
					{
						%>
						<script type="text/javascript">
						window.onload = showInfoBox(true,"<p>You need to login to see this page!</p>")();
						</script>
						<%
					}
					else if(errType.equals("login-length"))
					{
						%>
						<script type="text/javascript">
						window.onload = showInfoBox(true,"<p>Please fill all fields!</p>")();
						</script>
						<%
					}
					else if(errType.equals("login-user"))
					{
						%>
						<script type="text/javascript">
						window.onload = showInfoBox(true,"<p>Wrong username or password. Please try again.</p>")();
						</script>
						<%
					}
					else
					{
						%>
						<script type="text/javascript">
						window.onload = showInfoBox(true,"<p>An Error occured. Please try again</p>")();
						</script>
						<%
					}
				}
				else
				{
					%>
					<script type="text/javascript">
					window.onload = displayPopUp();
					</script>
					<%
					
					if(errType.equals("user"))
					{
						%>
						<script type="text/javascript">
						alert("This username is already taken. \nTry another one...");
						</script>
						<%
					}
					else if(errType.equals("length"))
					{
						%>
						<script type="text/javascript">
						alert("Please fill all fields. \nFirstname needs to be 2-20 letters.\nLastname needs to be 2-20 letters.\nUsername needs to be 3-20 letters.\nPassword needs to be 6-20 chars.");
						</script>
						<%
					}
				}
			}
			
		}
		catch(Exception ex)
		{
			System.out.print("no param");
		}
	
	%>
</body>
</html>

