package org.ykko21.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ykko21.accounts.service.UserService;
import org.ykko21.accounts.dto.UserDTO;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public UserDTO findUserById(@PathVariable String id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public UserDTO save(@RequestBody UserDTO u) {
        return userService.save(u);
    }

    @GetMapping("all")
    public List<UserDTO> findAllUsers() {
        return userService.findAllUsers();
    }

    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable String id) {
        userService.delete(id);
    }
}
