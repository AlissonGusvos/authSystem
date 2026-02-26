package com.auth.authSystem.service;

import com.auth.authSystem.entity.User;
import com.auth.authSystem.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean checkPass(String senha, String senhaBanco){
        return passwordEncoder.matches(senha, senhaBanco);
    }

    public String register(User user) {
        user.setSenha(passwordEncoder.encode(user.getSenha()));
        authRepository.save(user);
        return "Usuário cadastrado";
    }

    public String login(String user, String senha) {
        Optional<User> reqUser = authRepository.findByUser(user);

        if (reqUser.isPresent()) {
            User userVerify = reqUser.get();

            if (checkPass(senha, userVerify.getSenha())) {
                return "Login feito com sucesso";
            }
        }
        return "Acesso negado";
    }
}
