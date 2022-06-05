<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
<%--        var month = zero_first_format(current_datetime.getMonth() + 1);--%>
<%--        var year = current_datetime.getFullYear();--%>
<%--        var hours = zero_first_format(current_datetime.getHours());--%>
<%--        var minutes = zero_first_format(current_datetime.getMinutes());--%>
<%--        var seconds = zero_first_format(current_datetime.getSeconds());--%>

<%--        return "DATE:" + day + "." + month + "." + year + " TIME:" + hours + ":" + minutes + ":" + seconds;--%>
<%--    }--%>
<%--</script>--%>

<%--<div id="current_date_time_block2"></div>--%>

<%--<script type="text/javascript">--%>

<%--    /* каждую секунду получаем текущую дату и время */--%>
<%--    /* и вставляем значение в блок с id "current_date_time_block2" */--%>
<%--    setInterval(function () {--%>
<%--        document.getElementById('current_date_time_block2').innerHTML = date_time();--%>
<%--    }, 1000);--%>
<%--</script>--%>
<head>

    <title>Главная Страница</title>
</head>
<body style="background: url(image/pexelsphoto1594932.jpeg)">

<%@include file="headerTeam.jsp" %>

<center>
    <h2>FOOTBALL CLUB</h2>
    <a class="gradient-button1" href="TeamServlet">MY TEAM</a>
</center>
</body>
</html>

