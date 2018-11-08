<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>


<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Grid Material</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="styletelas.css" />
    <script src="main.js"></script>


</head>

<body>
    <div class="cadastroCentralizado">

        <table class="tablegrid">
            <tr>
                <th colspan="4">Grid Material</th>
            </tr>
            <tr>
                <td>Cod</td>
                <td>nome</td>
                <td colspan="2">Ações</td>
            </tr>
            <c:forEach items="${materiais}" var="material">
                <tr>
                    <td>
                        <c:out value="${material.idMaterial}" />
                    </td>
                    <td>
                        <c:out value="${material.nome}" /><!--talvez tenha que tirar-->
                    </td>
                    <td><a href="ManterMaterialController?acao=prepararOperacao&operacao=Editar&idMaterial=<c:out value="${material.idMaterial}" />">Editar</a></td>
                    <td><a href="ManterMaterialController?acao=prepararOperacao&operacao=Excluir&idMaterial=<c:out value="${material.idMaterial}" />">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterMaterialController?acao=prepararOperacao&operacao=Incluir" method="POST">
            
            <a href="index.jsp"><button type="button">Voltar</button></a>
                <input type="submit" name="btnIncluir" value="incluir">            
        </form>
    </div>

</body>

</html>