package basicauth.springsecuritybasicauthentication.service;

import basicauth.springsecuritybasicauthentication.dto.CreateUserRequest;
import basicauth.springsecuritybasicauthentication.model.User;
import basicauth.springsecuritybasicauthentication.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> getByUSername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(CreateUserRequest createUserRequest){
        User user = User.builder()
                .name(createUserRequest.name())
                .username(createUserRequest.username())
                .password(passwordEncoder.encode(createUserRequest.password()))
                .authorities(createUserRequest.authorities())
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .isEnabled(true)
                .accountNonLocked(true)
                .build();
        return userRepository.save(user);
    }


}
