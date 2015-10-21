<%@page import="javax.swing.text.html.HTMLWriter"%>
<%@page import="javax.faces.component.html.HtmlMessage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.*, java.util.*"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>USJT - AIRLINES</title>

<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/sb-admin.css" rel="stylesheet">
<link href="../css/plugins/morris.css" rel="stylesheet">
<link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">


</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html"><i
					class="fa fa-fw fa-plane"></i><strong> USJT - AIRLINES</strong></a>
			</div>
			<!-- Top Menu Items -->
			<ul class="nav navbar-right top-nav">

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-user"></i> Supervisor<b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="register.do"><i class="fa fa-fw fa-gear"></i>
								Novo Usuário</a></li>
						<li class="divider"></li>
						<li><a href="../login.do"><i
								class="fa fa-fw fa-power-off"></i> Log Out</a></li>
					</ul></li>
			</ul>
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li><a href="passagem.html"><i
							class="fa fa-fw fa-bar-chart-o"></i> Passagem</a></li>
					<li><a href="checkin.html"><i class="fa fa-fw fa-edit"></i>
							Check-In</a></li>
					<li><a href="passagemvendida.html"><i
							class="fa fa-fw fa-desktop"></i> Passagens Vendidas</a></li>
					<li><a href="passageiro.html"><i
							class="fa fa-fw fa-wrench"></i> Passageiro</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Novo Usuário</h1>
						<ol class="breadcrumb">
							<li><i class="fa fa-plane"></i> <a href="index.html">
									USJ-Airlines</a></li>
							<li class="active"><i class="fa fa-user"></i>  Novo Usuário</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-md-12">

						<form action="../register.do" method="post">

							<div class="row"
								<%out.println(session.getAttribute("visivel"));%>>
								<div class="col-md-4">
									<div class="<%out.println(session.getAttribute("retorno"));%>"
										role="alert">
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<%
											out.println(session.getAttribute("msg"));
										%>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">

										<label>Nome</label> <input class="form-control" type="text"
											name="nome" required="required" />
									</div>
								</div>


							</div>
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">

										<label>E-mail</label> <input class="form-control" type="text"
											name="email" required="required" />
									</div>
								</div>

							</div>
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">

										<label>Senha</label> <input class="form-control"
											type="password" name="senha" required="required" />
									</div>
								</div>

							</div>
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">

										<label>Tipo</label> <select class="form-control" name="tipo">
											<option value="Atendente">Atendente</option>
											<option value="Supervisor">Supervisor</option>
										</select>
									</div>
								</div>
							</div>

							<div class="row" style="margin-top: 18px;">
								<div class="form-group">
									<div class="col-md-2">
										<button class="btn btn-success" type="submit">Confirmar
										</button>

									</div>

								</div>

							</div>
						</form>

					</div>

				</div>

			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<script src="../js/jquery.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/plugins/morris/raphael.min.js"></script>
	<script src="../js/plugins/morris/morris.min.js"></script>
	<script src="../js/plugins/morris/morris-data.js"></script>

</body>

</html>
