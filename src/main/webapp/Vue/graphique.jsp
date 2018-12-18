<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
   <head>
      <title>Graphiques</title>
      <script type = "text/javascript" src = "https://www.gstatic.com/charts/loader.js"></script>
      <script type = "text/javascript">google.charts.load('current', {packages: ['corechart']});</script>
   </head>
   
   <body>
       
      <h2>Statistiques</h2>
      
      <script language = "JavaScript">
         function drawChart1() {
            // Données du graphique
            var data = google.visualization.arrayToDataTable([
               ['Year', 'Chiffre d\'affaire par article'],
               ['TV',  900],
               ['Cable',  1000],
               ['Computer',  1170],
               ['Card',  1250],
               ['Screen',  1530]
            ]);

            var options = {title: 'Chiffre d\'affaire (en ...€)'}; 

            // Forñe du graphique
            var chart = new google.visualization.ColumnChart(document.getElementById('container'));
            chart.draw(data, options);
         }
         
         function drawChart2() {

            var data = google.visualization.arrayToDataTable([
              ['Etat', 'CA'],
              ['CA',11],
              ['TX',2],
              ['FL',2],
              ['MI',2],
              ['NY',7]
            ]);

            var options = { title: 'Chiffre d\'affaire par zone géographique'};

            var chart = new google.visualization.PieChart(document.getElementById('piechart'));
            chart.draw(data, options);
        }
        
        function drawChart3() {
            var data = google.visualization.arrayToDataTable([
               ['Montant', 'Chiffre d\'affaire par client'],
               ['Anass',900],
               ['Quentin',1000],
               ['Jean',1170],
               ['Louis',1250],
               ['Albert',1500]
            ]);

            var options = {title: 'Chiffre d\'affaire (en ...€)'}; 

            var chart = new google.visualization.ColumnChart(document.getElementById('container2'));
            chart.draw(data, options);
         }

             google.charts.setOnLoadCallback(drawChart1);
             google.charts.setOnLoadCallback(drawChart2);
             google.charts.setOnLoadCallback(drawChart3);

      </script>
      
      
     <div class="header">
         <h4>Choix de la période : <input id="date" type="date" value="2011-01-01"> - <input id="date" type="date" value="2012-01-01"></h4>
     </div>
     <div id = "container" style = "width: 550px; height: 400px; margin-left: 80px;"></div>
     <div id="piechart" style="width: 700px; height: 500px;margin-left: 53%;margin-top: -28%;"></div>
     <div id = "container2" style = "width: 550px; height: 400px; margin-left: 7%;"></div>
     <div>
         <button name="action" value="deconnexion" class="edition">Consulter mes produits</button>
     </div>
     <div>
         <button name="action" value="deconnexion" class="deconnexion">Déconnexion</button>
     </div>
     


   </body>
   
   <style type="text/css">

   h2{
          color: black;
          font-size: 50px;
          text-align: center;
        }
        
        .header{
            width: 100%;
            text-align: center;
        }  
        
        
    .edition{
            font:bold 20px Arial;
            background: #34495e;
            color: white;
            width: 300px;
            height: 115px;
            border: none;
            cursor: pointer;
            border-radius: 10px;
            margin-left: 63%;
            margin-top: -27%;
        }
        
     .edition:hover{
          background: #e67e22;
        }
        
     .deconnexion{
            font:bold 20px Arial;
            background: #34495e;
            color: white;
            width: 300px;
            height: 115px;
            border: none;
            cursor: pointer;
            border-radius: 10px;
            margin-left: 63%;
            margin-top: -15%;
        }
        
     .deconnexion:hover{
          background: #e67e22;
        }
    </style>
</html>
