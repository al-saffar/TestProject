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
<%
	if (session.getAttribute("randomNumb") != null
			&& session.getAttribute("randomNumb") != ""
			&& session.getAttribute("randomNumb") != null) {
%>
<body onload="generateNum()">
	<%
		}
		//out.println(session.getAttribute("randomNumb"));
	%>

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
				<a class="navbar-brand" href="#">Play Game</a> <a
					class="navbar-brand" href="#">Inbox</a> <a class="navbar-brand"
					href="#">Profile</a> <a class="navbar-brand" href="#">Highscore</a>

			</div>
			<div class="navbar-collapse collapse">
				<form class="navbar-form navbar-right" role="form"
					action="index.jsp">
					<div class="form-group">
						<a>Logged in as: Anders</a>
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

			<%
				if (session.getAttribute("selLevel") == null) {
					session.setAttribute("selLevel", "50");

				}
			%>


			<p>Welcome...</p>
			<br>
			<form name="StartGameServlet" method="post" action="StartGameServlet">
				<div id="level">
					<h4>Easy &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Medium
						&nbsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Hard</h4>
					<input type="range" name="level" min="10" max="100" step="5"
						value="<%=session.getAttribute("selLevel")%>"
						oninput=showVal(this.value);>


					<div id="showLevelValue">
						<h2>
							<%=session.getAttribute("selLevel")%>
						</h2>

					</div>
				</div>

				<p>

					<br> <br> <br>
				<div id="genBtn">

					<br> <input class="btn btn-primary btn-lg" type="submit"
						name="genButton" value="Generate Random	number!"
						onclick=generateNum();> </input>
				</div>
				<div id="image">
					<img alt="" src="img/correctmark.png">
				</div>
			</form>
			<p>
			<div id="hiddenNumb"></div>
			<br> <br> <br> <br> <br>
			<div class="form-group">
				<input type="text" name="guessedNumb" placeholder="00"
					id="guessedNumb" class="form-control" maxlength="3" minlenght="1"
					onkeypress=checkNumb(this.value); onclick="this.select()">
			</div>

			<button type="button" onclick=checkNumb(this.value);
				class="btn btn-success">Guess!</button>
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

	<div class="container">
		<form name="playDiv" method="post" action="GameEndedServlet">
			<div id="createUser">
				<h3 style="text-align: center">You Guessed Right!</h3>
				<div style="float: left; margin-left: 25px;">
					<br>
					<h3>Correct Number:	<%=session.getAttribute("randomNumb")%></h3>
					<h3 id="levelmsg"></h3>
					<h3 id="attemps"></h3>
					<h3 id="score"></h3>
					<div style="float: right; margin-right: 0px;">

						<input class="btn btn-default" style="margin-left: 0px"
							type="submit" id="ok!" name="button" value="OK!" onClick="closePopUp()">
					</div>
					<input type="hidden" id="hiddenField" name="hiddenField" />
					<input type="hidden" id="hiddenScore" name="hiddenScore" /> 
		</form>
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
			
			
			var elem = document.getElementById("guessedNumb");
			elem.onkeyup = function(e){
			    if(e.keyCode == 13){
			    	
			    	if (checkNumb.counter == undefined)
			    	{
			    		checkNumb.counter = 0
			    	}
			    	

			
			var selval = val;
			var randomNumb = <%=session.getAttribute("randomNumb")%>;
			if	(randomNumb==null||randomNumb==""){				
				alert("Please Generate a new number!");
				
		}
			
			else if (selval == randomNumb){
				checkNumb.counter++;
				document.getElementById("msg").innerHTML="Correct Attemps: "+ checkNumb.counter;
				
				// send til servlet/database her
				var elem = document.getElementById("hiddenField")
				var hiddenscore = document.getElementById("hiddenScore")
				var attemps = document.getElementById("attemps")
				var msg = document.getElementById("score")
				var level = <%=session.getAttribute("selLevel")%>
				var score = 0;		
				score = (1000* (level/10) )/checkNumb.counter;
				
				score +=  (level*10) - (100*checkNumb.counter/10);
				var levelmsg = document.getElementById("levelmsg")
				
				hiddenscore.value = score;
				elem.value = checkNumb.counter;
				attemps.innerHTML = "Attemps: "+ checkNumb.counter;
				levelmsg.innerHTML ="Level: "+ level;
				msg.innerHTML = "Score: "+ ~~score;
				displayPopUp();
				document.getElementById("ok!").focus();
				document.getElementById("ok!").select();
				
				
				checkNumb.counter = 0;
			}
			else if(selval < randomNumb){
				checkNumb.counter++;
				document.getElementById("msg").innerHTML="Too Small Attemps: "+ checkNumb.counter;
				document.getElementById("guessedNumb").focus();
				document.getElementById("guessedNumb").select();
				
			}
			else if(selval > randomNumb){
				checkNumb.counter++;
				document.getElementById("msg").innerHTML="Too High Attemps: "+ checkNumb.counter;
				document.getElementById("guessedNumb").focus();
				document.getElementById("guessedNumb").select();
				
			
			}
			}
			}
		}
		
		function getLevel() {
		    var selLevel = document.getElementById("level").value;
		    alert(input);
		}
		function showVal(newVal){
			  document.getElementById("showLevelValue").innerHTML="<h2>"+newVal+"</h2>";
		}
		
		
	</script>


</body>
</html>

