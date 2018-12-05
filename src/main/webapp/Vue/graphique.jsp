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
      
      
     <div id = "container" style = "width: 550px; height: 400px; margin-left: 80px;"></div>
     <div id="piechart" style="width: 900px; height: 500px;margin-left: 50%;margin-top: -30%;"></div>
     <div id = "container2" style = "width: 550px; height: 400px; margin-left: 30%;"></div>


   </body>
</html>