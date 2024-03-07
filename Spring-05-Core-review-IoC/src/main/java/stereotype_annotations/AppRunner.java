package stereotype_annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import stereotype_annotations.config.AppConfig;
import stereotype_annotations.model.DataStructure;
import stereotype_annotations.model.DevOps;

public class AppRunner {

    public static void main(String[] args) {


        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        DataStructure dataStructure = container.getBean(DataStructure.class);
        dataStructure.getTotalHours();

        DevOps devOps = container.getBean(DevOps.class);
        devOps.getTotalHours();

    }
}
