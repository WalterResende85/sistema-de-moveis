<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >

        <title>Cadastro de Pedidos</title>
    </head>

    <body>

        <div>
            <form action="ManterPedidoController?acao=confirmarOperacao&operacao=${operacao}" method="POST">
                <table>
                    <tr><td colspan="4" style="text-align: center">${operacao} Pedido</td></tr>
                    <tr>
                        <td><label for="idPedido">idPedido</label></td>
                        <td colspan="3"><input class="form-control" type="text" name="idPedido" id="idPedido" placeholder="idPedido" value="${pedido.idPedido}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td><label for="valorTotal">Valor Total</label></td>
                            <td colspan="3"><input class="form-control" type="text" name="valorTotal" id="valorTotal" placeholder="valorTotal" value="${pedido.valorTotal}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>

                        <tr>

                            <td><label for="idCliente">Cliente</label></td>
                            <td> 
                                <select class="form-control" name="idCliente" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <option value="0" <c:if test="${pedido.cliente.idCliente == null}"> selected</c:if>> </option>  
                                <c:forEach items="${clientes}" var="cliente">
                                    <option value="${cliente.idCliente}" <c:if test="${pedido.cliente.idCliente == cliente.idCliente}"> selected</c:if>>${cliente.idCliente}</option>  
                                </c:forEach>
                            </select>

                        </td>

                    </tr>

                    <tr>
                        <td><a href="PesquisaPedidoController"><input class="btn btn-danger" type="button" value="voltar"></a></td>
                        <td colspan="3" class="tdsalvar" ><input class="btn btn-success" type="submit" name="" value="Confirmar"></td>
                    </tr>
                </table>     
            </form> 
        </div>
    </body>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</html>