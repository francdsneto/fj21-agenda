<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.*,
		br.com.caelum.jdbc.dao.*,
		br.com.caelum.jdbc.modelo.*,
		java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Endereço</th>
				<th>Data de Nascimento</th>
			</tr>
		</thead>
		<tbody>
<%-- 			<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao" /> --%>
<%-- 			<c:forEach var="contato" items="${dao.lista}" varStatus="id"> --%>
				<c:forEach var="contato" items="${contatos}" varStatus="id">
				<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
					<td>${id.count}</td>
					<td>${contato.nome}</td>
					<c:choose>
						<c:when test="${not empty contato.email}">
							<td><a href="mailto:${contato.email}">${contato.email}</a></td>
						</c:when>
						<c:otherwise>
							<td>E-mail não informado</td>
						</c:otherwise>
					</c:choose>
					<td>${contato.endereco}</td>
					<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
					<td>
						<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>