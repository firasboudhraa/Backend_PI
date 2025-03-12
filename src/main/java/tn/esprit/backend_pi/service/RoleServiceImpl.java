package tn.esprit.backend_pi.service;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.backend_pi.entity.Role;
import tn.esprit.backend_pi.repository.RoleRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements IRoleService {
    @Autowired

    private RoleRepository roleRepository;

    @Override
    public List<Role> retrieveAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role retrieveRole(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }


    @Override
    public String removeRole(Long id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
            return "Role deleted successfully.";
        }
        return "Role not found.";
    }

    @Override
    public Role modifyRole(Role role) {
        return roleRepository.save(role);
    }





}
