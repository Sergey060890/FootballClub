<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Creating a game</title>
</head>
<body>
<%@include file="/other-jsp/headerTeam.jsp" %>
<center>
<h3>NEW GAME</h3>
</center>
<jsp:useBean id="id" scope="request" type="java.lang.Integer"/>
<form method="post">
    <center>
    <br>
    <label for="start">Game start date:</label>

    <input type="date" id="start" name="date"
           value="2022-06-01"
           min="2022-06-01" max="2023-12-31"><br><br>
<%--    <input name="date" required placeholder="Enter date" style="width: 250px;"/><br><br>--%>
    <input name="opponent" placeholder="Opponent" style="width: 250px;"/><br><br>
    <input type="submit" class="gradient-button1" value="CREATE"/>
        <a class="gradient-button1" href="game?id=${id}"/>BACK</a>
    </center>
</form>

</body>
</html>

