<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>


<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Grid Pedido</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="styletelas.css" />
    <script src="main.js"></script>


</head>

<body>
    <div class="cadastroCentralizado">

        <table class="tablegrid">
            <tr>
                <th colspan="4">Grid Pedido</th>
            </tr>
            <tr>
                <td>Cod</td>
                <td>nome</td>
                <td colspan="2">Ações</td>
            </tr>
            <c:forEach items="${pedidos}" var="pedido">
                <tr>
                    <td>
                        <c:out value="${pedido.idPedido}" />
                    </td>
                    <td>
                        <c:out value="${pedido.valorTotal}" />
                    </td>
                    <td><a href="ManterPedidoController?acao=prepararOperacao&Operacao=Editar&idPedido=<c:out value="${pedido.idPedido}" />">Editar</a></td>
                    <td><a href="ManterPedidoController?acao=prepararOperacao&Operacao=Excluir&idPedido=<c:out value="${pedido.idPedido}" />">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterPedidoController?acao=prepararOperacao&Operacao=Incluir" method="POST">
            
            <a href="index.jsp"><button type="button">Voltar</button></a>
                <input type="submit" name="btnIncluir" value="incluir">            
        </form>
    </div>

</body>

</html>