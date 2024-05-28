package com.hutech.ngay3c5.Services;

import com.hutech.ngay3c5.Entities.User;
import com.hutech.ngay3c5.Repositories.UserRepository;
import com.hutech.ngay3c5.RequestEntities.RequestCreateUser;
import com.hutech.ngay3c5.RequestEntities.RequestUpdateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User CreateUser(RequestCreateUser requestCreateUser){
        try {
            User student = new User();
            student.setFirstName(requestCreateUser.getFirstName());
            student.setLastName(requestCreateUser.getLastName());
            student.setEmail(requestCreateUser.getEmail());
            student.setPassword(requestCreateUser.getPassword());
            student.setUserName(requestCreateUser.getUserName());
            student.setRole(requestCreateUser   .getRole());
            userRepository.save(student);
            return student;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(String id){
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User with id " + id + " not found")
        );
    }
    public User updateUser(String id, RequestUpdateUser requestUpdateUser){
        try {
            User student = getUserById(id);
            student.setFirstName(requestUpdateUser.getFirstName());
            student.setLastName(requestUpdateUser.getLastName());
            student.setPassword(requestUpdateUser.getPassword());
            student.setUserName(requestUpdateUser.getUserName());
            student.setRole(requestUpdateUser.getRole());
            return userRepository.save(student);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public void DeleteUser(String id){
        try {
            userRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
