package med.voli.api.domain.consultas.dto;

import med.voli.api.domain.consultas.entity.*;
import med.voli.api.domain.consultas.enums.MotivoCancelamento;

import java.time.*;

public record DadosDetalhamentoConsultaDTO(Long id, Long IdMedico, Long idPaciente, LocalDateTime data, MotivoCancelamento motivoCancelamento) {
    public DadosDetalhamentoConsultaDTO(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData(), consulta.getMotivoCancelamento());
    }
}
