<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
            <br><link rel="stylesheet" type="text/css" href="CSS/style.css" />
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Login</title>
    </head>
    <body>

              <h1>Mini projet JEE</h1>
              <div class="login-page">
                  <div class="form">
                    <form class="login-form" method="POST">                        
                      <input name="identifiant" type="text" placeholder="Nom d'utilisateur"/>
                      <input name="motDePasse" type="password" placeholder="Mot de passe"/>
                      <button type="submit" name="action" value="login">login</button>
                    </form>
                  </div>
                </div>
    </body>
    
    <style type="text/css">

        h1{
          color: white;
          font-size: 68px;

          text-align: center;
        }
        .login-page {
          width: 360px;
          padding: 3% 0 0;
          margin: auto;
        }
        .form {
          position: relative;
          background: #FFFFFF;
          max-width: 360px;
          margin: 0 auto 100px;
          padding: 45px;
          text-align: center;
          box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
        }
        .form input {
          font-family: "Roboto", sans-serif;
          background: #f2f2f2;
          width: 100%;
          border: 0;
          margin: 0 0 15px;
          padding: 15px;
          box-sizing: border-box;
          font-size: 14px;
        }
        .form button {
          font-family: "Roboto", sans-serif;
          text-transform: uppercase;
          outline: 0;
          background: #34495e;
          width: 100%;
          border: 0;
          padding: 15px;
          color: #FFFFFF;
          font-size: 14px;
          cursor: pointer;
        }
        .form button:hover,.form button:active,.form button:focus {
          background: #e67e22;
        } 
        body {
          background: #2980b9; 
        }

    </style>
</html>
