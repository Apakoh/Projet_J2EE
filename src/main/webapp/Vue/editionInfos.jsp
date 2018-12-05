<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Edition données personnelles</title>
    </head>
    <body>

            <h2>Mon profil</h2>

            <div class="recuadro">
                <div class="contenu">
                    <table border="1">
                            <tbody>                     
                                    <tr>
                                        Nom :
                                        <br>
                                        Adresse :
                                        <br>
                                        Ville :
                                        <br>
                                        Etat :
                                        <br>
                                        Téléphone :
                                        <br>
                                        Fax :
                                        <br>
                                        Email :
                                        <br>
                                    </tr>
                            </tbody>
                    </table>
                </div>
                        </div>
                <button class="button">Modifier</button>
    </body>

      <style type="text/css">

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
            width: 30%;
            height: 30%;
            margin: auto;
            background-color: white;
            border-radius: 40px;
            padding-bottom: 20px;
        }

        .contenu{
            width: 50%;
            padding-left: 70px;
            padding-top: 20px;
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

        </style>
</html>
