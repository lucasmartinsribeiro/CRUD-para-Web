<%--
  Created by IntelliJ IDEA.
  User: Lucas Martins Ribeiro
  Date: 02/05/2021
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String listaHTML = request.getParameter("pesquisaNome");
    if(listaHTML == null)
        listaHTML = "";
%>
<head>
    <title>Pesquisar Jogo</title>
    <link href="gestor.css" rel="stylesheet">
</head>
<body>
<br>
<br>
<center>
    <form action="JogoSrv" method="POST">
        <br>
        <br>
        <th>Digite o Nome do Jogo:</th>
        <input type="text" name="pesquisa" value=""/>
        <input type="hidden" name="acao" value="pesquisarJogo"/>
        <input type="submit" name="" value="pesquisar"/>
        <br>
        <br>
    </form>
    <table border="0">
        <thead>
        <tr>
            <th>Nome do Jogo</th>
            <th></th>
            <th>Diretor</th>
            <th></th>
            <th>Ano de Lançamento</th>
            <th></th>
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

    <br>
    <h3><a href="index.jsp" style="text-decoration: none;">Voltar</a></h3>
</center>


</body>
</html>