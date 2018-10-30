<%@page contentType = "text/html" pageEncoding="utf-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Grid Cliente</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="styletelas.css" />
        <script src="main.js"></script>


    </head>

    <body>
        <div class="cadastroCentralizado">

            <table class="tablegrid">
                <tr>
                    <th colspan="4">Grid Cliente</th>
                </tr>
                <tr>
                    <td>Cod</td>
                    <td>nome</td>
                    <td colspan="2">Ações</td>
                </tr>
                <c:forEach items="${clientes}" var="cliente">
                    <tr>
                        <td>
                            <c:out value="${cliente.idCliente}" />
                        </td>
                        <td>
                            <c:out value="${cliente.nome}" /><!--talvez tenha que tirar-->
                        </td>
                        <td><a href="ManterClienteController?acao=prepararOperacao&operacao=Editar&idCliente=<c:out
                                   value="${cliente.idCliente}" />" >Editar</a></td>
                        <td><a href="ManterClienteController?acao=prepararOperacao&operacao=Excluir&idCliente=<c:out
                                   value="${cliente.idCliente}" />" >Excluir</a></td>
                    </tr>
                </c:forEach>
            </table>
            <a href="index.jsp"><button type="button">Voltar</button></a>
            <a href="ManterClienteController?acao=prepararOperacao&operacao=Incluir">
                <button type="button">Incluir</button>
            </a>
        </div>

    </body>

</html>