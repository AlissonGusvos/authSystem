package com.auth.authSystem.service;

import com.auth.authSystem.entity.User;
import com.auth.authSystem.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public String register(User user) {
        authRepository.save(user);
        return "Usuário cadastrado";
    }

    public String login(String user, String senha) {
        Optional<User> reqUser = authRepository.findByUserAndSenha(user, senha);

        if (reqUser.isPresent()) {
            return "Login feito com sucesso";
        }
        return "Acesso negado";
    }
}
