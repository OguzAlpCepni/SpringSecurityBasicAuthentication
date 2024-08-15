package basicauth.springsecuritybasicauthentication.dto;

import basicauth.springsecuritybasicauthentication.model.Role;
import lombok.Builder;

import java.util.Set;
@Builder
public record CreateUserRequest(
        String name,
        String username,
        String password,
        Set<Role> authorities

) {
}
