<%@ page import="footballclub.entity.Team" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="footballclub.entity.Player" %>
<%@ page import="footballclub.entity.Game" %>
<%@ page import="servlet.teamServlet.TeamServlet" %>
<%@ page import="servlet.teamServlet.SelectionTeamServlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: Сергей Медвецкий
  Date: 25.05.2022
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
<body>

<%@include file="/other-jsp/header.jsp" %>
<center>
    <h2>My team information</h2>
    <table border="3" width="50%">
        <%--        <caption><b>My club info</b></caption>--%>
        <tr>
            <th>NAME</th>
            <th>CITY</th>
            <th>COUNTRY</th>
            <th>STADIUM</th>
            <th>COACH</th>
        </tr>

        <jsp:useBean id="id" scope="request" type="java.lang.Integer"/>
        <jsp:useBean id="name" scope="request" type="java.lang.String"/>
        <jsp:useBean id="city" scope="request" type="java.lang.String"/>
        <jsp:useBean id="country" scope="request" type="java.lang.String"/>
        <jsp:useBean id="stadium" scope="request" type="java.lang.String"/>
        <jsp:useBean id="coach" scope="request" type="java.lang.String"/>

        <tr>
            <td>
                ${name}
            </td>

            <td>
                ${city}
            </td>

            <td>
                ${country}
            </td>

            <td>
                ${stadium}
            </td>

            <td>
                ${coach}
            </td>
        </tr>

    </table>
    <a class="gradient-button1" href='<c:url value="edit?id=${id}" />'>EDIT TEAM</a>
    <button type="button" class="gradient-button1" data-bs-toggle="modal" data-bs-target="#exampleModal">
        DELETE
    </button>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <center>
                        <h3 class="modal-title" id="exampleModalLabel">Attention!</h3>
                        <%--                                <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">--%>
                        <%--                                    <span aria-hidden="true">&times;</span>--%>
                    </center>
                    <%--                                </button>--%>
                </div>
                <div class="modal-body">
                    When a team is deleted, all its players, games and statistics will be lost!
                </div>
                <div class="modal-footer">
                    <a href='<c:url value="delete?id=${id}" />' class="btn btn-primary">DELETE</a>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">CANCEL</button>
                </div>
            </div>
        </div>
    </div>

    <%--    <a class="gradient-button1" href='<c:url value="playerLineUp?id=${id}" />'>Team line-up</a>--%>
    <%--    <a class="gradient-button1" href="TeamServlet">Team statistics</a>--%>
    <a class="gradient-button1" href="TeamServlet">BACK</a>
</center>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>
