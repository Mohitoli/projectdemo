package student.com.example.StudentERP.Helper;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class HelperMessage {
    private String content;
    private String type;

    public HelperMessage(String content,String type){
        this.content=content;
        this.type=type;

    }

}
