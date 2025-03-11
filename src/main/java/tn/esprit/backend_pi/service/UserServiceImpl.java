package tn.esprit.backend_pi.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.backend_pi.entity.User;
import tn.esprit.backend_pi.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    @Autowired

    private  UserRepository userRepository;

    @Override
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User retrieveUser(UUID id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

   /* @Override
    public void removeUser(UUID id) {
        userRepository.deleteById(id);
    }
*/
    @Override
    public String removeUser(UUID id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User deleted successfully.";
        }
        return "User not found.";
    }

   @Override
    public User modifyUser(User user) {
        return userRepository.save(user);
    }



}
