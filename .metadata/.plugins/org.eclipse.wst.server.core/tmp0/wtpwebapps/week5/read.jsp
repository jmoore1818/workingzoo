<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.byethursday.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Home | Justin's Zoo</title>

<!-- Bootstrap Core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!-- Theme CSS -->
<link href="css/agency.min.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


</head>
<body style = "background-color: #E1FAFA">

	

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">

						<center><h1>Your Zoo</h1></center>

						<table style="width: 80%;">
						  <table class="table table-bordered">
						   <table class="table table-hover">
						
							<tr>
								<th>Species</th>
								<th>Habitat</th>
								<th>Diet</th>
								<th>Activity</th>
							</tr>

							<%
								DAO.readFromDB();
							%>

							<%
								//Animal readToJSP = new Animal();
								for (int i = 0; i < DAO.ourZoo.size(); i++) {
									Animal readToJSP = DAO.ourZoo.get(i);
							%>
							<tr>
								<td><%=readToJSP.getspecies()%></td>
								<td><%=readToJSP.gethabitat()%></td>
								<td><%=readToJSP.getdiet()%></td>
								<td><%=readToJSP.getactivity()%></td>
							</tr>
							<%
								}
								DAO.ourZoo.clear();
							%>

						</table>

					</div>
				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->
		
		<div id="wrapper">

		<!-- Sidebar -->
		<br><br><br>
		<div id="sidebar-wrapper"><center>
			<a href="index.html" style='font-size:1.7em'>Home | Justin's Zoo</a><br>
			<a href="read.jsp" style='font-size:1.7em'>View your zoo</a><br>
				<a href="addtodb.html" style='font-size:1.7em'>Add an animal to your zoo.</a><br>
				<a href="updatedb.html" style='font-size:1.7em'>Update information about an animal in your zoo.</a><br>
				<a href="deletefromdb.html" style='font-size:1.7em'>Remove an animal from your zoo.</a><br><br><br><br>
		</center></div>
		<!-- /#sidebar-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Menu Toggle Script -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>

</body>
</html>