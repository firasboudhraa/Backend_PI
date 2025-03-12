package tn.esprit.backend_pi.control;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend_pi.entity.User;
import tn.esprit.backend_pi.service.IUserService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserRestController {
    @Autowired
    private IUserService userService;

    // http://localhost:8089/Backend/user/retrieve-all-users

    @GetMapping("/retrieve-all-users")
    public List<User> getUsers() {
        return userService.retrieveAllUsers();
    }

    // http://localhost:8089/Backend/user/retrieve-user/{user-id}

    @GetMapping("/retrieve-user/{user-id}")
    public User retrieveUser(@PathVariable("user-id") Long id) {
        return userService.retrieveUser(id);
    }

    // http://localhost:8089/Backend/user/add-user
    @PostMapping("/add-user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User savedUser = userService.addUser(user);
        return ResponseEntity.ok(savedUser);
    }

    //http://localhost:8089/Backend/user/remove-user/user-id}
    @DeleteMapping("/remove-user/{user-id}")
    public String removeUser(@PathVariable("user-id") Long id) {
        return userService.removeUser(id);
    }


    // http://localhost:8089/Backend/user/modify-user

  /* @PutMapping("/modify-user")
    public User modifyUser(@RequestBody User user) {
        return userService.modifyUser(user);
    }
*/
    @PutMapping("/modify-user")
    public ResponseEntity<?> modifyUser(@RequestBody User user) {
        if (user.getId() == null) {
            return ResponseEntity.badRequest().body("User ID is required for update.");
        }
        return ResponseEntity.ok(userService.modifyUser(user));
    }



}
