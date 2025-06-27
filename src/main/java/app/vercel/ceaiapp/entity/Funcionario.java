package app.vercel.ceaiapp.entity;

import app.vercel.ceaiapp.dto.FuncionarioDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@Builder
@Entity
@Table(name = "funcionario")
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Long id;

    @Valid
    @Embedded
    private Pessoa pessoa;
    private String matricula;
    private String escolaridade;
    private String cargo;
    private String funcao;
    private String vinculo;
    private String empresa;

    @Column(name = "data_admissao")
    @JsonFormat(pattern = "dd/MMM/yyyy", shape = JsonFormat.Shape.STRING)

    private LocalDate dataAdmissao;

    @Column(name = "carga_horaria")
    private int cargaHoraria;

    @CreationTimestamp
    @Column(name = "data_criacao", nullable = false, columnDefinition = "datetime")
    private LocalDate dataCriacao;

    @CreationTimestamp
    @Column(name = "data_atualizacao", nullable = false, columnDefinition = "datetime")
    private LocalDate dataAtualizacao;

    public Funcionario(FuncionarioDTO funcionarioDTO) {
        this.pessoa = new Pessoa();
        this.pessoa.setNome(funcionarioDTO.getNome());
        this.pessoa.setSexo(funcionarioDTO.getSexo());
        this.pessoa.setDataNascimento(funcionarioDTO.getDataNascimento());
        this.pessoa.setWhatsapp(funcionarioDTO.getWhatsapp());
        this.pessoa.setTelefone(funcionarioDTO.getTelefone());
        this.pessoa.setRg(funcionarioDTO.getRg());
        this.pessoa.setOrgaoExpedidor(funcionarioDTO.getOrgaoExpedidor());
        this.pessoa.setDataExpedicao(funcionarioDTO.getDataExpedicao());
        this.pessoa.setCpf(funcionarioDTO.getCpf());
        this.pessoa.setMae(funcionarioDTO.getMae());
        this.pessoa.setNaturalidade(funcionarioDTO.getNaturalidade());
        this.pessoa.setEndereco(funcionarioDTO.getEndereco());
        this.matricula = funcionarioDTO.getMatricula();
        this.escolaridade = funcionarioDTO.getEscolaridade();
        this.cargo = funcionarioDTO.getCargo();
        this.funcao = funcionarioDTO.getFuncao();
        this.vinculo = funcionarioDTO.getVinculo();
        this.empresa = funcionarioDTO.getEmpresa();
        this.dataAdmissao = funcionarioDTO.getDataAdmissao();
        this.cargaHoraria = funcionarioDTO.getCargaHoraria();
    }
}
