
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" type="text/css">

        <title>Cadastro de Clientes</title>
    </head>

    <body>

        <div class="container">
            <form action="ManterClienteController?acao=confirmarOperacao&operacao=${operacao}" method="POST" autofocus>
                <table>
                    <tr><td colspan="4" style="text-align: center">${operacao} Cliente</td></tr>

                    <tr><td><label for="idCliente">Código do Cliente</label></td>
                        <td colspan="3">
                            <input type="number" min="1" class="form-control" name="idCliente" required id="idCliente" value="${cliente.idCliente}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="nome">Nome</label></td><td colspan="3"><input class="form-control" type="text" maxlength="45" minlength="3"  name="nome" required id="nome" value="${cliente.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                    <tr><td><label for="cpf">CPF</label></td><td colspan="3"><input class="form-control" type="number" maxlenght="14" minlength="14" required name="cpf" id="cpf" value="${cliente.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                    <tr><td><label for="dataNascimento">Data de Nascimento</label></td><td colspan="3"><input class="form-control" type="date" maxlenght="10" minlength="10"  required name="dataNascimento" id="dataNascimento" value="${cliente.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                    <tr><td><label for="celular">Celular</label></td><td><input class="form-control"  type="number" maxlenght="13" minlength="9" name="celular" required id="celular" value="${cliente.celular}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        <td><label for="telefone">Telefone</label></td><td><input class="form-control" type="number" maxlenght="13" minlength="8" name="telefone" id="telefone" value="${cliente.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                    <tr><td><label for="e-mail">e-mail</label></td><td colspan="3"><input class="form-control" type="email" name="email" required id="email" value="${cliente.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                    <tr><td><label for="cep">CEP</label></td><td colspan="1"><input class="form-control" type="text" name="cep" id="cep" maxlenght="9" minlength="9"  required value="${cliente.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                    <tr><td><label for="logradouro">Logradouro</label></td><td colspan="3"><input class="form-control" type="text" required name="logradouro" maxlenght="45" minlength="3" id="logradouro" value="${cliente.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                    <tr><td><label for="numero">Número</label></td><td><input class="form-control" type="number" maxlenght="6" minlength="1" name="numero" required id="numero" value="${cliente.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td><td><label for="bairro">Bairro</label></td><td><input class="form-control" type="text" name="bairro" id="bairro" value="${cliente.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                        <tr>
                            <td><label for="uf" required>UF</label></td>
                            <td>
                                    <select class="form-control" name="uf" id="" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <option value="AC" <c:if test="${cliente.uf.equals('AC')}"> selected</c:if>>AC</option>
                                <option value="AL" <c:if test="${cliente.uf.equals('AL')}"> selected</c:if>>AL</option>
                                <option value="AM" <c:if test="${cliente.uf.equals('AM')}"> selected</c:if>>AM</option>
                                <option value="AP" <c:if test="${cliente.uf.equals('AP')}"> selected</c:if>>AP</option>
                                <option value="BA" <c:if test="${cliente.uf.equals('BA')}"> selected</c:if>>BA</option>
                                <option value="CE" <c:if test="${cliente.uf.equals('CE')}"> selected</c:if>>CE</option>
                                <option value="DF" <c:if test="${cliente.uf.equals('DF')}"> selected</c:if>>DF</option>
                                <option value="ES" <c:if test="${cliente.uf.equals('ES')}"> selected</c:if>>ES</option>
                                <option value="GO" <c:if test="${cliente.uf.equals('GO')}"> selected</c:if>>GO</option>
                                <option value="MA" <c:if test="${cliente.uf.equals('MA')}"> selected</c:if>>MA</option>
                                <option value="MT" <c:if test="${cliente.uf.equals('MT')}"> selected</c:if>>MT</option>
                                <option value="MS" <c:if test="${cliente.uf.equals('MS')}"> selected</c:if>>MS</option>
                                <option value="MG" <c:if test="${cliente.uf.equals('MG')}"> selected</c:if>>MG</option>
                                <option value="PA" <c:if test="${cliente.uf.equals('PA')}"> selected</c:if>>PA</option>
                                <option value="PB" <c:if test="${cliente.uf.equals('PB')}"> selected</c:if>>PB</option>
                                <option value="PR" <c:if test="${cliente.uf.equals('PR')}"> selected</c:if>>PR</option>
                                <option value="PE" <c:if test="${cliente.uf.equals('PE')}"> selected</c:if>>PE</option>
                                <option value="PI" <c:if test="${cliente.uf.equals('PI')}"> selected</c:if>>PI</option>
                                <option value="RJ" <c:if test="${cliente.uf.equals('RJ')}"> selected</c:if>>RJ</option>
                                <option value="RN" <c:if test="${cliente.uf.equals('RN')}"> selected</c:if>>RN</option>
                                <option value="RS" <c:if test="${cliente.uf.equals('RS')}"> selected</c:if>>RS</option>
                                <option value="RO" <c:if test="${cliente.uf.equals('RO')}"> selected</c:if>>RO</option>
                                <option value="RR" <c:if test="${cliente.uf.equals('RR')}"> selected</c:if>>RR</option>
                                <option value="SC" <c:if test="${cliente.uf.equals('SC')}"> selected</c:if>>SC</option>
                                <option value="SP" <c:if test="${cliente.uf.equals('SP')}"> selected</c:if>>SP</option>
                                <option value="SE" <c:if test="${cliente.uf.equals('SE')}"> selected</c:if>>SE</option>
                                <option value="TO" <c:if test="${cliente.uf.equals('TO')}"> selected</c:if>>TO</option>   
                                </select>
                            </td>
                            <td><label for="cidade">Cidade</label></td><td><input class="form-control" type="text" maxlenght="45" minlength="2" required name="cidade" id="cidade" value="${cliente.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                    <tr><td><label for="complemento">Complemento</label></td><td><input class="form-control" type="text" maxlenght="45" name="complemento" id="complemento" value="${cliente.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>

                    <tr>
                        <td><a href="PesquisaClienteController"><input class="btn btn-danger" type="button" value="voltar"></a></td>
                        <td colspan="3"><input class="btn btn-success" type="submit" name="salvar" value="Confirmar"></td>
                    </tr>

                </table>
            </form>
        </div>
        <!-- Optional JavaScript -->

        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script>

        </script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </body>
</html>