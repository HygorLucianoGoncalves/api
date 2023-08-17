package med.voli.api.domain.consultas.validacao.agendamento;

import med.voli.api.domain.consultas.dto.agendamento.*;
import med.voli.api.domain.consultas.exception.*;
import med.voli.api.domain.paciente.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class ValidadorPacienteAtivos implements ValidadorAgendamentoDeConsulta{
    @Autowired
    private PacienteRepository pacienteRepository;
    public void validar(DadosAgendamentoConsultaDTO dados){
        var pacineteAtivo = pacienteRepository.findAtivoById(dados.idPaciente());
        if (!pacineteAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluido ");
        }
    }
}
