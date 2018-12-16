<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Choix de l'action</title>
    </head>
    <body>
            
            <form method="POST">
                <div class="boutonI">
                   <input type="submit" id="submit" name="action" value="Accéder à mes infos personnelles">
                </div><!--boutonI-->

                <div class="boutonC">
                   <input type="submit" id="submit" name="action" value="Accéder à mes bons de commandes">
                </div><!--boutonC-->
                
                <div class="boutonD">
                    <button name="action" value="deconnexion" class="deconnexion"> Déconnexion </button>
                </div>
            </form>   
    </body>
    
  <style type="text/css">

        body{
            background:#2980b9;
            font-family:Arial, Helvetica, sans-serif;
            font-size:20px;
        }

        .boutonI{
            width: 250px;
            margin : auto;
            margin-top: 10%;
            padding-bottom: 10%;
            left: 50%;
            top: 50%;

        }

        .boutonC{
            width: 250px;
            margin : auto;
            margin-bottom: 10%;
            left: 50%;
            top: 50%;
        }
        
        .boutonD{
            width: 250px;
            margin : auto;
            margin-bottom: 10%;
            left: 50%;
            top: 50%;
        }

        .boutonI input{
            padding:7px 0 7px 0;
            font:bold 18px Arial;
            background:#34495e;
            color:white;
            width:330px;
            height: 150px;
            border:none;
            cursor: pointer;

        }

        .boutonC input{
            padding:7px 0 7px 0;
            font:bold 18px Arial;
            background:#34495e;
            color:white;
            width:330px;
            height: 150px;
            border:none;
            cursor: pointer;

        }
        
        .boutonI input:hover{
          background: #e67e22;
        }

        .boutonC input:hover{
          background: #e67e22;
        }
        
        .deconnexion{
            font:bold 18px Arial;
            background:#e67e22;
            color:white;
            width:300px;
            height: 60px;
            border:none;
            cursor: pointer;
            border-radius: 10px;
            margin-left: 20px;
        }



    </style>
</html>
