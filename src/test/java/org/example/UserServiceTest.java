package org.example;

import org.example.dto.UserDto;
import org.example.mapper.UserMapper;
import org.example.model.Gender;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    public void saveUser() {
        UserDto userDto = new UserDto("login", "name", new Date(), Gender.MALE);
        userService.save(userDto);
        verify(userRepository, times(1)).save(UserMapper.userDtoToUser(userDto));
    }

    @Test
    public void getAllUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User("Lala", "John Nicklson", new Date(), Gender.MALE);
        User user2 = new User("Rjeey", "Rosa White", new Date(), Gender.FEMALE);
        User user3 = new User("Druid", "Lola Lizariya", new Date(), Gender.FEMALE);

        users.add(user1);
        users.add(user2);
        users.add(user3);

        when(userRepository.findAll()).thenReturn(users);

        List<User> empUsers = userService.getUsers();

        verify(userRepository, times(1)).findAll();
    }

}
