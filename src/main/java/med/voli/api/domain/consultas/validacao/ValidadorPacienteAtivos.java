package med.voli.api.domain.consultas.validacao;

import med.voli.api.domain.consultas.dto.*;
import med.voli.api.domain.consultas.exception.*;
import med.voli.api.domain.paciente.repository.*;

public class ValidadorPacienteAtivos {
   
    private PacienteRepository pacienteRepository;
    public void validar(DadosAgendamentoConsultaDTO dados){
        var pacineteAtivo = pacienteRepository.findAtivoById(dados.idPaciente());
        if (!pacineteAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluido ");
        }
    }
}
