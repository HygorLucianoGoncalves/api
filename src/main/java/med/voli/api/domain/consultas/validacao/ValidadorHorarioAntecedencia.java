package med.voli.api.domain.consultas.validacao;

import med.voli.api.domain.consultas.dto.*;
import med.voli.api.domain.consultas.exception.*;

import java.time.*;
import java.time.format.*;

public class ValidadorHorarioAntecedencia {
    
    public void validar(DadosAgendamentoConsultaDTO dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();
        
        if (diferencaEmMinutos< 30){
            throw new ValidacaoException("Consulta deve ser agendada com antecedência minima de 30 minutos");
        }
        
    }
    
}
