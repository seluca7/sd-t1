package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.UserDTO;
import com.example.springdemo.entities.User;

public class UserBuilder {

    public static User generateUserFromDTO(UserDTO userDTO)
    {
        return new User(userDTO.getUser_id(),
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getRole());
    }

    public static UserDTO generateDTOFromUser(User user)
    {
        return new UserDTO(user.getUser_id(),
                user.getUsername(),
                user.getPassword(),
                user.getRole());
    }
}
