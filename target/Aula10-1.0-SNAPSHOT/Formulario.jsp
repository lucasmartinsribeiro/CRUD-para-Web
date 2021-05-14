<%--
  Created by IntelliJ IDEA.
  User: Lucas Martins Ribeiro
  Date: 02/05/2021
  Time: 08:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String acao = request.getParameter("acao");

    String id = request.getParameter("id");
    String nome = request.getParameter("nome");
    String diretor = request.getParameter("diretor");
    String anoLancamento = request.getParameter("anoLancamento");
    String status = request.getParameter("status");

    if (id == null) {
        nome = " ";
        diretor = " ";
        anoLancamento = " ";
        status = " ";
    }
%>
<head>
    <title>Formulario de Jogos</title>
    <link href="gestor.css" rel="stylesheet">
</head>
<center>
    <body>
    <br>
    <br>
    <h1>Cadastro de Jogos</h1>
    <br>
    <form action="JogoSrv" method="POST">
        <input type="hidden" name="acao" value="<%=acao%>"/>
        <table border="0">
            <tbody>
            <tr>
                <td><input type="hidden" name="id" value="<%=id%>"></td>
            </tr>
            <tr>
            <tr>
                <td>Nome do Jogo:</td>
                <td><input type="text" name="nome" value="<%=nome%>"></td>
            </tr>
            <tr>
                <td>Diretor:</td>
                <td><input type="text" name="diretor" value="<%=diretor%>"></td>
            </tr>
            <tr>
                <td>Ano de lançamento:</td>
                <td><input type="text" name="anoLancamento" value="<%=anoLancamento%>"></td>
            </tr>
            <tr>
                <td>Status:</td>
                <td><input type="text" name="status" value="<%=status%>"></td>
            </tr>
            </tbody>
        </table>
        <br>
        <br>
        <input type="submit" value="Enviar"/>
        <input type="reset" value="Limpar"/>
    </form>

    <br>
    <h3><a href="index.jsp" style="text-decoration: none;">Voltar</a></h3>

    </body>
</center>
</html>
