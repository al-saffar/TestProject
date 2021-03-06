<%@page import="java.util.Arrays"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="mapper.SQLmapper"%>
<%@page import="classes.Score"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="ISO-8859-1"%>
	
<%
int id = -1;
try{
	id = (int)session.getAttribute("userid");
}
catch(Exception ex)
{
}


if(id < 0)
{
	response.sendRedirect("index.jsp?success=false&err=login");
}
%>
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
				<a class="navbar-brand" href="play.jsp">Play Game</a> <a
					class="navbar-brand" href="inbox.jsp">Inbox</a> <a class="navbar-brand"
					href="profile.jsp">Profile</a> <a class="navbar-brand" href="highscore.jsp">Highscore</a>

			</div>
			<div class="navbar-collapse collapse">
				<form class="navbar-form navbar-right" role="form"  name="LogoutServlet" method="post" action="LogoutServlet">
					<div class="form-group">
						<a>Logged in as: <% out.print(session.getAttribute("username")); %> </a>
					</div>
					<button type="submit" class="btn btn-success">Log out</button>
				</form>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</div>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container">

			<h1>Top 10 highscore</h1>
			<br>
			<%
			String htmlCode = "<table Style=\"width:30%;\")><tbody><tr style=\"border-bottom:solid\"><th style=\"width=10%\"><h2>#</h2></th><th style=\"width:50%;text-align:center;\"><h2>Username</h2></th><th style=\"width=45%;text-align:right\"><h2>Score</h2></th></tr>";
			
			Score[] scores = SQLmapper.gethighscore();			
			
			for(int i = 0; i < 10; i++)
			{
				if(i%2 == 0)
				{
					htmlCode += "<tr style=\"background-color:AliceBlue;border-bottom:solid 1px\"><td><p>"+(i+1)+"</p></td>";
				}
				else
				{
					htmlCode += "<tr style=\"border-bottom:solid 1px\"><td><p>"+(i+1)+"</p></td>";
				}
				if(scores.length > i)
				{
					htmlCode += "<td style=\"text-align:center\"><p>"+scores[i].getUsername()+"</p></td><td style=\"text-align:right\"><p>"+scores[i].getScore()+"</p></td>";
				}
				else
				{
					htmlCode += "<td><p></p></td><td><p></p></td>";
				}
				
				htmlCode += "</tr>";
			}
			
			htmlCode += "</tbody></table>";
			
			out.println(htmlCode);
			%>
			
			<br> <br> <br> <br> <br>
		</div>
		<div id="msg"></div>

	</div>

	<div class="container">



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
					.</p>
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
					.</p>
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
			
		function generateNum(){
			
			document.getElementById("image").style.display = "block";
			document.getElementById("guessedNumb").focus();
			 
	    }
		
		function checkNumb(val){
			
			var selval = val;
			var randomNumb = <%=session.getAttribute("randomNumb")%>;
			
			
			if (selval == randomNumb){
				document.getElementById("msg").innerHTML="Correct";
			}
			else if(selval < randomNumb){
				document.getElementById("msg").innerHTML="Too Small";
			}
			else if(selval > randomNumb){
				document.getElementById("msg").innerHTML="Too High";
			}
			}
				
		function getLevel() {
		    var selLevel = document.getElementById("level").value;
		    alert(input);
		}
		function showVal(newVal){
			  document.getElementById("showLevelValue").innerHTML=newVal;
		}
	</script>


</body>
</html>

