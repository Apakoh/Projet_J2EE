<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Edition données personnelles</title>
    </head>
    <body>
        <form method="GET">
            <div class="recuadro">
                <div class="contenu">
                    <div id="banner"> Mon Profil </div>
                    <table>
                        <tr>
                            <td>
                                <div id="nav">
                                    <table>
                                        <tr class="d0">
                                            <td> Nom : </td>
                                            <td> <input size="35%" size="30" name="nom" type="text" value="${client.getNom()}" /> </td>
                                        </tr>
                                        <tr class="d1">
                                            <td> Adresse : </td>
                                            <td> <input size="35%" name="adresse" type="text" value="${client.getAdresseLine1()}" /> </td>
                                        </tr>
                                        <tr class="d0">
                                            <td> Ville : </td>
                                            <td> <input size="35%" name="ville" type="text" value="${client.getCity()}" /> </td>
                                        </tr>
                                        <tr class="d1">
                                            <td> Etat : </td>
                                            <td> <input size="35%" name="etat" type="text" value="${client.getState()}" /> </td>
                                        </tr>
                                        <tr class="d0">
                                            <td> Téléphone : </td>
                                            <td> <input size="35%" name="telephone" type="text" value="${client.getTelephone()}" /> </td>
                                        </tr>
                                        <tr class="d1">
                                            <td> Fax : </td>
                                            <td> <input size="35%" name="fax" type="fax" value="${client.getFax()}" /> </td>
                                        </tr>
                                        <tr class="d0">
                                            <td> Email : </td>
                                            <td> <input size="35%" name="email" type="email" value="${client.getEmail()}" /> </td>
                                        </tr>
                                    </table>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>             
            <button name="action" value="modifierProfil" class="button">Modifier</button>
            <button name="action" value="retourChoix" class="button">Retour</button>            
            <button name="action" style="width:170px" value="deconnexion" class="button">Déconnexion</button>
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
            width: 50%;
            height: 30%;
            margin-top: 10%;
            margin-left: 25%;
            background-color: white;
            border-radius: 40px;
            padding-bottom: 5%;
        }

        .contenu{
            padding-left: 25%;
            padding-top: 10%;
            width: 100%;
        }

         .button {
          font-family: "Roboto", sans-serif;
          text-transform: uppercase;
          background: #34495e;
          width: 100%;
          border: 0;
          padding: 15px;
          color: #FFFFFF;
          font-size: 18px;
          cursor: pointer;
          margin-top: 60px;
          margin-left: 46%;
          width: 115px;
        }
        .button:hover,.button:active,.button:focus {
          background: #e67e22;
        }
        
        #banner {
             margin-left: 15%;
        }
        
        #nav {
            background-color: #FFFFFF;
            align-content: center;
        }
        
        tr.d0 {
            background-color: #EEEEEE;
        }
        
        tr.d1 {
            background-color: #FFFFFF;
        }
        
        td {
            padding: 3px;
            margin: 3px;
        }
        
        input {
            background-color: transparent;
            border: none transparent;            
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
        }

        </style>
</html>
