package med.voli.api.domain.consultas.dto;

import jakarta.validation.constraints.*;

import java.time.*;

public record DadosAgendamentoConsultaDTO(
        Long idMedico,
        @NotNull
        Long idPaciente,
        @NotNull
        @Future
        LocalDateTime data
) {
}
