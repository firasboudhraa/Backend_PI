package tn.esprit.backend_pi.control;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend_pi.entity.Role;
import tn.esprit.backend_pi.service.IRoleService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/role")
public class RoleRestController {
    @Autowired
    private IRoleService roleService;

    // http://localhost:8089/Backend/role/retrieve-all-roles
    @GetMapping("/retrieve-all-roles")
    public List<Role> getRoles() {
        return roleService.retrieveAllRoles();
    }

    // http://localhost:8089/Backend/role/retrieve-role/{role-id}
    @GetMapping("/retrieve-role/{role-id}")
    public Role retrieveRole(@PathVariable("role-id") Long id) {
        return roleService.retrieveRole(id);
    }

    // http://localhost:8089/Backend/role/add-role
    @PostMapping("/add-role")
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        Role savedRole = roleService.addRole(role);
        return ResponseEntity.ok(savedRole);
    }



    //http://localhost:8089/Backend/role/remove-role/role-id}
    @DeleteMapping("/remove-role/{role-id}")
    public String removeRole(@PathVariable("role-id") Long id) {
        return roleService.removeRole(id);
    }


    // http://localhost:8089/Backend/role/modify-role
    @PutMapping("/modify-role")
    public ResponseEntity<?> modifyRole(@RequestBody Role role) {
        if (role.getId() == null) {
            return ResponseEntity.badRequest().body("Role ID is required for update.");
        }
        return ResponseEntity.ok(roleService.modifyRole(role));
    }



}

