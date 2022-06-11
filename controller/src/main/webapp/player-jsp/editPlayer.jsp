<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="/other-jsp/headerTeam.jsp" %>
<center>
<h3>Player editing</h3>
</center>
    <jsp:useBean id="player" scope="request" type="footballclub.entity.Player"/>
<form method="post">
    <center>
    <input type="hidden" value="${id}" name="id" />

    <label>Name</label><br>
    <label>
        <input name="name" value="${name}"  required/>
    </label><br><br>

    <label>Surname</label><br>
    <label>
        <input name="surname" value="${surname}"  required/>
    </label><br><br>

    <label>Country </label><br>
    <input name="country" value="${country}" /><br><br>

    <label>Age </label><br>
    <input name="age" value="${age}" /><br><br>

    <label>Position </label><br>
        <select name="position" id="pos" style="width: 172px;"/>
        <option>${position}</option>
        <option>GK</option>
        <option>FRW</option>
        <option>RW</option>
        <option>LW</option>
        <option>CM</option>
        <option>RM</option>
        <option>LM</option>
        <option>CB</option>
        <option>LB</option>
        <option>RB</option>
        </select> <br><br>

    <input type="submit" class="gradient-button1" value="SAVE" />
        <a class="gradient-button1" href="playerLineUp?id=${player.teamPlayer.team_id}" />BACK</a>
    </center>
</form>

</body>
</html>