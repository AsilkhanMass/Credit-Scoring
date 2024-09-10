package com.example.creditscoring.service;

import com.example.creditscoring.dto.user.RegisterDto;
import com.example.creditscoring.entity.UserEntity;
import com.example.creditscoring.exception.UserAlreadyExistsException;
import com.example.creditscoring.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterDto dto) {
        UserEntity existingUser = userRepository.findByEmail(dto.email()).orElse(null);

        if (existingUser == null) {
            UserEntity user = UserEntity.builder()
                    .name(dto.name())
                    .lastName(dto.lastName())
                    .salary(dto.salary())
                    .password(passwordEncoder.encode(dto.password()))
                    .build();
            userRepository.save(user);
        }else{
            throw new UserAlreadyExistsException("User not found!");
        }
    }
}
