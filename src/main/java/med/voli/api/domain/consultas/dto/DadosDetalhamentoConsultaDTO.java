package med.voli.api.domain.consultas.dto;

import java.time.*;

public record DadosDetalhamentoConsultaDTO(Long id, Long IdMedico, Long idPaciente, LocalDateTime data) {
}
