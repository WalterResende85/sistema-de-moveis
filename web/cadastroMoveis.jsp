
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
        <title>Cadastro de móveis</title>
    </head>

    <body>
        <div class="container">
            <form action="ManterMoveisController?acao=confirmarOperacao&operacao=${operacao}" method="POST">
                <table class="tableform">
                    <tr><td colspan="4" style="text-align: center">${operacao} Movel</td></tr>
                    <tr>
                        <td><label for="idMovel">idMovel</label></td>
                        <td colspan="3"><input class="form-control" type="text" name="idMovel" id="idMovel" value="${movel.idMovel}"
                                               <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                        <tr><td><label for="nome">Nome</label></td><td colspan="3"><input class="form-control" type="text" name="nome" id="nome" placeholder="nome" value="${movel.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                    <tr><td><label for="preco">Preco</label></td><td colspan="3"><input class="form-control" type="text" name="preco" id="preco" placeholder="preco" value="${movel.preco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                    <tr><td><label for="tipo">tipo</label></td><td colspan="3"><input class="form-control" type="text" name="tipo" id="tipo" placeholder="tipo" value="${movel.tipo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                    <tr><td><label for="material">material</label></td><td colspan="3"><input class="form-control" type="text" name="material" id="material" placeholder="material" value="${movel.material}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                    <tr><td><label for="altura">altura</label></td><td colspan="3"><input class="form-control" type="text" name="altura" id="altura" placeholder="altura" value="${movel.altura}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                    <tr><td><label for="largura">largura</label></td><td colspan="3"><input class="form-control" type="text" name="largura" id="largura" placeholder="largura" value="${movel.largura}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                    <tr><td><label for="comprimento">comprimento</label></td><td colspan="3"><input class="form-control" type="text" name="comprimento" id="comprimento" placeholder="comprimento" value="${movel.comprimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                    <tr><td><label for="acabamento">acabamento</label></td><td colspan="3"><input class="form-control" type="text" name="acabamento" id="acabamento" placeholder="acabamento" value="${movel.acabamento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>           
                    <tr><td><label for="peso">peso</label></td><td colspan="3"><input class="form-control" type="text" name="peso" id="peso" placeholder="peso" value="${movel.peso}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>


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