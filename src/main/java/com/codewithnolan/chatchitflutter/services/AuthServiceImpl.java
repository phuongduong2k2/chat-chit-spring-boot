package com.codewithnolan.chatchitflutter.services;

import com.codewithnolan.chatchitflutter.dtos.StatusResponse;
import com.codewithnolan.chatchitflutter.dtos.user.*;
import com.codewithnolan.chatchitflutter.entities.User;
import com.codewithnolan.chatchitflutter.exceptions.AuthException;
import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    @NonNull private PasswordEncoder passwordEncoder;
    @NonNull private UserService userService;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Optional<User> user = userService.getByEmail(loginRequest.getEmail());
        if (user.isEmpty()) {
            throw new EntityNotFoundException("User not found");
        }
        boolean validPassword = verifyPassword(loginRequest.getPassword(), user.get().getPassword());
        if (!validPassword) {
            throw new AuthException("Invalid password", HttpStatus.UNAUTHORIZED);
        }
        return UserMapper.toLoginResponse(user.get());
    }

    @Override
    public StatusResponse register(RegisterRequest registerRequest) {
        Optional<User> optionalUserEmail = userService.getByEmail(registerRequest.getEmail());
        Optional<User> optionalUserUsername = userService.getByUsername(registerRequest.getUsername());
        if (optionalUserEmail.isPresent()) {
            throw new AuthException("An email is already exist", HttpStatus.BAD_REQUEST);
        }
        if (optionalUserUsername.isPresent()) {
            throw new AuthException("An username is already exist", HttpStatus.BAD_REQUEST);
        }
        String hashedPassword = passwordEncoder.encode(registerRequest.getPassword());
        registerRequest.setPassword(hashedPassword);
        User user = UserMapper.fromRegisterRequest(registerRequest);
        userService.save(user);
        return new StatusResponse("Create account is success");
    }

    private boolean verifyPassword(String rawPassword, String storedHash) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        return encoder.matches(rawPassword, storedHash);
    }
}
