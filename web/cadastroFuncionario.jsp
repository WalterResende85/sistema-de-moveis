<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
         <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >

        <title>Cadastro de Funcionario</title>
    </head>

    <body>

        <div class="container">
            <form action="ManterFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" method="POST">
                <table class="tableform">
                    <tr><td colspan="4" style="text-align: center">${operacao} Funcionario</td></tr>
                    <tr>
                        <td><label for="idFuncionario">idFuncionario</label></td>
                        <td colspan="3"><input class="form-control" type="number" required min="1" name="idFuncionario" id="idFuncionario" placeholder="idFuncionario" value="${funcionario.idFuncionario}"  <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>

                        <tr>

                        <tr>
                            <td>
                                <label for="nome">Nome</label>
                            </td>
                            <td colspan="3">
                                <input class="form-control" type="text" required maxlength="45" minlength="3" name="nome" id="nome" placeholder="nome" value="${funcionario.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="senha">Senha</label>
                            </td>
                            <td colspan="3">
                                <input class="form-control" type="text" name="senha" id="senha" placeholder="senha" value="${funcionario.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="cpf">CPF</label>
                            </td>
                            <td colspan="3">
                                <input class="form-control" type="text" required maxlength="11" minlength="11" min="1" name="cpf" id="cpf" placeholder="CPF" value="${funcionario.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="dataNascimento">Data de Nascimento</label>
                            </td>
                            <td colspan="3">
                                <input class="form-control" type="date" required name="dataNascimento" id="dataNascimento" placeholder="dataNascimento" value="${funcionario.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        
                        
                        <tr>
                            <td>
                                <label for="email">e-mail</label>
                            </td>
                            <td colspan="3">
                                <input class="form-control" type="email" required name="email" id="email" placeholder="e-mail" value="${funcionario.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr><td><label for="celular">Celular</label></td><td><input class="form-control" type="text" required name="celular" id="celular" placeholder="celular" value="${funcionario.celular}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td><td><label for="telefone">Telefone</label></td><td><input class="form-control" type="text" name="telefone" id="telefone" placeholder="telefone" value="${funcionario.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                        <tr>
                            <td>
                                <label for="cep">CEP</label>
                            </td>
                            <td colspan="1">
                                <input class="form-control" type="text" required name="cep" id="cep" placeholder="cep" value="${funcionario.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="logradouro">Logradouro</label>
                            </td>
                            <td colspan="3">
                                <input class="form-control" type="text" required maxlength="45" minlength="3" name="logradouro" id="logradouro" placeholder="Av, rua, travessa..." value="${funcionario.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="numero">Numero</label>
                            </td>
                            <td>
                                <input class="form-control" type="number" required min="1" name="numero" id="numero" placeholder="numero" value="${funcionario.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label for="bairro">Bairro</label>
                            </td>
                            <td>
                                <input class="form-control" type="text" required maxlength="45" minlength="3" name="bairro" id="bairro" placeholder="Bairro" value="${funcionario.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="uf">UF</label>
                            </td>
                            <td>
                                <select name="uf" id="uf" class="form-control">
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
                            <td>
                                <input class="form-control" type="text" required maxlength="45" minlength="3" name="cidade" id="cidade" placeholder="cidade" value="${funcionario.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="complemento">Complemento</label>
                            </td>
                            <td colspan="3">
                                <input class="form-control" type="text" maxlength="45" minlength="3" name="complemento" id="complemento" placeholder="complemento" value="${funcionario.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        
                        <tr>
                            <td>Cargo </td>
                            <td colspan="3">
                                <select name="cargo" required id="cargo" class="form-control">
                                    <option value="Estagiário" <c:if test="${funcionario.cargo.equals('Estagiario')}"> selected</c:if>>Estagiario</option>
                                    <option value="Gerente" <c:if test="${funcionario.cargo.equals('Gerente')}"> selected</c:if>>Gerente</option>
                                    <option value="Marceneiro" <c:if test="${funcionario.cargo.equals('Marceneiro')}"> selected</c:if>>Marceneiro</option> 
                                    <option value="secretária" <c:if test="${funcionario.cargo.equals('Secretaria')}"> selected</c:if>>Secretaria</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="salario">Salario</label>
                            </td>
                            <td>
                                <input class="form-control" type="number" required min="0" name="salario" id="salario" placeholder="R$" value="${funcionario.salario}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </td>
                        <td>Comissão&nbsp;</td>
                        <td>
                            <input type="radio" required name="comissao" value="S" <c:if test="${funcionario.comissao.equals('S')}"> checked</c:if>>S&nbsp;
                            <input type="radio" required name="comissao" value="N" <c:if test="${funcionario.comissao.equals('N')}"> checked</c:if>>N
                        </td>
                    </tr>
                    
                    <tr>
                        <td><a href="PesquisaFuncionarioController"><input class="btn btn-danger" type="button" value="voltar"></a></td>
                        <td colspan="3" class="tdsalvar" ><input class="btn btn-success" type="submit" name="confirmar" value="Confirmar"></td>
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