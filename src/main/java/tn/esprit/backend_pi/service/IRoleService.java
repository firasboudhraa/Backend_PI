package tn.esprit.backend_pi.service;

import tn.esprit.backend_pi.entity.Role;
import tn.esprit.backend_pi.entity.User;

import java.util.List;

public interface IRoleService {

    List<Role> retrieveAllRoles();
    Role retrieveRole(Long id);
    Role addRole(Role role);
    String removeRole(Long id);

    Role modifyRole(Role role);

}
