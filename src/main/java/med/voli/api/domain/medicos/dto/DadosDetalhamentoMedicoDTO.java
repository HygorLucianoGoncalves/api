package med.voli.api.domain.medicos.dto;

import med.voli.api.domain.medicos.entities.Especialidade;
import med.voli.api.domain.medicos.endecos.Endereco;
import med.voli.api.domain.medicos.entities.Medico;

public record DadosDetalhamentoMedicoDTO(
        Long id,
        String nome,
        String email,
        String crm,
        String telefone, 
        Especialidade especialidade,
        Endereco endereco
) {
    public DadosDetalhamentoMedicoDTO(Medico medico) {
        this(
                medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getTelefone(),
                medico.getEspecialidade(),
                medico.getEndereco()
        );
    }
}
