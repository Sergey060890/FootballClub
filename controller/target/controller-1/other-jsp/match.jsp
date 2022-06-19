<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 27.05.2022
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Set" %>
<%@ page import="footballclub.entity.Player" %>
<%@ page import="footballclub.entity.Game" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<link href="css/woow.css" rel="stylesheet">
<link href="css/button-info.css" rel="stylesheet">
<%--<div id="current_date_time_block"></div>--%>

<%--<script type="text/javascript">--%>

<%--    /* функция добавления ведущих нулей */--%>
<%--    /* (если число меньше десяти, перед числом добавляем ноль) */--%>
<%--    function zero_first_format(value)--%>
<%--    {--%>
<%--        if (value < 10)--%>
<%--        {--%>
<%--            value='0'+value;--%>
<%--        }--%>
<%--        return value;--%>
<%--    }--%>

<%--    /* функция получения текущей даты и времени */--%>
<%--    function date_time()--%>
<%--    {--%>
<%--        var current_datetime = new Date();--%>
<%--        var day = zero_first_format(current_datetime.getDate());--%>
<%--        var month = zero_first_format(current_datetime.getMonth()+1);--%>
<%--        var year = current_datetime.getFullYear();--%>
<%--        // var hours = zero_first_format(current_datetime.getHours());--%>
<%--        // var minutes = zero_first_format(current_datetime.getMinutes());--%>
<%--        // var seconds = zero_first_format(current_datetime.getSeconds());--%>

<%--        return "DATE GAME: " + day + "." + month + "." + year;--%>
<%--    }--%>

<%--    /* выводим текущую дату и время на сайт в блок с id "current_date_time_block" */--%>
<%--    document.getElementById('current_date_time_block').innerHTML = date_time();--%>
<%--</script>--%>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
    <title></title>
    <meta http-equiv="content-type" content="text/html; charset=windows-1251"/>
    <link rel="stylesheet" type="text/css" href="#" media="#"/>
    <script type="text/javascript">
        function randomImg() {
            var imgAr = ['<img src="images/rain_weather_icon_151998.png" alt="Rain" />',
                '<img src="images/sunny_sunshine_weather_2778.png" alt="Sunny" />',
                '<img src="images/sunny_weather_icon_150663.png" alt="Cloudy" />'];
            var rnd = Math.floor(Math.random() * imgAr.length);
            var rndImg = imgAr[rnd];
            var imgTag = document.getElementById('img');
            imgTag.innerHTML = rndImg;
        }

        window.onload = randomImg;
    </script>

<body>
<%@include file="/other-jsp/headerTeam.jsp" %>
<header class="page-header">
    <main>
        <article id="hero-1" style="--i: 5">
            <div class="hero-info">
                <table border="3" width="50%">

                    <%--                    <caption><b>MATCH</b></caption>--%>
                    <tr>

                        <th>
                            <center>Teams</center>
                        </th>
                        <th>
                            <center>Stadium</center>
                        </th>

                        <th>
                            <center>Weather</center>
                        </th>

                        <th>
                            <center>Attendance</center>
                        </th>

                        <th>
                            <center>Referee</center>
                        </th>
                    </tr>

                    <jsp:useBean id="id" scope="request" type="java.lang.Integer"/>
                    <jsp:useBean id="attendance" scope="request" type="java.lang.Integer"/>
                    <jsp:useBean id="referee" scope="request" type="java.lang.String"/>
                    <jsp:useBean id="game" scope="request" type="footballclub.entity.Result"/>

                    <tr>

                        <td>
                            <center>${game.teamGame.team_name} VS ${game.opponent_name}</center>
                        </td>

                        <td>
                            <center>${game.teamGame.stadium}</center>
                        </td>

                        <td>
                            <center>
                                <div id="img"></div>
                            </center>
                        </td>

                        <td>
                            ${attendance}
                        </td>

                        <td>
                            ${referee}
                        </td>


                    </tr>

                </table>
                <a class="btn btn-success" href='<c:url  value="startLineup?id=${game.id} " />'>START THE
                    GAME!</a>
                <a class="btn btn-primary"
                   href='<c:url value="game?id=${game.teamGame.team_id}" />'>BACK</a>
            </div>
            <div class="hero-image hi-3"></div>
        </article>

    </main>

</header>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>