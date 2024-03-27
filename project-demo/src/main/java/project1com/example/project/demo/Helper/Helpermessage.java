package project1com.example.project.demo.Helper;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data

public class Helpermessage {
    private String content;
    private String type;

    public Helpermessage(String content, String type) {
        this.content=content;
        this.type=type;
    }


}
