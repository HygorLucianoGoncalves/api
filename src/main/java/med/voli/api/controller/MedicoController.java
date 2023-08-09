package med.voli.api.controller;

import jakarta.validation.Valid;
import med.voli.api.dto.DadosCadastroMedicoDTO;
import med.voli.api.dto.DadosListagemMedicoDTO;
import med.voli.api.dto.DadosPutMedicosDTO;
import med.voli.api.medico.Medico;
import med.voli.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;
    
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicoDTO dados) {
        repository.save(new Medico(dados));
    }
    
    @GetMapping
    public Page<DadosListagemMedicoDTO> listar(Pageable pageable){
        return repository.findAllByAtivoTrue(pageable).map(DadosListagemMedicoDTO::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosPutMedicosDTO dadosPutMedicosDTO){
        var medico = repository.getReferenceById(dadosPutMedicosDTO.id());
        medico.atualizarInformacoes(dadosPutMedicosDTO);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void deleteById(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.desativar();
    }
}
