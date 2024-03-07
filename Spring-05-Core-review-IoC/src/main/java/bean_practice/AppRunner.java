package bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRunner {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class, AppConfig2.class);

        FullTimeEmployee ft = container.getBean(FullTimeEmployee.class);
        PartTimeEmployee pt =container.getBean(PartTimeEmployee.class);
        String st1 = container.getBean("PrimeBean", String.class);
        String st2 = container.getBean("AltBean", String.class);

        ft.createAccount();
        pt.createAccount();

        System.out.println("Prime bean : " + st1 + "\nAlt bean " + st2);
    }
}

