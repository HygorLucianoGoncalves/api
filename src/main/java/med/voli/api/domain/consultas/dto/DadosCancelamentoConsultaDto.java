package med.voli.api.domain.consultas.dto;

import jakarta.validation.constraints.*;
import med.voli.api.domain.consultas.enums.*;

public record DadosCancelamentoConsultaDto(
        @NotNull
        Long idConsulta,
        @NotNull
        MotivoCancelamento moticoCancelamtento
) {
}
