package med.voli.api.domain.medicos.dto;

import jakarta.validation.constraints.NotNull;

public record DadosPutMedicosDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEnderecoDTO endereco
        
        ){
}
