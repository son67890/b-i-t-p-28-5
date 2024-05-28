package com.hutech.ngay3c5.Controllers.User;

import com.hutech.ngay3c5.Entities.Role;
import com.hutech.ngay3c5.Entities.User;
import com.hutech.ngay3c5.RequestEntities.RequestCreateUser;
import com.hutech.ngay3c5.RequestEntities.RequestUpdateUser;
import com.hutech.ngay3c5.Services.RoleServices;
import com.hutech.ngay3c5.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService studentService;
    @Autowired
    private RoleServices roleServices;

    @GetMapping("")
    public String ShowAllUsers(Model model){
        List<User> students = studentService.getAllUsers();
        model.addAttribute("users", students);
        return "User/index";
    }
    @GetMapping("/edit/{id}")
    public String ShowUserForm(@PathVariable String id, Model model){
        User student = studentService.getUserById(id);
        List<Role> classrooms = roleServices.getAllRoles();
        model.addAttribute("users", student);
        model.addAttribute("roles", classrooms);
        return "User/edit";
    }
    @PostMapping("/saveedit")
    public String SaveEditUser(RequestUpdateUser requestUpdateUser){
        studentService.updateUser(requestUpdateUser.getId(),requestUpdateUser);
        return "redirect:/users";
    }
    @GetMapping("/new")
    public String createForm(Model model){
        User student = new User();
        List<Role> classrooms = roleServices.getAllRoles();
        model.addAttribute("users", student);
        model.addAttribute("roles", classrooms);
        return "User/create";
    }
    @PostMapping("/create")
    public String SaveCreateUser(RequestCreateUser requestCreateUser){
        studentService.CreateUser(requestCreateUser);
        return "redirect:/users";
    }
    //Thêm view
    @GetMapping("/info/{id}")
    public String ShowUserFormView(@PathVariable String id, Model model){
        User student = studentService.getUserById(id);
        List<Role> classrooms = roleServices.getAllRoles();
        model.addAttribute("user", student);
        model.addAttribute("roles", classrooms);
        return "User/view";
    }

    @GetMapping("/delete/{id}")
    public String DeleteUser(@PathVariable String id){
        User student = studentService.getUserById(id);
        studentService.DeleteUser(id);
        return "redirect:/users";
    }
}