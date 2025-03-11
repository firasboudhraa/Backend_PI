package tn.esprit.backend_pi.service;

import tn.esprit.backend_pi.entity.User;
import java.util.List;
import java.util.UUID;

public interface IUserService {

    List<User> retrieveAllUsers();
    User retrieveUser(UUID id);
    User addUser(User user);
    //void removeUser(UUID id);
     String removeUser(UUID id);

   User modifyUser(User user);
}
