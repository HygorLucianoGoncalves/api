package med.voli.api.domain.consultas.validacao.agendamento;

import med.voli.api.domain.consultas.dto.agendamento.*;

public interface ValidadorAgendamentoDeConsulta {
    
    void validar(DadosAgendamentoConsultaDTO dados);
}
