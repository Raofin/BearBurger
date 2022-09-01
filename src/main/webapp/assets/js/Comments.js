$(document).ready(() => loadComments());

let foodId = getUrlParameter('foodID'); /*searchParams.get('foodID');*/
let ajaxUrl = 'post-comments?commentID=0&foodID=' + foodId;
let isReply = false;
let message = 'Your comment has been posted.';

function loadComments() {
    $.ajax({
        url: 'api/fetch-comments?foodID=' + foodId,
        method: "GET",
        success: data => {
            if (data !== '')
                $('#all-comments').html(data).show();
        }
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
    let commentHtml = '<b>Replying to </b>"' + comment + '"<b> — <i>' + reviewerName + '</i></b>';

    $('#replying-to').html(commentHtml).addClass('replying-to');
    $('#comment').focus();
    changeAjaxUrl(commentId);
}

function changeAjaxUrl(commentID = 0) {
    if (isReply) {
        ajaxUrl = 'post-comments?commentID=0&foodID=' + foodId;
        $('#submit').prop('value', 'Post');
        message = 'Your reply has been posted.';
        isReply = false;
    } else {
        ajaxUrl = 'post-comments?&commentID=' + commentID + '&foodID=' + foodId;
        $('#submit').prop('value', 'Reply');
        message = 'Your comment has been posted.';
        isReply = true;
    }
}

$('#comment-form').validate({
    submitHandler: form => {
        $.ajax({
            url: ajaxUrl,
            method: "GET",
            data: $('#comment-form').serialize(),
            cache: false,
            processData: false,
            success: data => {
                if (data === 'Success') {
                    if (isReply) {
                        $('#replying-to').removeClass('replying-to').text('');
                        changeAjaxUrl();
                    }
                    $('#comment-prompt-message').text(message).addClass('success');
                    $('#comment-form').trigger("reset");

                    loadComments();
                }
            }
        })
    },
    rules: {
        comment: {
            required: true,
            minlength: 1
        }
    },
    messages: {
        comment: {
            required: "Please enter a comment",
            minlength: "Your comment must consist of at least 1 characters",
        }
    },
    errorClass: "form-input-error error-message"
})