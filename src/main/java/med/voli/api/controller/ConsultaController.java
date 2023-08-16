package med.voli.api.controller;

import jakarta.validation.*;
import med.voli.api.domain.consultas.dto.*;
import org.springframework.http.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultaController {
    
    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsultaDTO dados){
        System.out.println(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConsultaDTO(null,null,null,null));
    }
    
}
