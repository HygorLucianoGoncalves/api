package med.voli.api.controller;

import jakarta.validation.*;
import med.voli.api.domain.consultas.dto.*;
import med.voli.api.domain.consultas.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultaController {
    @Autowired
    private AgendaDeConsultas agendaDeConsultas;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsultaDTO dados) {
        agendaDeConsultas.agendar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConsultaDTO(null, null, null, null));
    }
    
    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsultaDto dados){
        agendaDeConsultas.cancelar(dados);
        return ResponseEntity.noContent().build();
    }

}
