
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="styletelas.css">
    <title>Cadastro de móveis</title>
</head>

<body>
    <div class="cadastroCentralizado">
        <form action="ManterMoveisController?acao=confirmarOperacao&operacao=${operacao}" method="POST">
            <table class="tableform">
                 <tr><td colspan="4" style="text-align: center">${operacao} Movel</td></tr>
                <tr>
                    <td><label for="idMovel">idMovel</label></td>
                    <td colspan="3"><input type="text" name="idMovel" id="idMovel" value="${movel.idMovel}"
                            <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr><td><label for="nome">Nome</label></td><td colspan="3"><input type="text" name="nome" id="nome" placeholder="nome" value="${movel.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                <tr><td><label for="preco">Preco</label></td><td colspan="3"><input type="text" name="preco" id="preco" placeholder="preco" value="${movel.preco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                <tr><td><label for="tipo">tipo</label></td><td colspan="3"><input type="text" name="tipo" id="tipo" placeholder="tipo" value="${movel.tipo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                <tr><td><label for="material">material</label></td><td colspan="3"><input type="text" name="material" id="material" placeholder="material" value="${movel.material}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                <tr><td><label for="altura">altura</label></td><td colspan="3"><input type="text" name="altura" id="altura" placeholder="altura" value="${movel.altura}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                <tr><td><label for="largura">largura</label></td><td colspan="3"><input type="text" name="largura" id="largura" placeholder="largura" value="${movel.largura}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                <tr><td><label for="comprimento">comprimento</label></td><td colspan="3"><input type="text" name="comprimento" id="comprimento" placeholder="comprimento" value="${movel.comprimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                <tr><td><label for="acabamento">acabamento</label></td><td colspan="3"><input type="text" name="acabamento" id="acabamento" placeholder="acabamento" value="${movel.acabamento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>           
                <tr><td><label for="peso">peso</label></td><td colspan="3"><input type="text" name="peso" id="peso" placeholder="peso" value="${movel.peso}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                <tr><td><label for="idPedido">idPedido</label></td><td colspan="3"><input type="text" name="idPedido" id="idPedido" placeholder="idPedido" <c:choose><c:when test="value=${movel.idPedido != null}">value=""</c:when><c:otherwise>value="${movel.idPedido}"</c:otherwise></c:choose><c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>            
                <tr>
                    <td><a href="PesquisaMovelController"><input type="button" value="voltar"></a></td>
                    <td colspan="3" class="tdsalvar" ><input type="submit" name="" value="salvar"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>