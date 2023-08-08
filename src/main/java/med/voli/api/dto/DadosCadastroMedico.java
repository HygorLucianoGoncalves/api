package med.voli.api.dto;

import med.voli.api.endecos.DadosEndereco;
import med.voli.api.medico.Especialidade;

public record DadosCadastroMedico(String nome, String email, String crm,
                                  Especialidade especialidade, DadosEndereco endereco ) {
}
