package com.cydeo;

import com.cydeo.config.ProjectConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {
        Comment comment = new Comment();
        comment.setAuthor("Davis");
        comment.setText("Spring explained");

        ApplicationContext context= new AnnotationConfigApplicationContext(ProjectConfig.class);

        System.out.println("-------------------------------\n\n");

        CommentService cs1 = context.getBean(CommentService.class);

        cs1.setIdentifier("First");

        CommentService cs2 = context.getBean(CommentService.class);

//        cs2.setIdentifier("Second");

        System.out.println("Bean 1 identifier >>> " + cs1.getIdentifier());
        System.out.println("Bean 2 identifier >>> " + cs2.getIdentifier());

        if (cs1 == cs2)
            System.out.println("Objects are identical - Singleton. add @Scope(\"prototype\") in bean definition to change bean scope");
        else
            System.out.println("Objects are different - Prototype");


    }
}
