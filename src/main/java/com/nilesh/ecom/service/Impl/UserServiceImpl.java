package com.nilesh.ecom.service.Impl;

import com.nilesh.ecom.dto.UserDTO;
import com.nilesh.ecom.entity.Users;
import com.nilesh.ecom.exception.UserAlreadyExistsException;
import com.nilesh.ecom.mapper.UserMapper;
import com.nilesh.ecom.repository.UserRepository;
import com.nilesh.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JWTService jwtService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public UserDTO register(UserDTO userDTO) {
        Users existingUser = userRepo.findByUsername(userDTO.getUsername());
       if (existingUser != null){
           System.out.println("User Already Exists with this username" + userDTO.getUsername());
           throw new UserAlreadyExistsException("User Already Exists with this username" + userDTO.getUsername());
       }
       Users user = UserMapper.dtoToUser(userDTO);
       user.setPassword(encoder.encode(user.getPassword()));
       Users savedUser = userRepo.save(user);
        return UserMapper.userToDTO(savedUser);
    }

    @Override
    public String verify(UserDTO userDTO) {
        Authentication authentication = authManager.
                authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));
        if (authentication.isAuthenticated()){
            return jwtService.generateToken(userDTO.getUsername());
        }
       return "Fail";
    }
}
