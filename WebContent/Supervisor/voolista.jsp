<!DOCTYPE html>
<%@page import="javax.swing.text.View"%>
<%@page import="javax.swing.text.html.HTMLWriter"%>
<%@page import="javax.faces.component.html.HtmlMessage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.*, java.util.*, to.*"%>
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
<link href="../css/index.css" rel="stylesheet">
<script src="../js/jquery.js"></script>
<script src="../js/voo.js"></script>

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
					<ul class="nav navbar-nav side-nav">
						<li><a href="javascript:;" data-toggle="collapse"
							data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i> Voo
								<i class="fa fa-fw fa-caret-down"></i></a>
							<ul id="demo" class="collapse">
								<li><a href="../voo.do">Cadastrar</a></li>
								<li><a href="../voolista.do">Filtro</a></li>
							</ul></li>

						<li><a href="charts.html"><i
								class="fa fa-fw fa-bar-chart-o"></i> Passagem</a></li>
						<li><a href="tables.html"><i class="fa fa-fw fa-table"></i>
								Cancelamento/Transferencia</a></li>
						<li><a href="forms.html"><i class="fa fa-fw fa-edit"></i>
								Check-In</a></li>
						<li><a href="bootstrap-elements.html"><i
								class="fa fa-fw fa-desktop"></i> Passagens Vendidas</a></li>
						<li><a href="bootstrap-grid.html"><i
								class="fa fa-fw fa-wrench"></i> Passageiro</a></li>

						<li><a href="blank-page.html"><i class="fa fa-fw fa-file"></i>
								Blank Page</a></li>
						<li><a href="index-rtl.html"><i
								class="fa fa-fw fa-dashboard"></i> RTL Dashboard</a></li>
					</ul>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Vôos</h1>
						<ol class="breadcrumb">
							<li><i class="fa fa-plane"></i> <a href="index.html">
									USJ-Airlines</a></li>
							<li class="active"><i class="fa fa-edit"></i> Vôos</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-md-12">
						<div class="row">
							<div class="form-group">
								<div class="col-md-3">
									<input type="text" id="filter" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-1">
									<button type="button" class="btn btn-warning"
										style="margin-top: -17px;">
										<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-12">
						<h2></h2>
						<div class="table-responsive">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>Voo</th>
										<th>Companhia</th>
										<th>Origem</th>
										<th>Data/Hora</th>
										<th>Destino</th>
										<th>Data/Hora(Chegada)</th>
										<th>Alterar</th>
										<th>Excluir</th>
									</tr>
								</thead>
								<tbody class="tabelaVoos">
									<%out.println(session.getAttribute("listaVoos"));%>
								</tbody>
							</table>
						</div>
					</div>

				</div>
			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

		<!-- Modal Excluir -->

		<div class="modal fade" id="ExcluirModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Excluir</h4>
					</div>
					<div class="modal-body">
						<h4>Tem certeza que deseja excluir o voo?</h4>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-info" data-dismiss="modal">Fechar</button>
						<button type="button" class="btn btn-danger btn-excluirvoomodal"
							data-idvoomodal="">Excluir</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Modal Alterar -->

		<div class="modal fade" id="AlterarModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Alterar Dados do
							Voo</h4>
					</div>
					<form action="../vooalterar.do" method="post">
						<div class="modal-body">


							<div class="row"
								<%out.println(session.getAttribute("visivelL"));%>>
								<div class="col-md-4">
									<div class="<%out.println(session.getAttribute("retornoL"));%>"
										role="alert">
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<%
											out.println(session.getAttribute("msgL"));
										%>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<div class="col-md-1" style="margin-top: 22px;">
										<label>Origem</label>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-4">

										<select class="form-control origemVooModal" name="origemVoo">

										</select>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-1">
										<label style="margin-top: 7px">Data/Hora</label>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-3">
										<input class="form-control dataOrigemVooModal" type="date"  name="dataOrigemVoo"
											required="required" />
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-2">
										<input class="form-control horaOrigemVooModal" type="time"
											name="horaOrigemVoo"
											required="required" />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="form-group">
									<div class="col-md-1" style="margin-top: 22px;">
										<label>Chegada</label>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-4">

										<select class="form-control chegadaVooModal" 
											name="chegadaVoo">

										</select>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-1">
										<label style="margin-top: 7px">Data/Hora</label>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-3">
										<input class="form-control dataChegadaVooModal" type="date"  name="dataChegadaVoo"
											required="required" />
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-2">
										<input class="form-control horaChegadaVooModal" type="time" name="horaChegadaVoo"
											required="required" />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="form-group">
									<div class="col-md-1">
										<label style="margin-top: 21px">Companhias </label>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-3" style="margin-left: 20px;">
										<select class="form-control companhiaVooModal"
											name="companhiaVoo">

										</select>
									</div>
								</div>

							</div>

						</div>
						<input class="input-idvoo" name ="idvooName" value="" hidden />
						<div class="modal-footer">
							<button type="button" class="btn btn-info btnfecharmodal" data-dismiss="modal">Fechar</button>
							<button type="submit" class="btn btn-warning">Alterar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /#wrapper -->

	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/plugins/morris/raphael.min.js"></script>
	<script src="../js/plugins/morris/morris.min.js"></script>
	<script src="../js/plugins/morris/morris-data.js"></script>

	<div class="loader" style="display: none">
		<img src="../img/rings.svg" alt="Carregando...">
	</div>

</body>

</html>
