package sda.spring.rest.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sda.spring.rest.model.User;
import sda.spring.rest.repository.UserRepository;
import sda.spring.rest.service.exception.EmailAlreadyUsedException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    private static final String USER_EMAIL = "someEmail@gmail.com";
    private static final User USER = new User().setEmail(USER_EMAIL);
    private static final User ANOTHER_USER = new User().setEmail(USER_EMAIL);

    @Test
    @DisplayName("Should call repository when find all")
    void shouldCallRepositoryWhenFindAll() {
        userService.findAll();

        verify(userRepository).findAll();
    }

    @Test
    @DisplayName("Should return the users when find all")
    void shouldReturnTheUsersWhenFindAll() {
        List<User> users = Arrays.asList(new User().setId(1), new User().setId(2));
        Mockito.when(userRepository.findAll())
                .thenReturn(users);

        List<User> actualUsers = userService.findAll();

        Assertions.assertThat(actualUsers).usingFieldByFieldElementComparator()
                .containsExactlyElementsOf(users);
    }

    // given `email not used`, when save(user), verify(userRepository).save(user); (happy flow)
    // verify in order: userRepository.findByEmail(), userRepository.save()
    @Test
    void shouldCallUserRepositoryWhenSave() {
        //given
        Mockito.when(userRepository.findByEmail(USER_EMAIL)).thenReturn(null);
        //when
        userService.save(USER);
        //then
        InOrder inOrder = Mockito.inOrder(userRepository);
        inOrder.verify(userRepository).findByEmail(USER_EMAIL);
        inOrder.verify(userRepository).save(USER);
    }

    // given `email already used`, when save(user), assertThrows EmailAlreadyUsedException
    @Test
    @DisplayName("Should throw EmailAlreadyUsedException given email already used")
    void shouldThrowEmailAlreadyUsedException() {
        //given
        Mockito.when(userRepository.findByEmail(USER_EMAIL)).thenReturn(ANOTHER_USER);
        // when + then
        assertThrows(EmailAlreadyUsedException.class, () -> userService.save(USER));
        Mockito.verifyNoMoreInteractions(userRepository);
    }


}