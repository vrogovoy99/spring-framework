package com.cydeo.proxy;

import com.cydeo.model.Comment;

public class EmailCommentNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment) {
        System.out.println(("Email notification for comment : " + comment.getText()));
    }
}
