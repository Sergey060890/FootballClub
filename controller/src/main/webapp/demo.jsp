<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 18.06.2022
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="css/stats3.css" rel="stylesheet">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
</head>
<body>
<!-- https://codepen.io/jlalovi/details/bIyAr -->
<div class="container">
    <!-- DONUT CHART BLOCK (LEFT-CONTAINER) -->
    <div class="donut-chart-block block">
        <h2 class="titular">OS AUDIENCE STATS</h2>
        <div class="donut-chart">
            <!-- PORCIONES GRAFICO CIRCULAR
                 ELIMINADO #donut-chart
                 MODIFICADO CSS de .donut-chart -->
            <div id="porcion1" class="recorte"><div class="quesito ios" data-rel="0"></div></div>
            <div id="porcion2" class="recorte"><div class="quesito mac" data-rel="0"></div></div>
            <div id="porcion3" class="recorte"><div class="quesito win" data-rel="0"></div></div>
            <div id="porcionFin" class="recorte"><div class="quesito linux" data-rel="100"></div></div>
            <!-- FIN AÑADIDO GRÄFICO -->
            <p class="center-date">JUNE<br><span class="scnd-font-color">2013</span></p>
        </div>
        <ul class="os-percentages horizontal-list">
            <li>
                <p class="ios os scnd-font-color">iOS</p>
                <p class="os-percentage">0<sup>%</sup></p>
            </li>
            <li>
                <p class="mac os scnd-font-color">Mac</p>
                <p class="os-percentage">0<sup>%</sup></p>
            </li>
            <li>
                <p class="linux os scnd-font-color">Linux</p>
                <p class="os-percentage">0<sup>%</sup></p>
            </li>
            <li>
                <p class="win os scnd-font-color">Win</p>
                <p class="os-percentage">100<sup>%</sup></p>
            </li>
        </ul>
    </div>

</div>

<p class='nota-final'>Este pen es sólo para que <strong>@jlalovi</strong> complemente con los gráficos <a href='https://codepen.io/jlalovi/details/bIyAr'>el suyo</a>.</p>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
