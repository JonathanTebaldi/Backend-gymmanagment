package br.edu.fema.tccacademia.controller;

import br.edu.fema.tccacademia.infra.security.DadosTokenJWT;
import br.edu.fema.tccacademia.infra.security.TokenService;
import br.edu.fema.tccacademia.models.usuario.DadosAutenticacao;
import br.edu.fema.tccacademia.models.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var autentication = manager.authenticate(token);
        var tokenJWT = tokenService.gerarToken((Usuario) autentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
