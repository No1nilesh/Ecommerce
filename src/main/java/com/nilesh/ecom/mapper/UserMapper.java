package com.nilesh.ecom.mapper;

import com.nilesh.ecom.dto.UserDTO;
import com.nilesh.ecom.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapper {
    public static UserDTO userToDTO(Users user){
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail()
        );
    }

    public static Users dtoToUser(UserDTO userDTO){
        Users user = new Users();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        return user;
    }
}
