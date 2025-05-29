package com.lvsolutions.system.config;

import com.lvsolutions.system.entity.Users;
import com.lvsolutions.system.entity.euns.Role;
import com.lvsolutions.system.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(UserRepository usersRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (usersRepository.count() == 0) {
                Users admin = new Users();
                admin.setName("Admin Master");
                admin.setEmail("admin@lvsolutions.com");
                admin.setPassword(passwordEncoder.encode("admin123")); // senha segura e criptografada
                admin.setPosition("Administrador do sistema");
                admin.setRole(Role.administrator);

                usersRepository.save(admin);
                System.out.println("Usuário administrador criado com sucesso!");
            }
        };
    }
}