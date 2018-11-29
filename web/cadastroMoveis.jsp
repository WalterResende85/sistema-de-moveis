
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
        <title>Cadastro de móveis</title>
    </head>

    <body>
        <div class="container">
            <form action="ManterMoveisController?acao=confirmarOperacao&operacao=${operacao}" method="POST">
                <table class="tableform">
                    <tr><td colspan="4" style="text-align: center">${operacao} Movel</td></tr>
                    <tr>
                        <td><label for="idMovel">Código do Móvel</label></td>
                        <td colspan="3"><input class="form-control" type="number" required min="1" name="idMovel" id="idMovel" value="${movel.idMovel}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr><td><label for="nome">Nome</label></td><td colspan="3"><input class="form-control" type="text" required maxlength="45" minlength="3" name="nome" id="nome" value="${movel.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td><label for="preco">Preço</label></td><td colspan="3"><input class="form-control" type="number" required min="0" name="preco" id="preco" value="${movel.preco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td><label for="tipo">Tipo</label></td><td colspan="3"><input class="form-control" type="text" required maxlength="45" minlength="2" name="tipo" id="tipo" value="${movel.tipo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td><label for="material">Material</label></td><td colspan="3"><input class="form-control" type="text" required maxlength="45" minlength="2" name="material" id="material" value="${movel.material}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td><label for="altura">Altura</label></td><td colspan="3"><input class="form-control" type="number" min="1" name="altura" id="altura" value="${movel.altura}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td><label for="largura">Largura</label></td><td colspan="3"><input class="form-control" type="number" min="1" name="largura" id="largura" value="${movel.largura}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td><label for="comprimento">Comprimento</label></td><td colspan="3"><input class="form-control" type="number" min="1" name="comprimento" id="comprimento" value="${movel.comprimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td><label for="acabamento">Acabamento</label></td><td colspan="3"><input class="form-control" type="text" required maxlength="45" minlength="2" name="acabamento" id="acabamento" value="${movel.acabamento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>           
                        <tr>
                            <td><label for="peso">Peso</label></td><td colspan="3"><input class="form-control" type="number" min="1" name="peso" id="peso" value="${movel.peso}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>


                        <tr>

                            <td><label for="idPedido">Pedido</label></td>
                            <td> 
                                <select class="form-control" name="idPedido" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <option value="0" <c:if test="${movel.pedido.idPedido == null}"> selected</c:if>> </option>  
                                <c:forEach items="${pedidos}" var="pedido">
                                    <option value="${pedido.idPedido}" <c:if test="${movel.pedido.idPedido == pedido.idPedido}"> selected</c:if>>${pedido.idPedido}</option>  
                                </c:forEach>
                            </select>

                        </td>

                    </tr>            


                    <tr>
                        <td><a href="PesquisaMovelController"><input class="btn btn-danger" type="button" value="voltar"></a></td>
                        <td colspan="3" class="tdsalvar" ><input class="btn btn-success" type="submit" name="salvar" value="Confirmar"></td>
                    </tr>
                </table>
            </form>
        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </body>
</html>