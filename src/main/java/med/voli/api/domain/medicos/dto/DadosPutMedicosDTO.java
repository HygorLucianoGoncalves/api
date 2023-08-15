package med.voli.api.domain.medicos.dto;

import jakarta.validation.constraints.NotNull;
import med.voli.api.domain.endecos.dto.DadosEnderecoDTO;

public record DadosPutMedicosDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEnderecoDTO endereco
        
        ){
}
