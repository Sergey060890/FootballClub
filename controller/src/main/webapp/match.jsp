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
<%@ page isELIgnored = "false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <title></title>
    <meta http-equiv="content-type" content="text/html; charset=windows-1251" />
    <link rel="stylesheet" type="text/css" href="#" media="#" />
    <script type="text/javascript">
        function randomImg(){
            var imgAr = ['<img src="image/rain_weather_icon_151998.png" alt="Rain" />',
                '<img src="image/sunny_sunshine_weather_2778.png" alt="Sunny" />',
                '<img src="image/sunny_weather_icon_150663.png" alt="Cloudy" />'];
            var rnd = Math.floor(Math.random()*imgAr.length);
            var rndImg = imgAr[rnd];
            var imgTag = document.getElementById('img');
            imgTag.innerHTML = rndImg;}
        window.onload = randomImg;
    </script>

<body style="padding:50px;">
<%@include file="headerTeam.jsp" %>
<center>
    <table border="3" width="50%">

        <caption><b>MATCH</b></caption>
        <tr>
            <th>Date</th>

            <th><center>Teams</center></th>
            <th><center>Weather</center></th>
            <th><center>Line-up</center></th>
        </tr>

        <jsp:useBean id="id" scope="request" type="java.lang.Integer"/>
        <jsp:useBean id="game" scope="request" type="footballclub.entity.Game"/>

            <tr>

                <td>
                        ${game.game_date}
                </td>

                <td>
                    <center>${game.teamGame.team_name} VS ${game.opponent_name}</center>
                </td>

                <td>
                <center><div id="img"></div></center>
                </td>

                <td>
                    <a class="gradient-button"  href='<c:url  value="startLineup?id=${game.game_id} " />'>Select Line-up</a>
                </td>


            </tr>

    </table>

                <a class="gradient-button1" href='<c:url value="createPlayer?id=${game.game_id}" />'>START THE GAME!</a>
                <a class="gradient-button1" href='<c:url value="game?id=${game.getTeamGame().getTeam_id()}" />'>BACK</a>
    </center>
</body>
</html>