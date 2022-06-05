<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Создание команд</title>
</head>
<body>
<%@include file="/other-jsp/headerTeam.jsp" %>
<center>
<h3>Creation of a team</h3>
</center>
<form method="post">
    <center>
    <br>
    <input name="name" required placeholder="Enter the title" style="width: 250px;"/><br><br>
    <input name="city" placeholder="Enter city" style="width: 250px;" /><br><br>
    <input name="country" placeholder="Enter country" style="width: 250px;" /><br><br>
    <input name="stadium" placeholder="Enter stadium name" style="width: 250px;" /><br><br>
    <input name="coach" placeholder="Enter the trainer's first and last name" style="width: 250px;" /><br><br>
    <input type="submit" class="gradient-button1" value="CREATE" />
        <a class="gradient-button1" href="TeamServlet" />BACK</a>
    </center>
</form>
</body>
</html>
