package basicauth.springsecuritybasicauthentication;

import basicauth.springsecuritybasicauthentication.dto.CreateUserRequest;
import basicauth.springsecuritybasicauthentication.model.Role;
import basicauth.springsecuritybasicauthentication.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class SpringSecurityBasicAuthenticationApplication implements CommandLineRunner {

    private final UserService userService;

    public SpringSecurityBasicAuthenticationApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityBasicAuthenticationApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        CreateDummyData();
    }

    private void CreateDummyData(){
        CreateUserRequest request = CreateUserRequest.builder()
                .name("oguz")
                .username("oguz")
                .password("pass")
                .authorities(Set.of((Role.ROLE_USER)))
                .build();

        userService.createUser(request);

        CreateUserRequest request2= CreateUserRequest.builder()
                .name("alp")
                .username("alp")
                .password("pass")
                .authorities(Set.of((Role.ROLE_FSK)))
                .build();

        userService.createUser(request2);

        CreateUserRequest request3 = CreateUserRequest.builder()
                .name("yaren")
                .username("yaren")
                .password("pass")
                .authorities(Set.of((Role.ROLE_ADMIN)))
                .build();

        userService.createUser(request3);
    }


}
