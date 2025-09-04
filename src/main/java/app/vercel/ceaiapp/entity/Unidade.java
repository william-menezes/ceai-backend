package app.vercel.ceaiapp.entity;

import app.vercel.ceaiapp.dto.UnidadeDTO;
import jakarta.persistence.*;


@Entity
@Table(name = "unidade")

public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unidade")
    private Long id;

    private String nome;
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_funcionario")
    private Funcionario coordenador;

    public Unidade(Long id, String nome, String telefone, Endereco endereco, Funcionario coordenador) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.coordenador = coordenador;
    }

    public Unidade() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Funcionario getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Funcionario coordenador) {
        this.coordenador = coordenador;
    }
}
