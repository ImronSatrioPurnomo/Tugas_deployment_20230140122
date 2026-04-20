package controller;


import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService
    }

    @PostMapping
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return "user deleted successfully";
    }

    @GetMapping("{/id}"){
        public User getUserById(id);
    }

    @PutMapping("{/id}")
    public String updateUser (@PathVariable String id, @RequestBody user request){
        userService.updateuser(id, request);
        return "user updated successfully";
    }


}
