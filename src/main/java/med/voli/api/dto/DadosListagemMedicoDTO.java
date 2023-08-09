package med.voli.api.dto;

import med.voli.api.medico.Especialidade;
import med.voli.api.medico.Medico;

public record DadosListagemMedicoDTO(Long id, String nome, String email, String crm, Especialidade especialidade)  {
    public DadosListagemMedicoDTO(Medico medico){
        this(medico.getId(),medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
