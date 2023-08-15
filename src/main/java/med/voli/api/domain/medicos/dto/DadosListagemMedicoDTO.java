package med.voli.api.domain.medicos.dto;

import med.voli.api.domain.medicos.entity.Especialidade;
import med.voli.api.domain.medicos.entity.Medico;

public record DadosListagemMedicoDTO(Long id, String nome, String email, String crm, Especialidade especialidade)  {
    public DadosListagemMedicoDTO(Medico medico){
        this(medico.getId(),medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
