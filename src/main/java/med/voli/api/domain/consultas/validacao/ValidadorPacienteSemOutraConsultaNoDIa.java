package med.voli.api.domain.consultas.validacao;

import med.voli.api.domain.consultas.dto.*;
import med.voli.api.domain.consultas.exception.*;
import med.voli.api.domain.consultas.repository.*;

public class ValidadorPacienteSemOutraConsultaNoDIa {
    
    private ConsultaRepository consultaRepository;
    
    public void validar(DadosAgendamentoConsultaDTO dados){
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHoraio = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = consultaRepository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHoraio);
        if (pacientePossuiOutraConsultaNoDia){
            throw new ValidacaoException("Paciente já possui uma consulta agendada nesse dia");
        }
    }
    
}
