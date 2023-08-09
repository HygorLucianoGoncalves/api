package med.voli.api.medico;

import jakarta.persistence.*;
import lombok.*;
import med.voli.api.dto.DadosCadastroMedicoDTO;
import med.voli.api.dto.DadosPutMedicosDTO;
import med.voli.api.endecos.Endereco;

@Table(name = "medicos")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    
    @Embedded
    private Endereco endereco;
    
    private Boolean ativo;

    public Medico(DadosCadastroMedicoDTO dados) {
        this.ativo = true;
        this.nome = dados.nome();;
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosPutMedicosDTO dados) {
       if (dados.nome() != null){
           this.nome = dados.nome();
           
       }
        if (dados.telefone() != null){
            this.nome = dados.telefone();

        }
        if (dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());

        }
    }
    
    public void desativar(){
        this.ativo = false;
    }
    
}
