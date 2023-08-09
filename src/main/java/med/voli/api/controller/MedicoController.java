package med.voli.api.controller;

import jakarta.validation.Valid;
import med.voli.api.dto.DadosCadastroMedicoDto;
import med.voli.api.dto.DadosListagemMedicoDto;
import med.voli.api.medico.Medico;
import med.voli.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;
    
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicoDto dados) {
        repository.save(new Medico(dados));
    }
    
    @GetMapping
    public Page<DadosListagemMedicoDto> listar(Pageable pageable){
        return repository.findAll(pageable).map(DadosListagemMedicoDto::new);
    }
}
