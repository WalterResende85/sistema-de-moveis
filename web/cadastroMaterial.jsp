
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

    <title>Cadastro de Materiais</title>
</head>

<body>

    <div class="container">
        <form action="ManterMaterialController?acao=confirmarOperacao&operacao=${operacao}" method="POST">
            <table class="tableform">
                 <tr><td colspan="4" style="text-align: center">${operacao} Material</td></tr>
                <tr>
                    <td>
                        <label for="idMaterial">Código do Material</label>
                    </td>
                    <td colspan="3">
                        <input class="form-control" type="number" min="1" name="idMaterial" id="idMaterial" value="${material.idMaterial}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                    </td>
                </tr>
                 <tr>
                    <td>
                        <label for="nome">Nome</label>
                    </td>
                    <td colspan="3">
                        <input class="form-control" type="text" required maxlength="45" minlength="2" name="nome" id="nome" value="${material.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="tipo">Tipo</label>
                    </td>
                    <td colspan="3">
                        <input class="form-control" type="text" required maxlength="45" minlength="1" name="tipo" id="tipo" value="${material.tipo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="qtdEstoque">Quantidade</label>
                    </td>
                    <td colspan="3">
                        <input class="form-control" type="number" required min="0" name="qtdEstoque" id="qtdEstoque" value="${material.qtdEstoque}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="valorUnitario">Valor Unitário</label>
                    </td>
                    <td colspan="3">
                        <input class="form-control" type="number" required min="0" name="valorUnitario" id="valorUnitario" value="${material.valorUnitario}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="unidade">Unidade</label>
                    </td>
                    <td colspan="3">
                        <input class="form-control" type="text" maxlength="45" minlength="1" name="unidade" id="unidade" value="${material.unidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="PesquisaMaterialController">
                            <input class="btn btn-danger" type="button" value="voltar">
                        </a>
                    </td>
                    <td colspan="3" class="tdsalvar">
                        <input class="btn btn-success" type="submit" name="salvar" value="confirmar">
                    </td>
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