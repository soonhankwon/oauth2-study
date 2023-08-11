package com.example.oauth2.service;

import com.example.oauth2.domain.SecurityMember;
import com.example.oauth2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return memberRepository.findMemberByEmail(email)
                .map(SecurityMember::new)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found: " + email));
    }
}
