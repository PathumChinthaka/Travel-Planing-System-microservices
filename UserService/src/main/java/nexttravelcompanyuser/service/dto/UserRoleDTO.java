package nexttravelcompanyuser.service.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRoleDTO {
    @NotEmpty(message = "User Role Id is required")
    private int userRoleId;
    @NotEmpty(message = "User Role Name is required")
    private String userRoleName;
}
