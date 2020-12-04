package br.com.vuttr.api.controller.form;

import br.com.vuttr.api.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioForm {
    @NotBlank
    @NotNull
    @Size(min = 6, max = 30)
    private String username;
    @NotBlank
    @NotNull
    private String password;

    public Usuario converter(){
        return new Usuario(username,password);
    }
}
