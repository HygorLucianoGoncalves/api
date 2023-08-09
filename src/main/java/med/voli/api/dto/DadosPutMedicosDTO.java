package med.voli.api.dto;

import jakarta.validation.constraints.NotNull;

public record DadosPutMedicosDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEnderecoDTO endereco
        
        ){
}
