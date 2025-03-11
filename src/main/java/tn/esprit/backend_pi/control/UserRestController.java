package tn.esprit.backend_pi.control;

//import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    /*
    @Operation(description = "Récupérer tous les utilisateurs de la base de données")
    */
    @GetMapping("/retrieve-all-users")
    public List<User> getUsers() {
        return userService.retrieveAllUsers();
    }

    // http://localhost:8089/Backend/user/retrieve-user/{user-id}
    /*
    @Operation(description = "Récupérer un utilisateur par ID")
    */
    @GetMapping("/retrieve-user/{user-id}")
    public User retrieveUser(@PathVariable("user-id") UUID id) {
        return userService.retrieveUser(id);
    }

    // http://localhost:8089/Backend/user/add-user
    /*
    @Operation(description = "Ajouter un nouvel utilisateur")
    */

    @PostMapping("/add-user")
    public User addUser(@RequestBody User addeduser) {
        User savedUser = userService.addUser(addeduser);
        System.out.println("Saved User: " + savedUser);
        return savedUser;
    }





    //http://localhost:8089/Backend/user/remove-user/user-id}
    /*
    @Operation(description = "Supprimer un utilisateur par ID")
    */
    /*@DeleteMapping("/remove-user/{user-id}")
    public void removeUser(@PathVariable("user-id") UUID id) {
        userService.removeUser(id);
    }
*/
    @DeleteMapping("/remove-user/{user-id}")
    public String removeUser(@PathVariable("user-id") UUID id) {
        return userService.removeUser(id);
    }


    // http://localhost:8089/Backend/user/modify-user
    /*
    @Operation(description = "Modifier un utilisateur existant")
    */
   @PutMapping("/modify-user")
    public User modifyUser(@RequestBody User user) {
        return userService.modifyUser(user);
    }


}
