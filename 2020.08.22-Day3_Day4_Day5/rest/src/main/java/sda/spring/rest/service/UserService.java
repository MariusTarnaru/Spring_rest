package sda.spring.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.spring.rest.model.User;
import sda.spring.rest.repository.UserRepository;
import sda.spring.rest.service.exception.EmailAlreadyUsedException;
import sda.spring.rest.service.exception.UserNotFoundException;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        User userInDB = userRepository.findByEmail(user.getEmail());
        if (userInDB != null) {
            throw new EmailAlreadyUsedException();
        }
        return userRepository.save(user);
    }

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException());

//        Optional<User> userOptional = userRepository.findById(userId);
//        if (userOptional.isPresent()) {
//            throw new UserNotFoundException();
//        } else {
//            return userOptional.get();
//        }
    }

    public User updateStatus(Long userId, String newStatus) {
//        3-liner
//        User user = findById(userId);
//        user.setStatus(newStatus);
//        return userRepository.save(user);

//        1-liner
        return userRepository.save(findById(userId).setStatus(newStatus));
    }
}
