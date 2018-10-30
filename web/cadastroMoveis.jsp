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
    <h1>Manter Curso - ${operacao}</h1>
    <div class="cadastroCentralizado">
        <form action="ManterMovelController?acao=confirmarOperacao&operacao=${operacao}">
            <table class="tableform">
                <tr><td>Tipo</td><td>Material</td><td>Acabamento</td><td>Tamanhos</td></tr>
                <tr>
                    <c:forEach items="moveis" var="movel">
                        <td>
                            <select name="movel" id="${movel.idMovel}" multiple> 
                                <option value="${movel.idMovel}">${movel.acabamento}</option>
                            </select>
                        </td>
                    </c:forEach>
                    <td>altura<input type="text"><br>largura<input type="text">comprimento<input type="text"></td>
                </tr>
                
                <tr><td><label for="peso">Peso</label></td><td><input type="text" name="" id="peso" value="${movel.peso}" placeholder="peso"></td><td><label for="nome">Nome</label></td><td colspan="2"><input type="text" name="" id="nome" value="${movel.nome}" placeholder="nome"></td></tr>
                <tr><td><label for="preco">Preço</label></td><td><input type="text" name="" id="preco" value="${movel.preco}" placeholder="R$"></td></tr>
                <tr><td>Imagem</td> <td colspan="2"><input type="file" value="imagem"></td></tr>
                <tr><td><a href="PesquisaMovelController"><input type="button" value="voltar"></a></td><td class="tdsalvar" colspan="3"><input type="submit"name="" value="Salvar"> </td></tr>
            </table>
        </form>
    </div>
</body>
</html>