package br.com.vuttr.api.controller.form;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.*;

@Data
public class LoginForm {
    @NotBlank @NotNull @Size(min = 6, max = 30)
    private String username;
    @NotBlank @NotNull @Min(8)
    private String password;

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(username,password);
    }
}
