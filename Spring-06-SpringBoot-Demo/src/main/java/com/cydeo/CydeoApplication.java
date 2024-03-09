package com.cydeo;

import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class CydeoApplication {

    public static void main(String[] args) {

//      from Spring-04 being replaced by SpringApplication
//        ApplicationContext context= new AnnotationConfigApplicationContext(ProjectConfig.class);
        ApplicationContext context = SpringApplication.run(CydeoApplication.class, args);

        Comment comment = new Comment();
        comment.setAuthor("Davis");
        comment.setText("Spring explained");

        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }

}
