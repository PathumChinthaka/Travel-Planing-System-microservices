package nexttravelcompanyuser.service.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    @NotNull(message = "user Id should not be Null")
    @NotEmpty(message = "User Id is required")
    private String userId;
    @NotNull(message = "user Name should not be Null")
    @NotEmpty(message = "User Name is required")
    private String userName;
    @NotNull(message = "user Password should not be Null")
    @NotEmpty(message = "User Password is required")
    private String userPassword;
    @NotNull(message = "user Contact no should not be Null")
    @NotEmpty(message = "User Contact is required")
    private String userContactNo;
    @NotNull(message = "user Nic should not be Null")
    @NotEmpty(message = "User Nic is required")
    private String userNic;
    @NotEmpty(message = "User Age is required")
    @Min(18)
    @Max(80)
    private int userAge;
    @NotNull(message = "user Gender should not be Null")
    @NotEmpty(message = "User Gender is required")
    private String gender;
    @NotNull(message = "user Email should not be Null")
    @NotEmpty(message = "User Email is required")
    private String address;
    @NotNull(message = "user Address should not be Null")
    @NotEmpty(message = "User Address is required")
    private String remarks;
    private String userImage;
    private String userNicImage;
}
