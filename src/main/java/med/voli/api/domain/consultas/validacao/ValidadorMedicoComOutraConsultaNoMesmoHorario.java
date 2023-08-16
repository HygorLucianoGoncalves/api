package med.voli.api.domain.consultas.validacao;

import med.voli.api.domain.consultas.dto.*;
import med.voli.api.domain.consultas.exception.*;
import med.voli.api.domain.consultas.repository.*;

public class ValidadorMedicoComOutraConsultaNoMesmoHorario {
    
    private ConsultaRepository consultaRepository;
    
    public void validar(DadosAgendamentoConsultaDTO dados){
        var medicoPossuiOutraConsultaNoMesmoHorario = consultaRepository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario){
            throw new ValidacaoException("Paciente já possui uma consulta agendada nesse dia");
        }
    }
}
