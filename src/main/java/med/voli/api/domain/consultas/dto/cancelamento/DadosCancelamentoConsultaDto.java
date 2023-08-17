package med.voli.api.domain.consultas.dto.cancelamento;

import jakarta.validation.constraints.*;
import med.voli.api.domain.consultas.enums.*;

public record DadosCancelamentoConsultaDto(
        @NotNull
        Long idConsulta,

        @NotNull
        MotivoCancelamento motivo) {
}
