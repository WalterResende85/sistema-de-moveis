<%@page contentType = "text/html" pageEncoding="utf-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Grid Ferramenta</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >

        <script src="main.js"></script>


    </head>

    <body>
        <div>

            <table class="table table-striped table-bordered table-condensed table-hover">
                <tr>
                    <th colspan="4">Grid Ferramenta</th>
                </tr>
                <tr>
                    <th>Cod</th>
                    <th>nome</th>
                    <th colspan="2">Ações</th>
                </tr>
                <c:forEach items="${ferramentas}" var="ferramenta">
                    <tr>
                        <td>
                            <c:out value="${ferramenta.idFerramenta}" />
                        </td>
                        <td>
                            <c:out value="${ferramenta.nome}" />
                        </td>
                        <td><a class="btn btn-primary" href="ManterFerramentaController?acao=prepararOperacao&operacao=Editar&idFerramenta=<c:out value="${ferramenta.idFerramenta}" />">Editar</a></td>
                        <td><a class="btn btn-primary" href="ManterFerramentaController?acao=prepararOperacao&operacao=Excluir&idFerramenta=<c:out value="${ferramenta.idFerramenta}" />">Excluir</a></td>
                    </tr>
                </c:forEach>

                <td><a class="btn btn-danger" href="index.jsp">Voltar</a></td>
                <td><a class="btn btn-primary" href="ManterFerramentaController?acao=prepararOperacao&operacao=Incluir">Incluir</a></td>
            </table>



        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </body>

</html>