package med.voli.api.domain.consultas.service;

import med.voli.api.domain.consultas.dto.*;
import med.voli.api.domain.consultas.entity.*;
import med.voli.api.domain.consultas.exception.ValidacaoException;
import med.voli.api.domain.consultas.repository.*;
import med.voli.api.domain.medicos.entity.*;
import med.voli.api.domain.medicos.repository.*;
import med.voli.api.domain.paciente.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class AgendaDeConsultas {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    public void agendar(DadosAgendamentoConsultaDTO dados){
        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("Id do paciente informado não existe!");
        }
        
        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoException("Id do medico informado não existe!");
        }
        
        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);
        
        var consulta = new Consulta(null, medico, paciente, dados.data(),null);
        
        consultaRepository.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsultaDTO dados) {
        if(dados.idMedico() != null){
            return medicoRepository.getReferenceById(dados.idMedico());
        }
        if(dados.especialidade() == null){
            throw new ValidacaoException("Especialidade é obrigatória qunado méciso não for escolhido!");
        }
        
        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
        
    }

    public void cancelar(DadosCancelamentoConsultaDto dados) {
        if (!consultaRepository.existsById(dados.idConsulta())){
            throw new ValidacaoException("Id da consulta informado não existe!");
        }
        
        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.moticoCancelamtento());
    }
}
