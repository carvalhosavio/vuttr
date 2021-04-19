package br.com.vuttr.api.controller.dto;

import br.com.vuttr.api.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * @author savio
 */

@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
 @Getter
 private String username;
 @Getter
 private String email;

 public static UsuarioDto converter(Usuario usuario){
    return new UsuarioDto(usuario.getUsername(),usuario.getEmail());
 }

}
