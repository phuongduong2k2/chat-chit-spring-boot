package com.codewithnolan.chatchitflutter.services;

import com.codewithnolan.chatchitflutter.dtos.LoginFormDto;
import com.codewithnolan.chatchitflutter.dtos.RegisterFormDto;
import com.codewithnolan.chatchitflutter.dtos.RegisterFormDtoMapper;
import com.codewithnolan.chatchitflutter.entities.User;
import com.codewithnolan.chatchitflutter.repositories.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    @NonNull private UserRepository userRepository;
    @NonNull private PasswordEncoder passwordEncoder;

    @Override
    public User login(LoginFormDto loginFormDto) {
        Optional<User> user = userRepository.findByEmail(loginFormDto.getEmail());
        if (user.isEmpty()) {
            throw new EntityNotFoundException("User not found");
        }
        boolean validPassword = verifyPassword(loginFormDto.getPassword(), user.get().getPassword());
        if (!validPassword) {
            throw new RuntimeException("Invalid password");
        }
        return user.get();
    }

    @Override
    public String register(RegisterFormDto registerFormDto) {
        Optional<User> optionalUser = userRepository.findByEmail(registerFormDto.getEmail());
        if (optionalUser.isPresent()) {
            throw new EntityExistsException("An email already exist");
        }
        String hashedPassword = passwordEncoder.encode(registerFormDto.getPassword());
        registerFormDto.setPassword(hashedPassword);
        User newUser = RegisterFormDtoMapper.mapDtoToEntity(registerFormDto);
        userRepository.save(newUser);
        return "Create account is success";
    }

    private boolean verifyPassword(String rawPassword, String storedHash) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        return encoder.matches(rawPassword, storedHash);
    }
}
