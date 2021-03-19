package org.example.service;

import javassist.NotFoundException;
import org.example.dto.UserDto;
import org.example.mapper.UserMapper;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {

        return userRepository.findAll();
    }

    public void save(UserDto userDto) {
        userRepository.save(UserMapper.userDtoToUser(userDto));
    }

    public void update(Long id, UserDto userDto) throws NotFoundException {
        User user = userRepository.findById(id).orElseThrow(()->
                new NotFoundException("Post with ID : "+id+" Not Found!"));
        User newuser = UserMapper.userDtoToUser(userDto);
        newuser.setId(id);
        userRepository.save(user);
    }
}
