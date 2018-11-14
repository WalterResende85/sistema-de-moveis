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

    <title>Cadastro de Ferramentas</title>
</head>

<body>

    <div class="cadastroCentralizado">
        <form action="ManterFerramentaController?acao=confirmarOperacao&operacao=${operacao}" method="POST">
            <table class="tableform">
                <tr><td colspan="4" style="text-align: center">${operacao} Ferramenta</td></tr>
                 <tr>
                    <td>
                        <label for="idFerramenta">ID Ferramenta</label>
                    </td>
                    <td colspan="3">
                        <input type="text" name="idFerramenta" id="idFerramenta" placeholder="ID Ferramenta" value="${ferramenta.idFerramenta}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                    </td>
                </tr>
                
                <tr>
                    <td>
                        <label for="nome">Nome</label>
                    </td>
                    <td colspan="3">
                        <input type="text" name="nome" id="nome" placeholder="nome" value="${ferramenta.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="tipo">Tipo</label>
                    </td>
                    <td colspan="3">
                        <input type="text" name="tipo" id="tipo" placeholder="tipo" value="${ferramenta.tipo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="qtdEstoque">Quantidade</label>
                    </td>
                    <td colspan="3">
                        <input type="text" name="qtdEstoque" id="qtdEstoque" placeholder="quantidade" value="${ferramenta.qtdEstoque}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="valorUnitario">Valor Unitario</label>
                    </td>
                    <td colspan="3">
                        <input type="text" name="valorUnitario" id="valorUnitario" placeholder="valor Unitario" value="${ferramenta.valorUnitario}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="unidade">Unidade</label>
                    </td>
                    <td colspan="3">
                        <input type="text" name="unidade" id="unidade" placeholder="unidade" value="${ferramenta.unidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="PesquisaFerramentaController">
                            <input type="button" value="voltar">
                        </a>
                    </td>
                    <td colspan="3" class="tdsalvar">
                        <input type="submit" name="salvar" value="confirmar">
                    </td>
                </tr>
            </table>

        </form>

    </div>
</body>

</html>