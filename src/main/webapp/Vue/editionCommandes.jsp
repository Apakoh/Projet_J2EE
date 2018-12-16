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

            <form method="POST">
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

                                    <c:forEach var="bonCommande" items="${bonCommandes}">
                                        <tr>
                                            <td>
                                                ${bonCommande.getOrderNum()}
                                            </td>
                                            <td>
                                                ${bonCommande.getProductID()}
                                            </td>
                                            <td>
                                                ${bonCommande.getQuantite()}
                                            </td>
                                            <td>
                                                ${bonCommande.getShippingCost()}
                                            </td>
                                            <td>
                                                ${bonCommande.getSalesDate()}
                                            </td>
                                            <td>
                                                ${bonCommande.getShippingDate()}
                                            </td>
                                            <td>
                                                ${bonCommande.getCompagnyName()}
                                            </td>
                                            <td>
                                                <a href="?action=DELETE&code=${discountCode.code}">Modifier</a>
                                            </td>
                                            <td>
                                                <a href="?action=DELETE&code=${discountCode.code}">Delete</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                        </table>
                </div>        
                <button name="action" value="retourChoix" class="button">Retour</button>
                <button name="action" style="width:170px" value="deconnexion" class="button">Déconnexion</button>
            </form>

    </body>
</html>
