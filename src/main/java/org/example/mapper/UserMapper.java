package org.example.mapper;

import org.example.dto.UserDto;
import org.example.model.User;

public class UserMapper {

    public static User userDtoToUser(UserDto userDto){
        return new User(userDto.getLogin(), userDto.getFullName(),
                userDto.getDob(), userDto.getGender());
    }

    public static UserDto userToUserDto(User user){
        return new UserDto(user.getLogin(),user.getFullName(),
                user.getDob(), user.getGender());
    }
}
