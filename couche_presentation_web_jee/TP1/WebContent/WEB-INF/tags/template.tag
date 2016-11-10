<%@tag language="java" description="Global CrowdfundingTemplate"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="main.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<header>
		<div id="headerLogo">
			<img class="logo" alt=""
				src="https://upload.wikimedia.org/wikipedia/commons/f/f5/Geefunding_crowdfunding.png" />
		</div>
		<div id="headerUserBlock">
			${connectedUser.login}
			<form method="POST" action="login">
				<button name="logoutAction">deconnection</button>
			</form>
		</div>
	</header>
	<section id="mainContainer">
		<nav>
			<div>
				<a href="./projects">Les Projets</a>
			</div>
		</nav>
		<section>
			<jsp:doBody />
		</section>
	</section>

</body>
</html>
