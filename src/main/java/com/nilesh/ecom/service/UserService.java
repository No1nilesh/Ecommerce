package com.nilesh.ecom.service;
import com.nilesh.ecom.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDTO register(UserDTO userDTO);

    String verify(UserDTO userDTO);
}
