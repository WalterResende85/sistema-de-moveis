<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" type="text/css" href="styletelas.css">

        <title>Cadastro de Funcionario</title>
    </head>

    <body>

        <div class="cadastroCentralizado">
           <form action="ManterFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" method="POST">
                <table class="tableform">
                    <tr><td colspan="4" style="text-align: center">${operacao}</td></tr>
                   <tr>
                        <td><label for="idFuncionario">idFuncionario</label></td>
                        <td colspan="3"><input type="text" name="idFuncionario" id="idFuncionario" placeholder="idFuncionario" value="${fornecedor.idFuncionario}"  <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                    
                    <tr>
                                    
                    <tr>
                        <td>
                            <label for="nome">Nome</label>
                        </td>
                        <td colspan="3">
                            <input type="text" name="nome" id="nome" placeholder="nome" value="${funcionario.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="cpf">CPF</label>
                            </td>
                            <td colspan="3">
                                <input type="text" name="cpf" id="cpf" placeholder="CPF" value="${funcionario.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="email">e-mail</label>
                            </td>
                            <td colspan="3">
                                <input type="text" name="email" id="email" placeholder="e-mail" value="${funcionario.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="cep">CEP</label>
                            </td>
                            <td colspan="1">
                                <input type="text" name="cep" id="cep" placeholder="cep" value="${funcionario.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="logradouro">Logradouro</label>
                            </td>
                            <td colspan="3">
                                <input type="text" name="logradouro" id="logradouro" placeholder="Av, rua, travessa..." value="${funcionario.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="numero">Numero</label>
                            </td>
                            <td>
                                <input type="text" name="numero" id="numero" placeholder="numero" value="${funcionario.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label for="bairro">Bairro</label>
                            </td>
                            <td>
                                <input type="text" name="bairro" id="bairro" placeholder="Bairro" value="${funcionario.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="uf">UF</label>
                            </td>
                            <td>
                                <select name="" id="">
                                    <option value="AC" <c:if test="${funcionario.uf.equals('AC')}"> selected</c:if>>AC</option>
                                <option value="AL" <c:if test="${funcionario.uf.equals('AL')}"> selected</c:if>>AL</option>
                                <option value="AM" <c:if test="${funcionario.uf.equals('AM')}"> selected</c:if>>AM</option>
                                <option value="AP" <c:if test="${funcionario.uf.equals('AP')}"> selected</c:if>>AP</option>
                                <option value="BA" <c:if test="${funcionario.uf.equals('BA')}"> selected</c:if>>BA</option>
                                <option value="CE" <c:if test="${funcionario.uf.equals('CE')}"> selected</c:if>>CE</option>
                                <option value="DF" <c:if test="${funcionario.uf.equals('DF')}"> selected</c:if>>DF</option>
                                <option value="ES" <c:if test="${funcionario.uf.equals('ES')}"> selected</c:if>>ES</option>
                                <option value="GO" <c:if test="${funcionario.uf.equals('GO')}"> selected</c:if>>GO</option>
                                <option value="MA" <c:if test="${funcionario.uf.equals('MA')}"> selected</c:if>>MA</option>
                                <option value="MT" <c:if test="${funcionario.uf.equals('MT')}"> selected</c:if>>MT</option>
                                <option value="MS" <c:if test="${funcionario.uf.equals('MS')}"> selected</c:if>>MS</option>
                                <option value="MG" <c:if test="${funcionario.uf.equals('MG')}"> selected</c:if>>MG</option>
                                <option value="PA" <c:if test="${funcionario.uf.equals('PA')}"> selected</c:if>>PA</option>
                                <option value="PB" <c:if test="${funcionario.uf.equals('PB')}"> selected</c:if>>PB</option>
                                <option value="PR" <c:if test="${funcionario.uf.equals('PR')}"> selected</c:if>>PR</option>
                                <option value="PE" <c:if test="${funcionario.uf.equals('PE')}"> selected</c:if>>PE</option>
                                <option value="PI" <c:if test="${funcionario.uf.equals('PI')}"> selected</c:if>>PI</option>
                                <option value="RJ" <c:if test="${funcionario.uf.equals('RJ')}"> selected</c:if>>RJ</option>
                                <option value="RN" <c:if test="${funcionario.uf.equals('RN')}"> selected</c:if>>RN</option>
                                <option value="RS" <c:if test="${funcionario.uf.equals('RS')}"> selected</c:if>>RS</option>
                                <option value="RO" <c:if test="${funcionario.uf.equals('RO')}"> selected</c:if>>RO</option>
                                <option value="RR" <c:if test="${funcionario.uf.equals('RR')}"> selected</c:if>>RR</option>
                                <option value="SC" <c:if test="${funcionario.uf.equals('SC')}"> selected</c:if>>SC</option>
                                <option value="SP" <c:if test="${funcionario.uf.equals('SP')}"> selected</c:if>>SP</option>
                                <option value="SE" <c:if test="${funcionario.uf.equals('SE')}"> selected</c:if>>SE</option>
                                <option value="TO" <c:if test="${funcionario.uf.equals('TO')}"> selected</c:if>>TO</option>
                                </select>
                            </td>
                            <td>
                                <label for="cidade">Cidade</label>
                            </td>
                            <td><input type="text" name="" id="cidade" placeholder="cidade" value="${funcionario.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td>Cargo </td>
                            <td colspan="3">
                                <select name="" id=""><option value="Estagiario">Estagiario</option>
                                    <option value="Gerente">Gerente</option>
                                    <option value="Marceneiro">Marceneiro</option> 
                                    <option value="secretaria">Secretaria</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="salario">Salario</label>
                            </td>
                            <td>
                                <input type="text" name="" id="salario" placeholder="R$" value="" value="${funcionario.salario}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </td>
                        <td>Comissão</td>
                        <td>
                            <input type="radio" name="comissao" value="s">S<input type="radio" name="comissao" value="n">N
                        </td>
                    </tr> 
                    <tr>
                        <td><a href="PesquisaFuncionarioController"><input type="button" value="voltar"></a></td>
                        <td colspan="3" class="tdsalvar" ><input type="submit" name="confirmar" value="Confirmar"></td>
                    </tr>
                </table>

            </form>

        </div>
    </body>

</html>