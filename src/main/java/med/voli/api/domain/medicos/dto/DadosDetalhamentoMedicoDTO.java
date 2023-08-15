package med.voli.api.domain.medicos.dto;

import med.voli.api.domain.medicos.entity.Especialidade;
import med.voli.api.domain.endecos.entity.Endereco;
import med.voli.api.domain.medicos.entity.Medico;

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
