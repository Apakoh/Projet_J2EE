<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Saisie d'un taux de remise</title>
    </head>
    <body>

            <h2 id="banner">Mes bons de commandes</h2>

            <form method="POST">
                <div class="recuadro">
                    <div class="contenu">
                        <table>
                            <tr>
                                <th>ID</th>
                                <th>Nom</th>
                                <th>Quantité</th>
                                <th>Prix Livraison</th>
                                <th>Date</th>
                                <th>Livraison</th>
                                <th>Fournisseur</th>
                            </tr>
                            <c:forEach var="bonCommande" items="${bonCommandes}">        
                                <tr>
                                    <div id="nav">

                                        <td class="d0"> <input name="idProd" type="text" value="${bonCommande.getOrderNum()}" readonly="readonly" /> </td>

                                        <td class="d1"> <input name="pid" type="text" value="${bonCommande.getProductID()}" /> </td>

                                        <td class="d0"> <input name="quantite" type="text" value="${bonCommande.getQuantite()}" /> </td>

                                        <td class="d1"> <input name="prixLivraison" type="text" value="${bonCommande.getShippingCost()}" readonly="readonly" /> </td>

                                        <td class="d0"> <input name="dateVentes" type="date" value="${bonCommande.getSalesDate()}" readonly="readonly" /> </td>

                                        <td class="d1"> <input name="dateLivraison" type="date" value="${bonCommande.getShippingDate()}" readonly="readonly" /> </td>

                                        <td class="d0"> <input name="nomFournisseur" type="text" value="${bonCommande.getCompagnyName()}" readonly="readonly" /> </td>
                                        
                                        <td class="d1"> <button class="b0" name="action" value="modifierBons" class="button">Modifier</button> </td>
                                            
                                        <td class="d0"> <button class="b0" name="action" value="supprimerBons" class="button">Supprimer</button> </td>

                                    </div>
                                </tr>
                            </c:forEach>
                            <tr>
                                    <div id="nav">

                                        <td class="d0"> <input name="id" type="text" placeholder="Order ID" /> </td>

                                        <td class="d1"> <input name="pid" type="text" placeholder="Produit ID" /> </td>

                                        <td class="d0"> <input name="quantite" type="text" placeholder="Quantite" /> </td>

                                        <td class="d1"> <input name="prixLivraison" type="text" placeholder="Prix Livraison" /> </td>

                                        <td class="d0"> <input name="dateVentes" type="date" placeholder="Date Ventes" /> </td>

                                        <td class="d1"> <input name="dateLivraison" type="date" placeholder="Date Livraison" /> </td>

                                        <td class="d0"> <input name="nomFournisseur" type="text" placeholder="Nom Fournisseur" /> </td>
                                        
                                        <td></td>
                                        
                                        <td class="d1"> <button class="b0" name="action" placeholder="ajouterBons" class="button">Ajouter</button> </td>

                                    </div>
                                </tr>
                        </table>
                    </div>
                    
                    <table>
                        <tr>
                            <td>
                                <button class="b1" name="action" value="retourChoix" class="button">Retour</button>   
                            </td>
                            <td>
                                <button class="b1" name="action" value="deconnexion" class="button">Déconnexion</button> 
                            </td>
                        </tr>
                    </table>  
                </div>
            </form>

    </body>    
        <style type="text/css">
          
        html, body, div, span, applet, object, iframe,
        h1, h2, h3, h4, h5, h6, p, blockquote, pre,
        a, abbr, acronym, address, big, cite, code,
        del, dfn, em, img, ins, kbd, q, s, samp,
        small, strike, strong, sub, sup, tt, var,
        b, u, i, center,
        dl, dt, dd, ol, ul, li,
        fieldset, form, label, legend,
        table, caption, tbody, tfoot, thead, tr, th, td,
        article, aside, canvas, details, embed, 
        figure, figcaption, footer, header, hgroup, 
        menu, nav, output, ruby, section, summary,
        time, mark, audio, video {
        margin: 0;
        padding: 0;
        border: 0;
        font-size: 100%;
        font: inherit;
        vertical-align: baseline;
        }
        
        article, aside, details, figcaption, figure, 
        footer, header, hgroup, menu, nav, section {
            display: block;
        } 
        
        .row{
            display : flex;
            justify-content: space-around;
        } 

        h2{
          color: white;
          font-size: 50px;
          text-align: center;
        }

        body{
            background:#2980b9;
            font-family:Arial, Helvetica, sans-serif;
            font-size:20px;
        }

        .recuadro{
            width: 80%;
            margin: auto;
            background-color: white;            
            min-width: 50em;
            padding: 1em;
        }

        .contenu{            
            padding: auto;
            width: 100%;
        }

         button.b1 {
          font-family: "Roboto", sans-serif;
          text-transform: uppercase;
          background: #34495e;
          width: 100%;
          border: 0;
          padding: 1em;
          color: #FFFFFF;
          font-size: 18px;
          cursor: pointer;
        }
        button.b1:hover,.button:active,.button:focus {
          background: #e67e22;
        }
        
        button.b0 {
          font-family: "Roboto", sans-serif;
          background: #34495e;
          width: 100%;
          border: 0;
          padding: 1em;
          color: #FFFFFF;
          cursor: pointer;
        }
        
        button.b0:hover,.button:active,.button:focus {
          background: #e67e22;
        }
        
        #banner {
             margin-top: 10%;
             padding-bottom: 3%;
        }
        
        #nav {
            background-color: #FFFFFF;
            padding: auto;
        }
        
        tr.d0 {
            background-color: #EEEEEE;
        }
        
        tr.d1 {
            background-color: #FFFFFF;
        }
        
        td.d0 {
            padding: 3px;
            margin: 3px;
            width: 6em;
        }
        
        td {
            padding: 3px;
            margin: 3px;
        }
        
        th {
            padding: auto;
            min-width: 5em;
        }
        
        input {
            background-color: transparent;
            border: none transparent;
            display: table-cell;
            width: 100%;
            text-align: center;
        }
        
        input:focus {
            outline: none;
            box-shadow: 0px 0px 5px #61C5FA;
            border-bottom: 1px solid #5AB0DB;
        }

        input:hover {
            border-bottom: 1px solid #999;
            border-radius: 5px;
        }

        input:focus:hover {
            outline: none;
            box-shadow: 0px 0px 5px #61C5FA;
            border-bottom: 1px solid #5AB0DB;
            border-radius:0;
        }
        
        table {
            border: none transparent;
            width: 100%;
            min-width: 20em;
        }

        </style>
    
</html>




