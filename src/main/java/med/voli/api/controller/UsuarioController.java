package med.voli.api.controller;

import jakarta.validation.Valid;
import med.voli.api.domain.medicos.dto.DadosCadastroMedicoDTO;
import med.voli.api.domain.medicos.dto.DadosDetalhamentoMedicoDTO;
import med.voli.api.domain.medicos.entities.Medico;
import med.voli.api.domain.usuario.dto.DadosAutenticacaoDTO;
import med.voli.api.domain.usuario.entities.Usuario;
import med.voli.api.domain.usuario.repository.UsusarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cadastro/login")
public class UsuarioController {

    @Autowired
    private UsusarioRepository repository;
    
    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(repository.findAll());
    }
    @PostMapping//CRIE ESSE METODO PQ ESTOU USANDO O H2 COMO BANCO DE DADO
    @Transactional
    public ResponseEntity cadastrarLogin(@RequestBody @Valid DadosAutenticacaoDTO dados) {
        var usuario = new Usuario(dados);
        repository.save(usuario);
        return ResponseEntity.ok().build();
    }
}
