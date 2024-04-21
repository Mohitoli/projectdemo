package Form.com.example.Form.Entities;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserEntity {
    @NotBlank(message = "Username cannot be empty")

    private String username;
    @NotBlank(message = "Email cannot be empty")
    private String email;
    @AssertTrue(message ="Check the agreement")
    private boolean agreed;
    public UserEntity(){
    }

}
