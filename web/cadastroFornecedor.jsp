<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" type="text/css" href="styletelas.css">

        <title>Cadastro de Fornecedor</title>
    </head>

    <body>

        <div class="cadastroFuncionario">
            <form action="ManterFornecedorController?acao=confirmarOperacao&operacao=${operacao}" method="POST">
                <table class="tableform">
                    <tr><td colspan="4" style="text-align: center">${operacao} Fornecedor</td></tr>
                    <tr>
                        <td><label for="idFornecedor">ID Fornecedor</label></td>
                        <td colspan="3"><input type="text" name="idFornecedor" id="idFornecedor" placeholder="idFornecedor" value="${fornecedor.idFornecedor}"  <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                    
                    <tr>
                        <td><label for="nome">Nome</label></td>
                        <td colspan="3"><input type="text" name="nome" id="nome" placeholder="nome" value="${fornecedor.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td><label for="cnpj">CNPJ</label></td>
                            <td colspan="3"><input type="text" name="cnpj" id="cnpj" placeholder="CNPJ" value="${fornecedor.cnpj}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        
                                               
                        <tr>
                            <td><label for="email">e-mail</label></td>
                            <td colspan="3"><input type="text" name="email" id="email" placeholder="e-mail" value="${fornecedor.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td><label for="cep">CEP</label>
                            </td><td colspan="1"><input type="text" name="cep" id="cep" placeholder="cep" value="${fornecedor.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td><label for="logradouro">Logradouro</label></td>
                            <td colspan="3"><input type="text" name="logradouro" id="logradouro" placeholder="Av, rua, travessa..." value="${fornecedor.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td><label for="numero">Numero</label></td>
                            <td><input type="text" name="numero" id="numero" placeholder="número" value="${fornecedor.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            <td><label for="bairro">Bairro</label></td>
                            <td><input type="text" name="bairro" id="bairro" placeholder="Bairro" value="${fornecedor.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td>
                                <label for="uf">UF</label>
                            </td>
                            <td>
                                <select name="uf" id="" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <option value="AC" <c:if test="${fornecedor.uf.equals('AC')}"> selected</c:if>>AC</option>
                                <option value="AL" <c:if test="${fornecedor.uf.equals('AL')}"> selected</c:if>>AL</option>
                                <option value="AM" <c:if test="${fornecedor.uf.equals('AM')}"> selected</c:if>>AM</option>
                                <option value="AP" <c:if test="${fornecedor.uf.equals('AP')}"> selected</c:if>>AP</option>
                                <option value="BA" <c:if test="${fornecedor.uf.equals('BA')}"> selected</c:if>>BA</option>
                                <option value="CE" <c:if test="${fornecedor.uf.equals('CE')}"> selected</c:if>>CE</option>
                                <option value="DF" <c:if test="${fornecedor.uf.equals('DF')}"> selected</c:if>>DF</option>
                                <option value="ES" <c:if test="${fornecedor.uf.equals('ES')}"> selected</c:if>>ES</option>
                                <option value="GO" <c:if test="${fornecedor.uf.equals('GO')}"> selected</c:if>>GO</option>
                                <option value="MA" <c:if test="${fornecedor.uf.equals('MA')}"> selected</c:if>>MA</option>
                                <option value="MT" <c:if test="${fornecedor.uf.equals('MT')}"> selected</c:if>>MT</option>
                                <option value="MS" <c:if test="${fornecedor.uf.equals('MS')}"> selected</c:if>>MS</option>
                                <option value="MG" <c:if test="${fornecedor.uf.equals('MG')}"> selected</c:if>>MG</option>
                                <option value="PA" <c:if test="${fornecedor.uf.equals('PA')}"> selected</c:if>>PA</option>
                                <option value="PB" <c:if test="${fornecedor.uf.equals('PB')}"> selected</c:if>>PB</option>
                                <option value="PR" <c:if test="${fornecedor.uf.equals('PR')}"> selected</c:if>>PR</option>
                                <option value="PE" <c:if test="${fornecedor.uf.equals('PE')}"> selected</c:if>>PE</option>
                                <option value="PI" <c:if test="${fornecedor.uf.equals('PI')}"> selected</c:if>>PI</option>
                                <option value="RJ" <c:if test="${fornecedor.uf.equals('RJ')}"> selected</c:if>>RJ</option>
                                <option value="RN" <c:if test="${fornecedor.uf.equals('RN')}"> selected</c:if>>RN</option>
                                <option value="RS" <c:if test="${fornecedor.uf.equals('RS')}"> selected</c:if>>RS</option>
                                <option value="RO" <c:if test="${fornecedor.uf.equals('RO')}"> selected</c:if>>RO</option>
                                <option value="RR" <c:if test="${fornecedor.uf.equals('RR')}"> selected</c:if>>RR</option>
                                <option value="SC" <c:if test="${fornecedor.uf.equals('SC')}"> selected</c:if>>SC</option>
                                <option value="SP" <c:if test="${fornecedor.uf.equals('SP')}"> selected</c:if>>SP</option>
                                <option value="SE" <c:if test="${fornecedor.uf.equals('SE')}"> selected</c:if>>SE</option>
                                <option value="TO" <c:if test="${fornecedor.uf.equals('TO')}"> selected</c:if>>TO</option>
                                </select>
                            </td>
                            <td>
                                <label for="cidade">Cidade</label>
                            </td>
                            <td>
                                <input type="text" name="cidade" id="cidade" placeholder="cidade" value="${fornecedor.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </td>
                    </tr>
                     <tr>
                            <td><label for="complemento">Complemento</label></td>
                            <td colspan="3"><input type="text" name="complemento" id="complemento" placeholder="complemento" value="${fornecedor.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                     <c:forEach  items="${telefones}" var="telefone">
                    <tr><td><label for="telefone">Telefone</label></td><td><input type="text" name="telefone" id="telefone" placeholder="telefone" value="${telefone.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                    </c:forEach>
                    <tr><td>Produtos fornecido</td><td></td></tr>
                    <tr><td><a href="PesquisaFornecedorController"><input type="button" value="voltar"></a></td><td colspan="3" class="tdsalvar" ><input type="submit" name="confirmar" value="Confirmar"></td></tr>
                </table>

            </form>

        </div>
    </body>

</html>