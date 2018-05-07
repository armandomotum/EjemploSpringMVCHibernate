<%-- 
    Document   : pendientes
    Created on : 15/04/2018, 03:12:24 PM
    Author     : Ejercicioooooooooooo
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
        
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!--        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>-->
    </head>
    <body>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="col-md-6">
                    <h1 class="text-center">Lista Pendientes</h1>
                    <table class="table table-bordered table-striped">
                        <tr>
                            <th>ID</th>
                            <th>Descripcion</th>
                            <th></th>
                            <th></th>
                        </tr>
                        <c:forEach var="p" items="${listaPendientes}">
                            <tr>
                                <td>${p.id}</td>
                                <td>${p.descripcion}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/pendientes/pantallaModificarPendiente/${p.id}" class="btn btn-info btn-xs"><i class="glyphicon glyphicon-check"></i> Modificar</a>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/pendientes/deletePendiente/${p.id}" class="btn btn-danger btn-xs">   <i class="glyphicon glyphicon-trash"></i> Borrar   </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div> 
        </div>

        
        <br/><br/><br/><br/>
        
        
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="col-md-6">
                    <h1 class="text-center" >${TextAgregarActualizar} Pendiente</h1>
                    <form:form method="post" action="${pageContext.request.contextPath}/pendientes/${actionPathRelativeSaveOrUpdate}" commandName="pendiente">
                        <table class="table table-bordered table-striped">
                            <tr>
                                <td><form:label path="id">ID</form:label></td>
                                <td><form:input path="id" readonly="true" /></td>
                            </tr>
                            <tr>
                                <td><form:label path="descripcion">Descripcion</form:label></td>
                                <td><form:input path="descripcion" required="required" /></td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" value="${TextAgregarActualizar}" class="btn btn-success" />
                                </td>
                            </tr>
                        </table>
                    </form:form>  
                </div>
            </div> 
        </div>
    </body>
</html>
