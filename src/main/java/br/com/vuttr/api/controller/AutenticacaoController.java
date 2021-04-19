package br.com.vuttr.api.controller;

import br.com.vuttr.api.config.security.TokenService;
import br.com.vuttr.api.controller.dto.TokenDto;
import br.com.vuttr.api.controller.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    @Autowired
    public AutenticacaoController(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid LoginForm form){
        UsernamePasswordAuthenticationToken login = form.converter();
        try {
            Authentication authentication = manager.authenticate(login);
            String token = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new TokenDto(token,"Bearer"));
        }catch (AuthenticationException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

}
