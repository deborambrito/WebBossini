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

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/sb-admin.css" rel="stylesheet">
	<link href="css/login.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>

<body>
	<form action="login.do" method="post">
    <div id="wrapper">

        <div class="login-box">
        	<% out.println("<p class=\"alert-box\" "+request.getAttribute("visivel")+">"+ request.getAttribute("erro") + "</p>");%>
            <div class="form-group">
                <input type="email" placeholder="E-mail" id="Email" name="Email" class="input-control" />
            </div>
            <div class="form-group">
                <input type="password" placeholder="Senha" id="Password" name="Password" class="input-control" />
            </div>

            <input class="btn-login" type="submit" value="Entrar" />
        </div>

    </div>
    </form>
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
