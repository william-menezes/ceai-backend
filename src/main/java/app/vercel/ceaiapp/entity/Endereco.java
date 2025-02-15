package app.vercel.ceaiapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Table(name = "endereco")
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id")
    private Long id;

    @NotBlank
    @Size(min = 5, max = 255)
    private String logradouro;

    @Positive
    private int numero;

    @Size(max = 100)
    private String complemento;

    @Size(max = 10)
    private String cep;

    @Size(max = 100)
    private String bairro;
}
