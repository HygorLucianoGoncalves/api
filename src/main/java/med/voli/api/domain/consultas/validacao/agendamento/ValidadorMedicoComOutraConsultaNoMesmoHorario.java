package med.voli.api.domain.consultas.validacao.agendamento;

import med.voli.api.domain.consultas.dto.agendamento.*;
import med.voli.api.domain.consultas.exception.*;
import med.voli.api.domain.consultas.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta {
    @Autowired
    private ConsultaRepository consultaRepository;
    
    public void validar(DadosAgendamentoConsultaDTO dados){
        var medicoPossuiOutraConsultaNoMesmoHorario = consultaRepository. existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario){
            throw new ValidacaoException("Paciente já possui uma consulta agendada nesse dia");
        }
    }
}
