package br.com.vuttr.api.config.security;

import br.com.vuttr.api.model.Usuario;
import br.com.vuttr.api.repository.UsuarioRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Autowired
    private UsuarioRepository repository;

    private Date gerarDataExpiracao(){
        return  new Date(System.currentTimeMillis()+expiration * 1000);
    }

    public String gerarToken(Authentication authentication){
        Usuario usuario = (Usuario) authentication.getPrincipal();

        return Jwts.builder()
                .setIssuer("Api Desafio Back-end Bossabox")
                .setSubject(usuario.getId().toString())
                .setIssuedAt(new Date())
                .setExpiration(gerarDataExpiracao())
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    public boolean isTokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Usuario getUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        Long idUsuario = Long.parseLong(claims.getSubject());
        Optional<Usuario> usuario = repository.findById(idUsuario);
        return usuario.get();
    }

}
