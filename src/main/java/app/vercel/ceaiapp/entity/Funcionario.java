package app.vercel.ceaiapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "funcionario")
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
    private LocalDate dataAdmissao;

    @Column(name = "carga_horaria")
    private int cargaHoraria;

    @CreationTimestamp
    @Column(name = "data_criacao", nullable = false, columnDefinition = "timestamp")
    private Instant dataCriacao;

    @CreationTimestamp
    @Column(name = "data_atualizacao", nullable = false, columnDefinition = "timestamp")
    private Instant dataAtualizacao;

    public Funcionario(Long id, Pessoa pessoa, String matricula, String escolaridade, String cargo, String funcao, String vinculo, String empresa, LocalDate dataAdmissao, int cargaHoraria, Instant dataCriacao, Instant dataAtualizacao) {
        this.id = id;
        this.pessoa = pessoa;
        this.matricula = matricula;
        this.escolaridade = escolaridade;
        this.cargo = cargo;
        this.funcao = funcao;
        this.vinculo = vinculo;
        this.empresa = empresa;
        this.dataAdmissao = dataAdmissao;
        this.cargaHoraria = cargaHoraria;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Funcionario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getVinculo() {
        return vinculo;
    }

    public void setVinculo(String vinculo) {
        this.vinculo = vinculo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Instant dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Instant getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Instant dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
