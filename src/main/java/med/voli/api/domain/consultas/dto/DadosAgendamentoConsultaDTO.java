package med.voli.api.domain.consultas.dto;

import jakarta.validation.constraints.*;
import med.voli.api.domain.medicos.entity.*;

import java.time.*;

public record DadosAgendamentoConsultaDTO(
        Long idMedico,
        @NotNull
        Long idPaciente,
        @NotNull
        @Future
        LocalDateTime data,
        Especialidade especialidade
) {
}
