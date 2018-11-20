
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Grid Móveis</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
        <script src="main.js"></script>
    </head>

    <body>
        <div class="container">

            <table class="table table-striped table-bordered table-condensed table-hover">
                <tr>
                    <th colspan="4">Grid Moveis</th>
                </tr>
                <tr>
                    <th>Cod</th>
                    <th>nome</th>
                    <th colspan="2">Ações</th>
                </tr>
                <c:forEach items="${moveis}" var="movel">
                    <tr>
                        <td>
                            <c:out value="${movel.idMovel}" />
                        </td>
                        <td>
                            <c:out value="${movel.nome}" />
                        </td>
                        <td><a class="btn btn-primary" href="ManterMoveisController?acao=prepararOperacao&operacao=Editar&idMovel=<c:out value="${movel.idMovel}" />">Editar</a></td>
                        <td><a class="btn btn-primary" href="ManterMoveisController?acao=prepararOperacao&operacao=Excluir&idMovel=<c:out value="${movel.idMovel}" />">Excluir</a></td>
                    </tr>
                </c:forEach>
                <td><a class="btn btn-danger" href="index.jsp">Voltar</a></td>
                <td colspan="3"><a class="btn btn-primary" href="ManterMoveisController?acao=prepararOperacao&operacao=Incluir">Incluir</a></td>
            </table>

        </div>
    </body>

</html>