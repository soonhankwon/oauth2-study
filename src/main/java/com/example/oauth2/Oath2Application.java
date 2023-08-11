package com.example.oauth2;

import com.example.oauth2.domain.Member;
import com.example.oauth2.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing
public class Oath2Application {

    public static void main(String[] args) {
        SpringApplication.run(Oath2Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(MemberRepository memberRepository, PasswordEncoder encoder) {
        return args -> {
            memberRepository.save(new Member("user@google.com", encoder.encode("1234"), "ROLE_USER"));
            memberRepository.save(new Member("admin@google.com", encoder.encode("1234"), "ROLE_USER,ROLE_ADMIN"));
        };
    }
}
