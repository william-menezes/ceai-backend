package app.vercel.ceaiapp.dto;

import app.vercel.ceaiapp.entity.Endereco;
import app.vercel.ceaiapp.entity.Sexo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;

import java.time.Instant;
import java.time.LocalDate;


public record FuncionarioDTO(

        Long id,

        @NotBlank(message = "Campo obrigatório")
        @Size(max = 255)
        String nome,

        @NotNull(message = "Campo obrigatório")
        @Enumerated(EnumType.STRING)
        Sexo sexo,

        @NotNull(message = "Campo obrigatório")
        @Past(message = "Data igual ou posterior a data atual")
        LocalDate dataNascimento,

        @Size(max = 16, message = "O número de telefone deve ter no máximo 16 caracteres")
        String whatsapp,

        @Size(max = 16, message = "O número de telefone deve ter no máximo 16 caracteres")
        String telefone,
        Endereco endereco,

        @Size(max = 45, message = "O número do RG deve ter no máximo 45 caracteres")
        String rg,

        @Size(max = 10, message = "O órgão expedidor deve ter no máximo 10 caracteres")
        String orgaoExpedidor,

        @PastOrPresent(message = "A data de expedição deve ser igual ou anterior à data atual")
        LocalDate dataExpedicao,

        @NotBlank(message = "Campo obrigatório")
        @Size(max = 14)
        String cpf,

        @Size(max = 255)
        String mae,

        @Size(max = 100)
        String naturalidade,

        @Size(max = 8)
        String matricula,

        @Size(max = 45)
        String escolaridade,

        @Size(max = 45)
        String cargo,

        @Size(max = 45)
        String funcao,

        @Size(max = 45)
        String vinculo,

        @Size(max = 45)
        String empresa,

        @PastOrPresent
        LocalDate dataAdmissao,

        @Positive
        int cargaHoraria,

        Instant dataCriacao,

        Instant dataAtualizacao
) {
}

