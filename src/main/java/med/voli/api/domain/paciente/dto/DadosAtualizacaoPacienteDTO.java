package med.voli.api.domain.paciente.dto;

import jakarta.validation.constraints.NotNull;
import med.voli.api.domain.endecos.dto.DadosEnderecoDTO;

public record DadosAtualizacaoPacienteDTO(@NotNull
                                          Long id,
                                          String nome,
                                          String telefone,
                                          DadosEnderecoDTO endereco) {
}
