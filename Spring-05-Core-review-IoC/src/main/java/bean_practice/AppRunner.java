package bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRunner {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

        FullTimeEmployee ft = container.getBean(FullTimeEmployee.class);
        PartTimeEmployee pt =container.getBean(PartTimeEmployee.class);

        ft.createAccount();
        pt.createAccount();
    }
}

