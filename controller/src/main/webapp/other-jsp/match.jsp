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
<div id="current_date_time_block"></div>

<script type="text/javascript">

    /* функция добавления ведущих нулей */
    /* (если число меньше десяти, перед числом добавляем ноль) */
    function zero_first_format(value)
    {
        if (value < 10)
        {
            value='0'+value;
        }
        return value;
    }

    /* функция получения текущей даты и времени */
    function date_time()
    {
        var current_datetime = new Date();
        var day = zero_first_format(current_datetime.getDate());
        var month = zero_first_format(current_datetime.getMonth()+1);
        var year = current_datetime.getFullYear();
        // var hours = zero_first_format(current_datetime.getHours());
        // var minutes = zero_first_format(current_datetime.getMinutes());
        // var seconds = zero_first_format(current_datetime.getSeconds());

        return "DATE GAME: " + day + "." + month + "." + year;
    }

    /* выводим текущую дату и время на сайт в блок с id "current_date_time_block" */
    document.getElementById('current_date_time_block').innerHTML = date_time();
</script>
<head>
    <title></title>
    <meta http-equiv="content-type" content="text/html; charset=windows-1251"/>
    <link rel="stylesheet" type="text/css" href="#" media="#"/>
    <script type="text/javascript">
        function randomImg() {
            var imgAr = ['<img src="other-jsp/image/rain_weather_icon_151998.png" alt="Rain" />',
                '<img src="other-jsp/image/sunny_sunshine_weather_2778.png" alt="Sunny" />',
                '<img src="other-jsp/image/sunny_weather_icon_150663.png" alt="Cloudy" />'];
            var rnd = Math.floor(Math.random() * imgAr.length);
            var rndImg = imgAr[rnd];
            var imgTag = document.getElementById('img');
            imgTag.innerHTML = rndImg;
        }

        window.onload = randomImg;
    </script>

<body>
<%@include file="/other-jsp/headerTeam.jsp" %>
<center>
    <table border="3" width="50%">

        <caption><b>MATCH</b></caption>
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
        </tr>

        <jsp:useBean id="id" scope="request" type="java.lang.Integer"/>
        <jsp:useBean id="game" scope="request" type="footballclub.entity.Game"/>

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


        </tr>

    </table>
    <a class="gradient-button1" href='<c:url  value="startLineup?id=${game.game_id} " />'>START THE GAME!</a>
    <a class="gradient-button1" href='<c:url value="game?id=${game.teamGame.team_id}" />'>BACK</a>
</center>
</body>
</html>