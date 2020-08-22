package sda.spring.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.spring.rest.model.User;
import sda.spring.rest.repository.UserRepository;
import sda.spring.rest.service.exception.EmailAlreadyUsedException;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) throws EmailAlreadyUsedException {
        User userInDB = userRepository.findByEmail(user.getEmail());
        if (userInDB != null){
            throw new EmailAlreadyUsedException();
        }
        return userRepository.save(user);
    }
}
