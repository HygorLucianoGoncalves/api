package med.voli.api.domain.consultas.validacao.agendamento;

import med.voli.api.domain.consultas.dto.agendamento.*;
import med.voli.api.domain.consultas.exception.*;
import org.springframework.stereotype.*;

import java.time.*;
@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {
    public void validar(DadosAgendamentoConsultaDTO dados){
        var dataConsulta = dados.data();
        
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;
        if (domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica){
            throw new ValidacaoException("Consulta fora do horario de funcionamento da clinica");
        }
    }
}
