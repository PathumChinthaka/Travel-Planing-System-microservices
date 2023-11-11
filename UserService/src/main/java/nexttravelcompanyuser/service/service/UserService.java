package nexttravelcompanyuser.service.service;

import nexttravelcompanyuser.service.dto.UserDTO;
import nexttravelcompanyuser.service.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    UserDTO getUser(String userName);
    List<User> getAllUsers();
    void updateUsers(UserDTO userDTO);
    void deleteUser(String userId);
    String getLastUserId();
}
