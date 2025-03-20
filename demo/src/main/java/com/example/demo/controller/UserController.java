package com.example.demo.controller;

import com.example.demo.service.UserService;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
@Controller
public class UserController {
    
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/")
    public String getHomePage(Model model) {
        List<User> arrUsers = this.userService.getAllUser();
        System.out.println(arrUsers);
        String test = this.userService.handleHello();
        model.addAttribute("eric", test);
        return "hello";
    }
    @RequestMapping("/admin/user") 
        public String getTable(Model model) {
            List<User> users = this.userService.getAllUser();
            model.addAttribute("users1", users);
            return "admin/user/table";
        }
    @RequestMapping("admin/user/{id}") 
        public String getUserTable(Model model, @PathVariable long id) {
            User user = this.userService.getUserById(id);
            model.addAttribute("user", user);
            model.addAttribute("id", id);
            return "admin/user/show";
    }
    @RequestMapping("/admin/user/create")
    public String getUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }
    @RequestMapping("/admin/user/update/{id}")
    public String getPage(Model model, @PathVariable long id) {
        User current = this.userService.getUserById(id);
        model.addAttribute("newUser", current);
        return "admin/user/update";
    }
    @PostMapping("/admin/user/update")
    public String getUpdatePage(Model model, @ModelAttribute("newUser") User hoidanit) {
        User currentUser = this.userService.getUserById(hoidanit.getId());
        if (currentUser != null) {
            currentUser.setAddress(hoidanit.getAddress());
            currentUser.setFullName(hoidanit.getFullName());
            currentUser.setPhone(hoidanit.getPhone());
            this.userService.handleSaveUser(currentUser);
        }
        return "redirect:/admin/user";
    }
    
    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String  createUserPage(Model model, @ModelAttribute("newUser") User hoidanit) {
        System.out.println("run here" + hoidanit);
        this.userService.handleSaveUser(hoidanit);
        return "redirect:/admin/user";
    }
    @GetMapping("/admin/user/delete/{id}") 
        public String getDeleteUser(Model model, @PathVariable long id) {
            model.addAttribute("id", id);
            model.addAttribute("newUser", new User());
            return "admin/user/delete";
        }
    @PostMapping("/admin/user/delete") 
    public String postDeleteUser(Model model, @ModelAttribute("newUser") User hoidanit) {
        this.userService.DeleteUserById(hoidanit.getId());
        return "redirect:/admin/user";
    }
    // @GetMapping("admin/user/delete/{id}") 
    //     public String getDeleteUserPage(Model model, @PathVariable long id) {
    //         model.addAttribute("id", id);
    //         return "admin/user/delete";
    // }
}
    



// @RestController
// public class UserController {

//     private final UserService userService;

//     private UserController userController;
    

//     public UserController(UserController userController, UserService userService) {
//         this.userController = userController;
//         this.userService = userService;
//     }


//     @GetMapping("/")
//     public String getHomePage() {
//         return this.userController.handleHello();
//     }
// }