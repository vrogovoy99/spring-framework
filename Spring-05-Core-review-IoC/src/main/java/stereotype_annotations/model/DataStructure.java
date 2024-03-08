package stereotype_annotations.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
@Data
public class DataStructure {

    @NonNull
    ExtraHours extraHours;
    public void getTotalHours(){
        System.out.println("Total DataStructure hours " + (20 + extraHours.getExtraHours()));
    }
}
