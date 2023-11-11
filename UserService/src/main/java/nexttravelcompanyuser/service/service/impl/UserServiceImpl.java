package nexttravelcompanyuser.service.service.impl;

import lombok.RequiredArgsConstructor;
import nexttravelcompanyuser.service.dto.UserDTO;
import nexttravelcompanyuser.service.entity.User;
import nexttravelcompanyuser.service.repository.UserRepository;
import nexttravelcompanyuser.service.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    //save User details in db
    @Override
    public void saveUser(UserDTO userDTO) {
        if (!userRepository.existsByUserId(userDTO.getUserId())) {
            userRepository.save(modelMapper.map(userDTO, User.class));
        } else {
            throw new RuntimeException(userDTO.getUserId() + " User Already Exist");
        }
    }

    //get last user id from database
    @Override
    public String getLastUserId() {
        return userRepository.generateUserId();
    }

    //get User details from db
    @Override
    public UserDTO getUser(String userName) {
        User byUserName = userRepository.findByUserName(userName);
        return modelMapper.map(byUserName, UserDTO.class);
    }

    //get all User details from db
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Update User details in db
    @Override
    public void updateUsers(UserDTO userDTO) {
        if (userRepository.existsByUserId(userDTO.getUserId())) {
            userRepository.save(modelMapper.map(userDTO, User.class));
        } else {
            throw new RuntimeException(userDTO.getUserId() + " User not Found");
        }
    }

    //Delete User details in db
    @Override
    public void deleteUser(String userId) {
        userRepository.deleteByUserId(userId);
    }


}
