package org.ykko21.accounts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ykko21.accounts.dto.UserDTO;
import org.ykko21.accounts.entity.User;
import org.ykko21.accounts.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> list = new ArrayList<>(users.size());
        for (User u: users) {
            list.add(u.toDTO());
        }
        return list;
    }

    public UserDTO findUserById(String id){
        //User user = userRepository.findUserById(id);
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return null;
        } else {
            return user.get().toDTO();
        }
    }

    public UserDTO save(UserDTO u) {
        if (u.getUserId() == null) {
            u.setUserId(UUID.randomUUID().toString());
        }
        return userRepository.save(u.toEntity()).toDTO();
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

}
