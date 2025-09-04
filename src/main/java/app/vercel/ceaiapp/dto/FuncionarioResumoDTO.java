package app.vercel.ceaiapp.dto;

public record FuncionarioResumoDTO(
        String nome,
        String matricula,
        String cargo,
        String funcao,
        String vinculo,
        String empresa
) {
}
