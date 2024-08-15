package basicauth.springsecuritybasicauthentication.dto;

import basicauth.springsecuritybasicauthentication.model.Role;

import java.util.Set;

public record CreateUserRequest(
        String name,
        String username,
        String password,
        Set<Role> authorities

) {
}
