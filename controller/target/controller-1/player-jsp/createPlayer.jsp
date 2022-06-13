<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавление игрока</title>
</head>
<body>
<%@include file="/other-jsp/headerTeam.jsp" %>
<center>
    <h3>Adding a Player</h3>
</center>
<jsp:useBean id="id" scope="request" type="java.lang.Integer"/>
<form method="post">
    <center>
        <br>
        <label for="pos">Сhoose a position</label>
        <select name="position" id="pos" style="width: 140px;"/>
        <option value="GK">GK</option>
        <option value="FRW">FRW</option>
        <option value="RW">RW</option>
        <option value="LW">LW</option>
        <option value="CM">CM</option>
        <option value="RM">RM</option>
        <option value="LM">LM</option>
        <option value="CB">CB</option>
        <option value="LB">LB</option>
        <option value="RB">RB</option>
        </select>
        <br><br>

        <input name="name" required placeholder="Enter your name" style="width: 250px;"/><br><br>
        <input name="surname" placeholder="Enter last name" style="width: 250px;"/><br><br>
        <input name="contrary" placeholder="Enter country" style="width: 250px;"/><br><br>
        <input name="age" placeholder="Enter age" style="width: 250px;"/><br><br>
        <%--    <label for="position">Сhoose a position</label>--%>
        <%--        <select name="position" id="position">--%>
        <%--            <option value="GK">GK</option>--%>
        <%--            <option value="FRW">FRW</option>--%>
        <%--            <option value="RW">RW</option>--%>
        <%--            <option value="LW">LW</option>--%>
        <%--            <option value="CM">CM</option>--%>
        <%--            <option value="RM">RM</option>--%>
        <%--            <option value="LM">LM</option>--%>
        <%--            <option value="CD">CD</option>--%>
        <%--            <option value="LD">LD</option>--%>
        <%--            <option value="RD">RD</option>--%>
        <%--        </select>--%>
        <input type="submit" class="gradient-button1" value="ADD"/>
        <a class="gradient-button1" href="playerLineUp?id=${id}"/>BACK</a>
    </center>
</form>
</body>
</html>
