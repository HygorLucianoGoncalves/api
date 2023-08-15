package med.voli.api.domain.medicos.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import med.voli.api.domain.endecos.dto.DadosEnderecoDTO;
import med.voli.api.domain.medicos.entity.Especialidade;

public record DadosCadastroMedicoDTO(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid
        DadosEnderecoDTO endereco
) {}
