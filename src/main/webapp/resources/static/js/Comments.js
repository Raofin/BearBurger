$(document).ready(() => loadComments());

let ajaxUrl = 'post-comments?commentID=0';
let message = 'Your comment has been posted.';
let isReply = false;

$('#comment-form').validate({
    submitHandler: form => {
        $.ajax({
            url: ajaxUrl,
            method: "GET",
            data: $('#comment-form').serialize(),
            success: data => {
                if (isReply) {
                    $('#replying-to').removeClass('replying-to').text('');
                    changeAjaxUrl();
                }
                $('#comment-prompt-message').text(message).addClass('success');
                $('#comment-form').trigger("reset");

                loadComments();
            }
        })
    },
    rules: {
        comment: {
            required: true,
            minlength: 5
        }
    },
    messages: {
        comment: {
            required: "Please enter a comment",
            minlength: "Your comment must consist of at least 5 characters",
        }
    },
    errorClass: "form-input-error error-message"
})

function loadComments() {
    $.ajax({
        url: 'api/v1/fetch-comments',
        method: "GET",
        success: data => $('#all-comments').html(data).show()
    })
}

function reply(commentId) {
    if (isReply) {
        $('#replying-to').removeClass('replying-to').text('');
        changeAjaxUrl();
        return;
    }

    let comment = $('#comment-id-' + commentId + ' #posted-comment').text();
    let reviewerName = $('#comment-id-' + commentId + ' #author-name').text();
    let commentHtml = '<b>Replying to </b>"' + comment + '"<b> <i>&#8212;&nbsp;' + reviewerName + '</i></b>';

    $('#replying-to').html(commentHtml).addClass('replying-to');
    $('#comment').focus();
    changeAjaxUrl(commentId);
}

function changeAjaxUrl(commentID = 0) {
    if (isReply) {
        $('#submit').prop('value', 'Post');
        ajaxUrl = 'post-comments?commentID=0';
        message = 'Your reply has been posted.';
        isReply = false;
    } else {
        $('#submit').prop('value', 'Reply');
        ajaxUrl = 'post-comments?&commentID=' + commentID;
        message = 'Your comment has been posted.';
        isReply = true;
    }
}