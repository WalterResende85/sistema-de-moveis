<%-- 
    Document   : cadastroPedido
    Created on : Oct 23, 2018, 11:33:13 AM
    Author     : davi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="styletelas.css">
    
    <title>Cadastro de Funcionario</title>
</head>

<body>
    
    <div class="cadastroCentralizado">
        <form action="">
            <table class="tableform">
                <tr><td><label for="nome">Nome</label></td><td colspan="3"><input type="text" name="" id="nome" placeholder="nome"></td></tr>
                <tr><td><label for="cpf">CPF</label></td><td colspan="3"><input type="text" name="" id="cpf" placeholder="CPF"></td></tr>
                <tr><td><label for="telefone">Telefone</label></td><td colspan="1"><input type="text" name="" id="telefone" placeholder="Telefone"></td></tr>
                <tr><td><label for="e-mail">e-mail</label></td><td colspan="3"><input type="text" name="" id="e-mail" placeholder="e-mail"></td></tr>
                <tr><td><label for="cep">CEP</label></td><td colspan="1"><input type="text" name="" id="cep" placeholder="cep"></td></tr>
                <tr><td><label for="logradouro">Logradouro</label></td><td colspan="3"><input type="text" name="" id="logradouro" placeholder="Av, rua, travessa..."></td></tr>
                <tr><td><label for="numero">Numero</label></td><td><input type="text" name="" id="numero" placeholder="nÃºmero"></td><td><label for="bairro">Bairro</label></td><td><input type="text" name="" id="bairro" placeholder="Bairro"></td></tr>
                <tr><td><label for="uf">UF</label></td><td><select name="" id=""><option value="AC">AC</option><option value="AL">AL</option>
                    <option value="AM">AM</option><option value="AP">AP</option><option value="BA">BA</option>
                    <option value="CE">CE</option><option value="DF">DF</option><option value="ES">ES</option>
                    <option value="GO">GO</option><option value="MA">MA</option><option value="MT">MT</option>
                    <option value="MS">MS</option><option value="MG">MG</option><option value="PA">PA</option>
                    <option value="PB">PB</option><option value="PR">PR</option><option value="PE">PE</option>
                    <option value="PI">PI</option><option value="RJ">RJ</option><option value="RN">RN</option>
                    <option value="RS">RS</option><option value="RO">RO</option><option value="RR">RR</option>
                    <option value="SC">SC</option><option value="SP">SP</option><option value="SE">SE</option>
                    <option value="TO">TO</option>             </select></td><td><label for="cidade">Cidade</label></td><td><input type="text" name="" id="cidade" placeholder="cidade"></td></tr>
                <tr><td>Cargo </td><td colspan="3"><select name="" id=""><option value="Estagiario">EstagiÃ¡rio</option>
                     <option value="Gerente">Gerente</option><option value="Marceneiro">Marceneiro</option> 
                     <option value="secretaria">SecretÃ¡ria</option></select></td></tr>
                     <tr><td><label for="salario">Salario</label></td><td><input type="text" name="" id="salario" placeholder="R$"></td><td>ComissÃ£o</td><td><input type="radio" name="comissao" value="s">S<input type="radio" name="comissao" value="n">N</td></tr> 
                     <tr><td><a href="gridFuncionario.html"><input type="button" value="voltar"></a></td><td colspan="3" class="tdsalvar" ><input type="submit" name="" value="salvar"></td></tr>
            </table>     
        </form> 
    </div>
</body>
</html>