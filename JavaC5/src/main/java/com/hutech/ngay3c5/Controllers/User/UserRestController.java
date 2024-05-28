package com.hutech.ngay3c5.Controllers.User;

import com.hutech.ngay3c5.Entities.User;
import com.hutech.ngay3c5.RequestEntities.RequestCreateUser;
import com.hutech.ngay3c5.RequestEntities.RequestUpdateUser;
import com.hutech.ngay3c5.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserRestController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    public User CreateUser(@RequestBody RequestCreateUser requestCreateUser) {
        return userService.CreateUser(requestCreateUser);
    }
    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody RequestUpdateUser requestUpdateUser) {
        return userService.updateUser(id, requestUpdateUser);
    }
}
