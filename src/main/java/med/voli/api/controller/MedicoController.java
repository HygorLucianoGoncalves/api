package med.voli.api.controller;

import jakarta.validation.Valid;
import med.voli.api.domain.medicos.dto.DadosCadastroMedicoDTO;
import med.voli.api.domain.medicos.dto.DadosDetalhamentoMedicoDTO;
import med.voli.api.domain.medicos.dto.DadosListagemMedicoDTO;
import med.voli.api.domain.medicos.dto.DadosPutMedicosDTO;
import med.voli.api.domain.medicos.entity.Medico;
import med.voli.api.domain.medicos.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedicoDTO dados, UriComponentsBuilder uriBuilder) {
        var medico = new Medico(dados);
        repository.save(medico);

        var uri = uriBuilder.path("/medico/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedicoDTO(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedicoDTO>> listar(Pageable pageable) {
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemMedicoDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}") 
    public ResponseEntity getById(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedicoDTO(medico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosPutMedicosDTO dadosPutMedicosDTO) {
        var medico = repository.getReferenceById(dadosPutMedicosDTO.id());
        medico.atualizarInformacoes(dadosPutMedicosDTO);

        return ResponseEntity.ok(new DadosDetalhamentoMedicoDTO(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteById(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.desativar();

        return ResponseEntity.noContent().build();
    }
    

}
