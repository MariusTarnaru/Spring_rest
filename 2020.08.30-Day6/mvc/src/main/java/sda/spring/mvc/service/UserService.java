package sda.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.spring.mvc.model.User;
import sda.spring.mvc.repository.UserRepository;
import sda.spring.mvc.service.dto.UserDTO;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = new LinkedList<>();
        for (User user : users) {
            UserDTO userDTO = toDTO(user);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    public List<UserDTO> getAllWithStreams() {
        return userRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public void save(UserDTO user) {
        userRepository.save(toEntity(user));
    }

    private UserDTO toDTO(User user) {
        return new UserDTO()
                .setId(user.getId())
                .setName(user.getName())
                .setCountry(user.getCountry())
                .setEmail(user.getEmail());
    }

    private User toEntity(UserDTO user) {
        return new User()
                .setId(user.getId())
                .setName(user.getName())
                .setCountry(user.getCountry())
                .setEmail(user.getEmail());
    }
}
