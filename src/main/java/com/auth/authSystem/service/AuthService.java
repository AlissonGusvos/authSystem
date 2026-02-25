package com.auth.authSystem.service;

import com.auth.authSystem.entity.User;
import com.auth.authSystem.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public String register(User user) {
        authRepository.save(user);
        return "Usuário cadastrado";
    }

}
