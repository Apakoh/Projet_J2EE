<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Saisie d'un taux de remise</title>
    </head>
    <body>

            <h1>Mes bons de commandes</h1>

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
                                            <td class="modifier">
                                                <a href="?action=DELETE&code=${discountCode.code}">Modifier</a>
                                            </td>
                                            <td class="modifier">
                                                <a href="?action=DELETE&code=${discountCode.code}">Delete</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                        </table>
                </div>   
                <div class="button2">
                    <button name="action" value="retourChoix" class="button">Retour</button>
                    <button name="action" style="width:170px" value="deconnexion" class="button">Déconnexion</button>
                </div>
            </form>

    </body>
    
    <style type="text/css">

        body{
             background:#2980b9;
             font-family:Arial, Helvetica, sans-serif;
             font-size:20px;
        }
            
        h1{
           color: white;
           font-size: 50px;
           text-align: center;
        }
        
        table {
               background: white;
               font-family: arial, sans-serif;
               border-collapse: collapse;
               width: 80%;
               margin : auto;
          }
            
        td, th {
                text-align: center;
          }
            
        tr:nth-child(even) {
            background-color: #dddddd;
        }
        
        .modifier{
            background:#e67e22;
        }
        
        .button{
            font:bold 18px Arial;
            background:#34495e;
            color:white;
            width:165px;
            height: 55px;
            border:none;
            cursor: pointer;
        }
        
        .button2{
            width: 30%;
            margin: auto;
            padding-top: 65px;
        }
        
        .button:hover{
          background: #e67e22;
        }
            
    </style>
</html>
