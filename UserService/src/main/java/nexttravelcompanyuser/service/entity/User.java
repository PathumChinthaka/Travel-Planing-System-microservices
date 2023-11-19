package nexttravelcompanyuser.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    private String userId;
    private String userName;
    private String userPassword;
    private String userContactNo;
    private String userNic;
    private int userAge;
    private String gender;
    private String address;
    private String remarks;
    private String userImage;
    private String userNicImage;
}
