package br.com.vuttr.api.controller;

import br.com.vuttr.api.controller.form.UsuarioForm;
import br.com.vuttr.api.model.Usuario;
import br.com.vuttr.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<?> createUser( @RequestBody @Valid UsuarioForm form){

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String senha = encoder.encode(form.getPassword());

    form.setPassword(senha);

    Usuario usuario = usuarioRepository.save(form.converter());

    return ResponseEntity.ok(usuario);

    }


}
