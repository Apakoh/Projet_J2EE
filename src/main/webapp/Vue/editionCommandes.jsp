<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Saisie d'un taux de remise</title>
    </head>
    <body>

            <h2>Mes bons de commandes</h2>


            <div>
                    <table border="1">
                            <tbody>
                                <tr>
                                    <th>ID</th>
                                    <th>Nom</th>
                                    <th>Quantité</th>
                                    <th>Prix Livraison</th>
                                    <th>Date</th>
                                    <th>Date de Livraison</th>
                                    <th>Fournisseur</th>
                                </tr>             
                                
                                <!--c:forEach var="discountCode" items="${discountCodes}">-->
                                    <tr>
                                        <td>
                                            oui
                                        </td>
                                        <td>
                                            oui
                                        </td>
                                        <td>
                                            oui
                                        </td>
                                        <td>
                                            oui
                                        </td>
                                        <td>
                                            oui
                                        </td>
                                        <td>
                                            oui
                                        </td>
                                        <td>
                                            oui
                                        </td>
                                        <td>
                                            <a href="?action=DELETE&code=${discountCode.code}">Modifier</a>
                                        </td>
                                        <td>
                                            <a href="?action=DELETE&code=${discountCode.code}">Delete</a>
                                        </td>
                                    </tr>
                                <!--/c:forEach-->
                            </tbody>
                    </table>
            </div>

    </body>
</html>
