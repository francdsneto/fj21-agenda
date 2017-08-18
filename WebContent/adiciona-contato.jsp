<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="n"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adiciona Contato</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
<script
  src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"
  integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU="
  crossorigin="anonymous"></script>
<link href="https://code.jquery.com/ui/1.12.0/themes/smoothness/jquery-ui.css" rel="stylesheet" />
<link href="<c:url value='/resources/css/custom.css'/>" rel="stylesheet" />
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
<!-- 	<form action="adicionaContato" method="POST"> -->
<!-- 		Nome: <input type="text" name="nome" /> <br /> E-mail: <input -->
<!-- 			type="text" name="email" /> <br /> Endere√ßo: <input type="text" -->
<!-- 			name="endereco" /> <br /> Data Nascimento: <input type="text" -->
<!-- 			name="dataNascimento" /> <br /> <input type="submit" value="Gravar" /> -->
<!-- 	</form> -->
	<form action="adicionaContato" method="POST">
		<n:campo id="nome" label="Nome: " type="text"/>
		<br />
		<n:campo id="email" label="E-mail: " type="email"/>
		<br />
		<n:campo id="endereco" label="EndereÁo: " type="text"/>
		<br />
		<n:campoData id="dataNascimento" label="Data Nascimento: "/>
		<br />
		<input type="submit" value="Gravar" />
	</form>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>