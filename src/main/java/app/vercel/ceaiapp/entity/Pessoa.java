package app.vercel.ceaiapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Embeddable
public class Pessoa {

    private String nome;
    private Sexo sexo;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    private String whatsapp;
    private String telefone;
    private String rg;

    @Column(name = "orgao_expedidor")
    private String orgaoExpedidor;

    @Column(name = "data_expedicao")
    private LocalDate dataExpedicao;

    @Column(unique = true)
    private String cpf;
    private String mae;
    private String naturalidade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    public Pessoa(String nome, Sexo sexo, LocalDate dataNascimento, String whatsapp, String telefone, String rg, String orgaoExpedidor, LocalDate dataExpedicao, String cpf, String mae, String naturalidade, Endereco endereco) {
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.whatsapp = whatsapp;
        this.telefone = telefone;
        this.rg = rg;
        this.orgaoExpedidor = orgaoExpedidor;
        this.dataExpedicao = dataExpedicao;
        this.cpf = cpf;
        this.mae = mae;
        this.naturalidade = naturalidade;
        this.endereco = endereco;
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }

    public void setOrgaoExpedidor(String orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }

    public LocalDate getDataExpedicao() {
        return dataExpedicao;
    }

    public void setDataExpedicao(LocalDate dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
