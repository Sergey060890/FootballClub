<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<link href="css/woow.css" rel="stylesheet">
<link href="css/button-info.css" rel="stylesheet">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
<body>
<%@include file="/other-jsp/headerTeam.jsp" %>
<center>
<h2>Please select starting lineup!</h2>
</center>
<jsp:useBean id="id" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="game" scope="request" type="footballclub.entity.Result"/>
<jsp:useBean id="players" scope="request" type="java.util.Set"/>
<center>
<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
    INFO!
</button>
</center>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                    <h3 class="modal-title" id="exampleModalLabel">Attention!</h3>
                    <%--                                <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">--%>
                    <%--                                    <span aria-hidden="true">&times;</span>--%>
                <%--                                </button>--%>
            </div>
            <div class="modal-body">
                <p>- In the starting line-up you need to choose 11 players!</p>
                <p>- Don't forget to choose a goalkeeper!</p>
                <p>- There can be no more than 1 goalkeeper in the starting line-up</p>
                <p></p>
                <p>* If these conditions are not met, you will be returned to the composition selection page!</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">OK</button>
            </div>
        </div>
    </div>
</div>
<header class="page-header">
    <main>
        <article id="hero-1" style="--i: 5">
            <div class="hero-info">
                <form method="post">
                    <center>

                        <input type="hidden" value="${game.id}" name="id"/>
                        <c:forEach var="player" items="${players}">
                            <input type="checkbox"  name="player"  style=" position: center "
                                   value=${player.player_surname} checked/> ${player.player_surname} ${player.position}
                            <br>
                        </c:forEach>
                        <input type="submit" class="gradient-button1" value="GO!"/>
                        <a class="gradient-button1" href="match?id=${id}"/>BACK</a>
                    </center>
                </form>
            </div>
            <div class="hero-image hi-2"></div>
        </article>

    </main>

</header>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
