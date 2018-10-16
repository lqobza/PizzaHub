package com.example.PizzaHub.services;

import com.example.PizzaHub.entities.Pizza;
import com.example.PizzaHub.entities.Role;
import com.example.PizzaHub.entities.User;
import com.example.PizzaHub.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService extends BaseService<User,UserRepository> implements UserDetailsService {

    public ResponseEntity<Iterable<Pizza>> getPizzak(Long id) {
        Optional<User> optionalUser = rRepository.findById(id);
        if(optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get().getPizzak());
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = rRepository.findByUserName(username);

        if (user.isPresent()) {
            return new UserDetailsImplement(user.get());
        }
        else
            throw new UsernameNotFoundException(null);
    }

    public ResponseEntity<User> postUser(Map<String,Object> map) {
        try {
            if (!rRepository.findByUserName(map.get("username").toString()).isPresent() && !rRepository.findByEmailAddress(map.get("emailaddress").toString()).isPresent()) {
                User user = new User();
                user.setEmailAddress(map.get("emailaddress").toString());
                user.setPassword(new BCryptPasswordEncoder().encode(map.get("password").toString()));
                user.setUserName(map.get("username").toString());
                user.setRole(Role.ROLE_USER);
                return ResponseEntity.ok(rRepository.save(user));
            }
        } catch (Exception e) {
            System.out.println("Hiba van a mátrixban!");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.IM_USED).build();
    }

}
