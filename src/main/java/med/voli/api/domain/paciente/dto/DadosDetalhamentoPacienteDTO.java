package med.voli.api.domain.paciente.dto;

import med.voli.api.domain.endecos.entity.Endereco;
import med.voli.api.domain.paciente.entity.Paciente;

public record DadosDetalhamentoPacienteDTO(Long id, String nome, String email, String cpf, String telefone, Endereco endereco) {
    public DadosDetalhamentoPacienteDTO(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }
} 
