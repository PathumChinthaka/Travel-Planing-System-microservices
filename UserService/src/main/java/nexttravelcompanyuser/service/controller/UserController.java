package nexttravelcompanyuser.service.controller;

import lombok.RequiredArgsConstructor;
import nexttravelcompanyuser.service.dto.UserDTO;
import nexttravelcompanyuser.service.entity.User;
import nexttravelcompanyuser.service.service.UserService;
import nexttravelcompanyuser.service.util.ResponseUtility;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = {"*"})
public class UserController {

    private final UserService userService;

//  handle user Post request
    @PostMapping("/save")
    public ResponseUtility saveUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
        return new ResponseUtility(200,"Ok saved",null);
    }


    @GetMapping("/h")
    public ResponseUtility getLastUserId(){
        return null;
    }


    //handle user get request
    @GetMapping("{userName}")
    public ResponseUtility getUser(@PathVariable String userName) {
        UserDTO user = userService.getUser(userName);
        return new ResponseUtility(200, "User Fetch", user);
    }

    //handle get All users request
    @GetMapping("/getAll")
    public ResponseUtility getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return new ResponseUtility(200, "get All users", allUsers);
    }

    //handle update user request
    @PutMapping("/update")
    public ResponseUtility updateUsers(@RequestBody UserDTO userDTO) {
        userService.updateUsers(userDTO);
        return new ResponseUtility (200, "Update User",null);
    }

    //handle delete user request
    @DeleteMapping("{userId}")
    public ResponseUtility deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return new ResponseUtility(200, userId + " User Deleted", null);
    }
}
