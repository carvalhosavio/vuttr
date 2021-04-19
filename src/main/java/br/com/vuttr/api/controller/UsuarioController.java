package br.com.vuttr.api.controller;

import br.com.vuttr.api.controller.dto.UsuarioDto;
import br.com.vuttr.api.controller.form.UsuarioForm;
import br.com.vuttr.api.model.Usuario;
import br.com.vuttr.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> createUser(@RequestBody @Valid UsuarioForm form){
        Optional<Usuario> user =  usuarioService.findByEmail(form.getEmail());
        if(user.isPresent()) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        Usuario usuario = usuarioService.createUser(form.converter());
        return ResponseEntity.status(HttpStatus.OK).body(UsuarioDto.converter(usuario));
    }

}
