<%-- 
    Document   : login
    Created on : 14/10/2015, 09:28:49
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<!--META-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login Form</title>
<!--STYLESHEETS-->
<link href="css/style.css" rel="stylesheet" type="text/css" />
<!--SCRIPTS-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<!--Slider-in icons-->
<script type="text/javascript">
$(document).ready(function() {
$(".username").focus(function() {
$(".user-icon").css("left","-48px");
});
$(".username").blur(function() {
$(".user-icon").css("left","0px");
});
$(".password").focus(function() {
$(".pass-icon").css("left","-48px");
});
$(".password").blur(function() {
$(".pass-icon").css("left","0px");
});
});
</script>
</head>
<body>
<!--WRAPPER-->
<div id="wrapper">
<!--SLIDE-IN ICONS-->
<div class="user-icon"></div>
<div class="pass-icon"></div>
<!--END SLIDE-IN ICONS-->
<!--LOGIN FORM-->
<form name="login-form" class="login-form" action="LoginServlet" method="post" >
<!--HEADER-->
<div class="header">
<!--TITLE--><h1>Login Sistema Ficha de Saúde</h1><!--END TITLE-->
<!--DESCRIPTION--><span>Para acessar é necessário efetuar o login no Sistema Ficha de Saúde, caso não tenha cadastro click em REGISTRAR.</span><!--END DESCRIPTION-->
</div>
<!--END HEADER-->
<!--CONTENT-->
<div class="content">
<form method="POST" action="LoginServlet">
<!--
<label for="inputEmail">E-mail</label> <BR>
<input id="inputEmail" name="login" type="text" placeholder="Digite o seu e-mail..." /> <br>
-->
<!--USERNAME--><input id="inputEmail" name="login" type="text" class="input username" value="E-mail" onfocus="this.value=''" /><!--END USERNAME-->
<!--PASSWORD--><input id="inputPassword" name="senha" type="password" class="input password" value="Senha" onfocus="this.value=''" /><!--END PASSWORD-->
</div>
<!--END CONTENT-->
<!--FOOTER-->
<div class="footer">
<!--LOGIN BUTTON--><input type="submit" name="submit" value="Entrar" class="button" /><!--END LOGIN BUTTON-->
<!--CADASTRAR BUTTON--><input type="submit" name="submit" value="Cadastrar" class="register" /><!--END CADASTRAR BUTTON-->
</div>
<!--END FOOTER-->
</form>
<!--END LOGIN FORM-->
</div>
<!--END WRAPPER-->
<!--GRADIENT--><div class="gradient"></div><!--END GRADIENT-->
</body>
</html>