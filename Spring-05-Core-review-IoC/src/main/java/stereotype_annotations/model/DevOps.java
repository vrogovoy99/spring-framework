package stereotype_annotations.model;

import org.springframework.stereotype.Component;

@Component
public class DevOps {
    public void getTotalHours(){
        System.out.println("DevOps total hours " + 25);
    }
}
