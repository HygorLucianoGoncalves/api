package med.voli.api.controller;

import jakarta.validation.Valid;
import med.voli.api.domain.usuario.dto.DadosAutenticacaoDTO;
import med.voli.api.domain.usuario.entities.Usuario;
import med.voli.api.domain.usuario.repository.UsuarioRepository;
import med.voli.api.infra.security.DadosTokenJwt;
import med.voli.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacaoDTO dados) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = this.manager.authenticate(usernamePassword);

        var token = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJwt(token));
    }

    @PostMapping("/cadastro")//CRIE ESSE METODO PQ ESTOU USANDO O H2 COMO BANCO DE DADO
    public ResponseEntity cadastrarLogin(@RequestBody @Valid DadosAutenticacaoDTO dados) {
        if (this.repository.findByLogin(dados.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(dados.senha());
        Usuario novoUsuario = new Usuario(dados.login(), encryptedPassword);
        
        this.repository.save(novoUsuario);
        
        return ResponseEntity.ok().build();
    }
}
