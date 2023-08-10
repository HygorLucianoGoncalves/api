package med.voli.api.dto;

import med.voli.api.endecos.Endereco;
import med.voli.api.medico.Especialidade;
import med.voli.api.medico.Medico;

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
