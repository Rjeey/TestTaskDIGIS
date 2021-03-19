package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javassist.NotFoundException;
import org.example.dto.UserDto;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@Validated
@Api(value = "User MicroService", description = "MicroService For User Management")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Display all available Users")
    @GetMapping("/get/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @ApiOperation(value = "Create new User")
    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.OK)
    public void save(@ApiParam(value = "Post DTO instance") @Validated @RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @ApiOperation(value = "Update User details by ID")
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@ApiParam(value = "Post DTO instance") @Validated @RequestBody UserDto userDto,
                       @PathVariable("id") @Min(1) Long id) throws NotFoundException {
        userService.update(id, userDto);
    }

}
