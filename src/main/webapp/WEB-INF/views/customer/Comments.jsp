<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<c:import url="/templates/CustomerHeader.jsp"/>

<div class="comment-container">
    <form method="POST" id="comment-form">
        <div>
            <h1 id="title"><?php echo $_SESSION['foodTitle'] ?></h1>
            <p id="description"><?php echo $_SESSION['foodDescription'] ?></p>
            <p id="food-id" hidden><?php echo $_REQUEST['id'] ?></p>
        </div>

        <div class="comment-box">
            <h2>Comments</h2>
            <div id="all-comments" hidden></div>
            <div>
                <div id="replying-to"></div>
                <textarea autofocus class="review-input" id="comment" name="comment"
                          placeholder="Enter your comment here..." rows="3"></textarea>
                <div id="comment-prompt-message"></div>
                <input class="button" id="submit" name="submit" type="submit" value="POST">
            </div>
        </div>
    </form>
</div>

<script src="<c:url value="/assets/js/UrlParameter.js"/>"></script>
<script src="<c:url value="/assets/js/Comments.js"/>"></script>
<c:import url="/templates/Footer.jsp"/>