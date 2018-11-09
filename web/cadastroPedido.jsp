<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" type="text/css" href="styletelas.css">

        <title>Cadastro de Funcionario</title>
    </head>

    <body>

        <div class="cadastroCentralizado">
            <form action="ManterPedidoController?acao=confirmarOperacao&operacao=${operacao}" method="POST">
                <table class="tableform">
                    <tr><td colspan="4" style="text-align: center">${operacao} Pedido</td></tr>
                    <tr>
                        <td><label for="idPedido">idPedido</label></td>
                        <td colspan="3"><input type="text" name="idPedido" id="idPedido" value="${pedido.idPedido}"
                    <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr><td><label for="valorTotal">Valor Total</label></td><td colspan="3"><input type="text" name="valorTotal" id="valorTotal" placeholder="valorTotal" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                    
                   <tr>

                            <td><label for="idCliente">Cliente</label></td>
                            <td> 
                                <select name="idCliente" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <option value="0" <c:if test="${pedido.cliente.idCliente == null}"> selected</c:if>> </option>  
                                <c:forEach items="${clientes}" var="cliente">
                                    <option value="${cliente.idCliente}" <c:if test="${pedido.cliente.idCliente == cliente.idCliente}"> selected</c:if>>${cliente.idCliente}</option>  
                                </c:forEach>
                            </select>

                        </td>

                    </tr>
                    
                <tr><td><a href="PesquisaPedidoController"><input type="button" value="voltar"></a></td><td colspan="3" class="tdsalvar" ><input type="submit" name="" value="salvar"></td></tr>
                </table>     
            </form> 
        </div>
    </body>
</html>