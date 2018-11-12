<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Sistema Interno</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="styletelas.css" />
        <script src="main.js"></script>
    </head>

    <body>
        <div>
            <form action="">
                <table class="tableform">
                    <tr>
                        <th>Menu</th>
                    </tr>
                    <tr>
                        <td><a href="PesquisaMovelController"><input type="button" value="Moveis" style="background: green"></a><br></td>
                    </tr>
                    <tr>
                        <td><a href="PesquisaFerramentaController"><input type="button" value="Ferramentas" style="background: yellowgreen"></a><br></td>
                    </tr>

                    <tr>
                        <td><a href="PesquisaFuncionarioController"><input type="button" value="Funcionario" style="background: yellowgreen"></a><br></td>
                    </tr>
                    <tr>
                        <td><a href="PesquisaFornecedorController"><input type="button" value="Fornecedor" style="background: yellowgreen"></a><br></td>
                    </tr>
                    <tr>
                        <td><a href="PesquisaClienteController"><input type="button" value="Cliente" style="background: yellowgreen"></a><br></td>
                    </tr>
                    <tr>
                        <td><a href="PesquisaPedidoController"><input type="button" value="Pedido" style="background: orangered"></a><br></td>
                    </tr>
                    <tr>
                        <td><a href="PesquisaMaterialController"><input type="button" value="Material" style="background: green"></a><br></td>
                    </tr>

                </table>
            </form>
        </div>
        <table>
            <tr><td style="background: green" class="orientacao">______</td><td>Pronto</td></tr>
            <tr><td style="background: yellowgreen" class="orientacao">______</td><td>Faltando inclusao do telefone e ou algum errinho de pegar dado na tabela</td></tr>
            <tr><td style="background: orangered" class="orientacao">______</td><td>Muito zuado, olhar toda a sequencia de classes</td></tr>
            <tr><td style="background: red" class="orientacao">______</td><td>Faltando alguma parte para testar</td></tr>
        </table>
        
    </body>
</html>