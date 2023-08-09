package med.voli.api.dto;

import med.voli.api.medico.Especialidade;
import med.voli.api.medico.Medico;

public record DadosListagemMedicoDto(String nome, String email, String crm, Especialidade especialidade)  {
    public DadosListagemMedicoDto(Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
