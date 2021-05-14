<%--
  Created by IntelliJ IDEA.
  User: Lucas Martins Ribeiro
  Date: 02/05/2021
  Time: 09:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String listaHTML = request.getParameter("lista");
%>
<head>
    <title>Lista de Jogos</title>
    <link href="gestor.css" rel="stylesheet">
</head>
<body>
<br>
<br>
<center>
    <table border="0">
        <thead>
        <tr>
            <th>Nome do Jogo</th>
            <th></th>
            <br/>
            <th>Diretor</th>
            <th></th>
            <br/>
            <th>Ano de Lançamento</th>
            <th></th>
            <br/>
            <th>Status</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <%=listaHTML%>
        </tbody>
    </table>

    <h3><a href="index.jsp" style="text-decoration: none;">Voltar</a></h3>
</center>


</body>
</html>
