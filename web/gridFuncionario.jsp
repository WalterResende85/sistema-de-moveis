
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>



<html lang="pt-br">

    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Grid funcion�rio</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
        <script src="main.js"></script>


    </head>

    <body>
        <div class="container">

            <table class="table table-striped table-bordered table-condensed table-hover">
                <tr>
                    <th colspan="4">Grid funcionario</th>
                </tr>
                <tr>
                    <th>Cod</th>
                    <th>nome</th>
                    <th colspan="2">A��es</th>
                </tr>
                <c:forEach items="${funcionarios}" var="funcionario">
                    <tr>
                        <td>
                            <c:out value="${funcionario.idFuncionario}" />
                        </td>
                        <td>
                            <c:out value="${funcionario.nome}" />
                        </td>
                        <td><a class="btn btn-primary" href="ManterFuncionarioController?acao=prepararOperacao&operacao=Editar&idFuncionario=<c:out value="${funcionario.idFuncionario}" />">Editar</a></td>
                        <td><a class="btn btn-primary" href="ManterFuncionarioController?acao=prepararOperacao&operacao=Excluir&idFuncionario=<c:out value="${funcionario.idFuncionario}" />">Excluir</a></td>
                    </tr>
                </c:forEach>
                <td><a class="btn btn-danger" href="index.jsp">Voltar</a></td>
                <td colspan="3"><a class="btn btn-primary" href="ManterFuncionarioController?acao=prepararOperacao&operacao=Incluir">Incluir</a></td>
            </table>

        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

    </body>

</html>