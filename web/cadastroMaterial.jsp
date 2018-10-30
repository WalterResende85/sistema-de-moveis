<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="styletelas.css">

    <title>Cadastro de Materiais</title>
</head>

<body>

    <div class="cadastroCentralizado">
        <form action="">
            <table class="tableform">
                <tr>
                    <td>
                        <label for="nome">Nome</label>
                    </td>
                    <td colspan="3">
                        <input type="text" name="" id="nome" placeholder="nome">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="">Tipo</label>
                    </td>
                    <td colspan="3">
                        <input type="text" name="" id="tipo" placeholder="tipo">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="quantidade">Quantidade</label>
                    </td>
                    <td colspan="1">
                        <input type="text" name="" id="quantidade" placeholder="quantidade">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="valor unitario">Valor Unitario</label>
                    </td>
                    <td colspan="3">
                        <input type="text" name="" id="valorUnitario" placeholder="valorUnitario">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="unidade">Unidade</label>
                    </td>
                    <td colspan="1">
                        <input type="text" name="" id="unidade" placeholder="unidade">
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="gridMaterial.jsp">
                            <input type="button" value="voltar">
                        </a>
                    </td>
                    <td colspan="3" class="tdsalvar">
                        <input type="submit" name="" value="salvar">
                    </td>
                </tr>
            </table>

        </form>

    </div>
</body>

</html>