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

    // verify(userRepository.findAll()
    // assertEquals(actualUsers, expectedUsers()
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // given `email not used`, when save(user), verify(userRepository).save(user); (happy flow)
    // given `email already used`, when save(user), assertThrows EmailAlreadyUsedException
    // verify in order: userRepository.findByEmail(), userRepository.save()
    public User save(User user) {
        User userInDB = userRepository.findByEmail(user.getEmail());
        if (userInDB != null) { // true -> userInDb not null
            throw new EmailAlreadyUsedException();
        }
        return userRepository.save(user);
    }

    // given `user was found by id`, when userService.findById(userId), assertEquals(actual, expected)
    // given `was not found by id`, when userService.findById(userId), assertThrows UserNotFoundException
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

    // 1 (happy flow)
    // given Mockito.when(userRepository.findById(userId)).thenReturn(new User().setId(userId)));
    // when userService.updateStatus(userId, newStatus),
    // verify(userRepository).save()

    // 2 (sad flow)
    // given userRepository.findById(userId) returns Optional.empty()
    // given code: Mockito.when(userRepository.findById(userId)).thenReturn(Optional.empty());
    // when updateStatus(Long userId, String newStatus)
    // then assertThrows UserNotFoundException
    public User updateStatus(Long userId, String newStatus) {
//        3-liner
//        User user = findById(userId);
//        user.setStatus(newStatus);
//        return userRepository.save(user);

//        1-liner
        return userRepository.save(findById(userId).setStatus(newStatus));
    }
}
