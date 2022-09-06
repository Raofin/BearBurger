<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<c:import url="/resources/templates/CustomerHeader.jsp"/>

<div class="comment-container">
    <form:form method="POST" id="comment-form" modelAttribute="food">
        <div>
            <h1 id="title">${food.title}</h1>
            <p id="description">${food.description}</p>
        </div>
        <div class="comment-box">
            <h2><label for="comment">Comments</label></h2>
            <div id="all-comments" hidden></div>
            <div>
                <div id="replying-to"></div>
                <textarea autofocus class="review-input" id="comment" name="comment"
                          placeholder="Enter your comment here..." rows="3"></textarea>
                <div id="comment-prompt-message">
                    <%
                        if (request.getParameter("error") != null) {
                            out.print("<p class=\"error-message\">Please fill out the comment field properly</p>");
                        }
                    %>
                </div>
                <input class="button" id="submit" name="submit" type="submit" value="POST">
            </div>
        </div>
    </form:form>
</div>

<script src="<c:url value="/resources/static/js/Comments.js"/>"></script>
<c:import url="/resources/templates/Footer.jsp"/>