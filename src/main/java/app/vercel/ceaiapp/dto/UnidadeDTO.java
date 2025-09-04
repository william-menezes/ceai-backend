package app.vercel.ceaiapp.dto;

import app.vercel.ceaiapp.entity.Endereco;
import app.vercel.ceaiapp.entity.Funcionario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UnidadeDTO(

        @NotBlank
        @Size(max = 100)
        String nome,

        @NotBlank
        @Size(max = 16)
        String telefone,

        Endereco endereco,
        Funcionario coordenador
) {
}
