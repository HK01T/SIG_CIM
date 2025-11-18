package com.dcsic.sig_cim.services;

import com.dcsic.sig_cim.Model.entities.Repository.UsersRepository;
import com.dcsic.sig_cim.Model.entities.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByEmail(username);
        if  (user == null) {
            throw new UsernameNotFoundException( "User not found with email"+username);
        }
        String usernames = user.getNom() + " " + user.getPrenom();

        // ⚡ Ajout de ROLE_ pour que Spring Security reconnaisse le rôle
        List<SimpleGrantedAuthority> authorities =
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), // ⚡ important
                user.getPassword(),
                Collections.emptyList()
        );
    }
}
