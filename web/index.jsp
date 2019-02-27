<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Sistema Interno</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >

        <script type="text/javascript" src="jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <style>
            a {
                float: right;
            }
        </style>
    </head>

    <body>
        <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Sistema Interno</a>
        </nav>
        <br>

        <div class="container">

            <div class="row">
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-body">
                            <h4 class="card-title">Móveis</h4>
                            <a href="PesquisaMovelController" class="btn btn-primary">Manter</a>
                        </div>
                        <div>
                            <a href="RelatorioControllerMoveis" class="btn btn-success">Emitir relatorio</a>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-body">
                            <h4 class="card-title">Funcionário</h4>
                            <a href="PesquisaFuncionarioController" class="btn btn-primary">Manter</a>
                        </div>
                        <div>
                            <a href="RelatorioControllerFuncionario" class="btn btn-success">Emitir relatorio</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-body">
                            <h4 class="card-title">Fornecedor</h4>
                            <a href="PesquisaFornecedorController" class="btn btn-primary">Manter</a>
                        </div>
                        <div>
                            <a href="RelatorioControllerFornecedor" class="btn btn-success">Emitir relatorio</a>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-body">
                            <h4 class="card-title">Cliente</h4>
                            <a href="PesquisaClienteController" class="btn btn-primary">Manter</a>
                        </div>
                        <div>
                            <a href="RelatorioControllerCliente" class="btn btn-success">Emitir relatorio</a>
                        </div>
                        <div>
                            <a href="#" class="btn btn-success" data-toggle="modal" data-target="#modalCliente">relatorio C/ Parametro</a>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-body">
                            <h4 class="card-title">Pedido</h4>
                            <a href="PesquisaPedidoController" class="btn btn-primary">Manter</a>
                        </div>
                        <div>
                            <a href="RelatorioControllerPedido" class="btn btn-success">Emitir relatorio</a>
                        </div>


                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-body">
                            <h4 class="card-title">Material</h4>
                            <a href="PesquisaMaterialController" class="btn btn-primary">Manter</a>
                        </div>
                        <div>
                            <a href="RelatorioControllerMaterial" class="btn btn-success">Emitir relatorio</a>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <!-- Modais -->
        <div class="modal fade" id="modalCliente" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5>
                            Entre com a cidade do cliente
                        </h5>
                    </div>
                    <div class="modal-body">
                        <form action="RelatorioControllerClientePar" method="post">

                            <input type="text" name="paramCliente"/><br/>
                            <input type="submit"/>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <form action="ManterClienteController?acao=confirmarOperacao&operacao=${operacao}" method="POST" autofocus>
                        <select class="form-control" required name="idCliente" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <option required value="0" <c:if test="${pedido.cliente.idCliente == null}"> selected</c:if>> </option>  
                                <c:forEach items="${clientes}" var="cliente">
                                    <option required value="${cliente.idCliente}" <c:if test="${pedido.cliente.idCliente == cliente.idCliente}"> selected</c:if>>${cliente.idCliente} - ${cliente.nome}</option>  
                                </c:forEach>
                            </select>
                        </form>
                    </div>

                </div>

            </div>
        </div>
        <!-- Fim Modais -->
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </body>

</html>