package br.com.vuttr.api.controller.dto;

import lombok.Getter;

public class TokenDto {
    @Getter
    private String token;
    @Getter
    private String tipo;
    @Getter
    private String usermane;
    @Getter
    private String email;

    public TokenDto(String token, String tipo,String email, String usermane) {
        this.token = token;
        this.tipo = tipo;
        this.email = email;
        this.usermane = usermane;
    }

}
