package med.voli.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import med.voli.api.endecos.DadosEndereco;
import med.voli.api.medico.Especialidade;

public record DadosCadastroMedicoDto(
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
        DadosEndereco endereco
) {}
