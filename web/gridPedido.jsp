
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<------!>

<html lang="pt-br">

    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Grid Pedido</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
        <script src="main.js"></script>


    </head>

    <body>
        <div class="container">

            <table class="table table-striped table-bordered table-condensed table-hover">
                <tr>
                    <th colspan="4">Grid Pedido</th>
                </tr>
                <tr>
                    <th>Cod</th>
                    <th>Valor Total</th>
                    <th colspan="2">Ações</th>
                </tr>
                <c:forEach items="${pedidos}" var="pedido">
                    <tr>
                        <td>
                            <c:out value="${pedido.idPedido}" />
                        </td>
                        <td>
                            <c:out value="${pedido.valorTotal}" />
                        </td>
                       
                        <td><a class="btn btn-primary" href="ManterPedidoController?acao=prepararOperacao&Operacao=Editar&idPedido=<c:out value="${pedido.idPedido}" />">Editar</a></td>
                        <td><a class="btn btn-primary" href="ManterPedidoController?acao=prepararOperacao&Operacao=Excluir&idPedido=<c:out value="${pedido.idPedido}" />">Excluir</a></td>
                    </tr>
                </c:forEach>
                <td><a class="btn btn-danger" href="index.jsp">Voltar</a></td>
                <td colspan="3"><a class="btn btn-primary" href="ManterPedidoController?acao=prepararOperacao&operacao=Incluir">Incluir</a></td>
            </table>

        </div>

        <div class="container">


            <div>
                <a href="#" class="btn btn-success" data-toggle="modal" data-target="#modalPedido">relatorios</a>
            </div>
            <div class="modal fade" id="modalPedido" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5>
                                Relatorio completo
                            </h5>
                            <div>
                                <a href="RelatorioControllerPedido" class="btn btn-success">Emitir relatorio</a>
                            </div> 
                        </div>
                        <div class="modal-body">
                            <h5>
                               Selecione o cliente
                            </h5>
                            <form action="RelatorioControllerPedidoPar" method="POST" autofocus>
                                <select class="form-control"  name="paramPedido">

                                    <c:forEach items="${pedidos}" var="pedido">
                                        <option value="${pedido.idCliente}">${pedido.idCliente} - ${pedido.cliente.nome}</option>  
                                    </c:forEach>
                                </select>
                                <input type="submit"/>

                            </form>
                        </div>
                        <div class="modal-footer">


                        </div>

                    </div>

                </div>
            </div>
        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

    </body>

</html>
