package nexttravelcompanyuser.service.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RegisterRequest {
    @NotNull(message = "User first name should not be Null")
    @NotEmpty(message = "User first name is required")
    private String firstName;
    @NotNull(message = "User Last name should not be Null")
    @NotEmpty(message = "User Last name is required")
    private String lastName;
    @NotNull(message = "user Email should not be Null")
    @NotEmpty(message = "User Email is required")
    private String email;
    @NotNull(message = "User Password should not be Null")
    @NotEmpty(message = "User Password required")
    private String password;
    @NotNull(message = "User Role should not be Null")
    @NotEmpty(message = "Booking status name is required")
    private String userRole;
}
