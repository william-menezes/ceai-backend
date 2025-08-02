package app.vercel.ceaiapp.dto;

import app.vercel.ceaiapp.entity.Endereco;
import app.vercel.ceaiapp.entity.Funcionario;
import app.vercel.ceaiapp.entity.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class FuncionarioDTO {
    private Long id;

    @NotBlank(message = "Campo obrigatório")
    @Size(max = 255)
    private String nome;

    @NotNull(message = "Campo obrigatório")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @NotNull(message = "Campo obrigatório")
    @Past(message = "Data igual ou posterior a data atual")
    private LocalDate dataNascimento;

    @Size(max = 16, message = "O número de telefone deve ter no máximo 16 caracteres")
    private String whatsapp;

    @Size(max = 16, message = "O número de telefone deve ter no máximo 16 caracteres")
    private String telefone;
    private Endereco endereco;

    @Size(max = 45, message = "O número do RG deve ter no máximo 45 caracteres")
    private String rg;

    @Size(max = 10, message = "O órgão expedidor deve ter no máximo 10 caracteres")
    private String orgaoExpedidor;

    @PastOrPresent(message = "A data de expedição deve ser igual ou anterior à data atual")
    private LocalDate dataExpedicao;

    @NotBlank(message = "Campo obrigatório")
    @Size(max = 14)
    private String cpf;

    @Size(max = 255)
    private String mae;

    @Size(max = 100)
    private String naturalidade;

    @Size(max = 8)
    private String matricula;

    @Size(max = 45)
    private String escolaridade;

    @Size(max = 45)
    private String cargo;

    @Size(max = 45)
    private String funcao;

    @Size(max = 45)
    private String vinculo;

    @Size(max = 45)
    private String empresa;

    @PastOrPresent
    private LocalDate dataAdmissao;

    @Positive
    private int cargaHoraria;


    private Instant dataCriacao;

    private Instant dataAtualizacao;

    public FuncionarioDTO(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getPessoa().getNome();
        this.sexo = funcionario.getPessoa().getSexo();
        this.dataNascimento = funcionario.getPessoa().getDataNascimento();
        this.whatsapp = funcionario.getPessoa().getWhatsapp();
        this.telefone = funcionario.getPessoa().getTelefone();
        this.endereco = funcionario.getPessoa().getEndereco();
        this.rg = funcionario.getPessoa().getRg();
        this.orgaoExpedidor = funcionario.getPessoa().getOrgaoExpedidor();
        this.dataExpedicao = funcionario.getPessoa().getDataExpedicao();
        this.cpf = funcionario.getPessoa().getCpf();
        this.mae = funcionario.getPessoa().getMae();
        this.naturalidade = funcionario.getPessoa().getNaturalidade();
        this.matricula = funcionario.getMatricula();
        this.escolaridade = funcionario.getEscolaridade();
        this.cargo = funcionario.getCargo();
        this.funcao = funcionario.getFuncao();
        this.vinculo = funcionario.getVinculo();
        this.empresa = funcionario.getEmpresa();
        this.dataAdmissao = funcionario.getDataAdmissao();
        this.cargaHoraria = funcionario.getCargaHoraria();
        this.dataCriacao = funcionario.getDataCriacao();
        this.dataAtualizacao = funcionario.getDataAtualizacao();
    }

    public void setEndereco(Long id) {
        this.endereco.setId(id);
    }
}
