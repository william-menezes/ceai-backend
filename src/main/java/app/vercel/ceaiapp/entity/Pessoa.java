package app.vercel.ceaiapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

}
