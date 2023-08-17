package med.voli.api.domain.consultas.validacao.agendamento;

import med.voli.api.domain.consultas.dto.agendamento.*;
import med.voli.api.domain.consultas.exception.*;
import med.voli.api.domain.medicos.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class ValidadorMedidoAtivo implements ValidadorAgendamentoDeConsulta {
    @Autowired
    private MedicoRepository medicoRepository;
    public void validar(DadosAgendamentoConsultaDTO dados){
        //ser a escolha for medico opcional
        if(dados.idMedico() ==null){
            return;
        }
        var MedicoEstaAtivo = medicoRepository.findAtivoById(dados.idMedico());
        if (!MedicoEstaAtivo) throw new ValidacaoException("Consulta não pode ser agendada com o medico ocupado");
    }
}
