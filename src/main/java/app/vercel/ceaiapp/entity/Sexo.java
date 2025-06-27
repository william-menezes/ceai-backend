package app.vercel.ceaiapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sexo {
    F(1, "FEMININO"),
    M(2, "MASCULINO");

    private final int valor;
    private final String descricao;
}
