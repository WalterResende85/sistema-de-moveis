<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >

        <title>Cadastro de Fornecedor</title>
    </head>

    <body>

        <div class="container">
            <form action="ManterFornecedorController?acao=confirmarOperacao&operacao=${operacao}" method="POST">
                <table class="tableform">
                    <tr><td colspan="4" style="text-align: center">${operacao} Fornecedor</td></tr>
                    <tr>
                        <td><label for="idFornecedor">C�digo do Fornecedor</label></td>
                        <td colspan="3"><input class="form-control" type="number" required min="1" name="idFornecedor" id="idFornecedor" value="${fornecedor.idFornecedor}"  <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>

                        <tr>
                            <td><label for="nome">Nome</label></td>
                            <td colspan="3"><input class="form-control" type="text" required maxlength="45" minlength="3" name="nome" id="nome" value="${fornecedor.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td><label for="cnpj">CNPJ</label></td>
                            <td colspan="3"><input class="form-control" type="number" required min="1" name="cnpj" id="cnpj" value="${fornecedor.cnpj}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>


                        <tr>
                            <td><label for="email">e-mail</label></td>
                            <td colspan="3"><input class="form-control" type="text" required maxlength="45" minlength="3" name="email" id="email" value="${fornecedor.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr><td><label  for="celular">Celular</label></td><td><input class="form-control" type="text" required name="celular" id="celular" value="${fornecedor.celular}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td><td><label for="telefone">Telefone</label></td><td><input class="form-control" type="text" name="telefone" id="telefone" value="${fornecedor.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                        <tr>
                            <td><label for="cep">CEP</label>
                                </td><td colspan="1"><input class="form-control" type="text" required min="1" name="cep" id="cep" value="${fornecedor.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td><label for="rua">Logradouro</label></td>
                            <td colspan="3"><input class="form-control" type="text" required maxlength="45" minlength="3" name="logradouro" id="rua" value="${fornecedor.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td><label for="numero">Numero</label></td>
                            <td><input class="form-control" type="number" required min="1" name="numero" id="numero"  value="${fornecedor.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            <td><label for="bairro">Bairro</label></td>
                            <td><input class="form-control" type="text" required maxlength="45" minlength="3" name="bairro" id="bairro" value="${fornecedor.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td>
                                <label for="uf">UF</label>
                            </td>
                            <td>
                                <select class="form-control" required name="uf" id="uf" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
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
                                <input class="form-control" type="text" required maxlength="45" minlength="3" name="cidade" id="cidade" value="${fornecedor.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="complemento">Complemento</label></td>
                            <td colspan="3"><input class="form-control" type="text" name="complemento" id="complemento" value="${fornecedor.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>


                    <tr><td><a href="PesquisaFornecedorController"><input class="btn btn-danger" type="button" value="voltar"></a></td><td colspan="3" class="tdsalvar" ><input class="btn btn-success" type="submit" name="confirmar" value="Confirmar"></td></tr>
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