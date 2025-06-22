package com.evoting.service;

import com.evoting.model.User;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InMemoryService implements UserDetailsService {

    private final Map<String, User> users = new HashMap<>();

    public InMemoryService() {
        // Plain-text passwords (⚠️ not for production use!)
        users.put("admin", new User("admin", "admin123", "ADMIN"));
        users.put("user", new User("user", "user123", "USER"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.get(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
    }

    public void saveUser(User user) {
        users.put(user.getUsername(), user);
    }

    public boolean existsByUsername(String username) {
        return users.containsKey(username);
    }

    public User findByUsername(String username) {
        return users.get(username);
    }
}
