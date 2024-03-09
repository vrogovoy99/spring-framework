package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    @Value("${commentAuthor}")
    private String author;
    @Value("${daysArray}")
    private String[] daysArray;
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;
    private final CommentNotificationProxy commentNotificationProxy2;


    public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy, @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy2) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy2 = commentNotificationProxy2;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment){
        comment.setText(author);
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
        commentNotificationProxy2.sendComment(comment);
        System.out.println("Print days array second item " + daysArray[1].toString());
    }
}
