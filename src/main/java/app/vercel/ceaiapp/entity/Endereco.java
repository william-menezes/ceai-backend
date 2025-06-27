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
    //@Column(name = "endereco_id")
    @Column(name = "id_endereco")
    private Long id;

    @NotBlank(message = "Campo obrigatório")
    @Size(min = 5, max = 255, message = "Campo deve ter no mínimo 5 caracteres")
    private String logradouro;

    @Positive(message = "O número deve ser positivo")
    private int numero;

    @Size(max = 100, message = "Complemento deve ter no máximo 100 caracteres ")
    private String complemento;

    @Size(max = 10, message = "CEP deve ter 10 caracteres")
    private String cep;

    @Size(max = 100)
    private String bairro;
}
