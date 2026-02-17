package kz.engbro.service;

import kz.engbro.entity.enumuration.Language;
import kz.engbro.entity.enumuration.Level;
import kz.engbro.entity.model.User;
import kz.engbro.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AuthService {

    public static User USER;
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void save(String username, String password) {

        System.out.println(password);
        User user = User.builder()
                .username(username)
                .password(new BCryptPasswordEncoder().encode(password))
                .level(Level.BEGINNER)
                .count(0L)
                .language(Language.ENGLISH)
                .build();
        userRepository.save(user);
    }

    @Transactional
    public void update(User user){
        userRepository.save(user);
    }

    public User check(String username, String password){
        User user = userRepository.findByUsername(username).orElse(null);
        if(user == null){
            return null;
        }
        return check(user, password);
    }

    public User check(User user, String password){
        if (new BCryptPasswordEncoder().matches(password, user.getPassword())){
            return user;
        }
        return null;
    }

    public User findById(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }
    public User findById(int id) {
        return userRepository.findById(id).orElseThrow();
    }
}
