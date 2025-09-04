package app.vercel.ceaiapp.entity;

public enum Sexo {
    F(1, "FEMININO"),
    M(2, "MASCULINO");

    private final int valor;
    private final String descricao;

    Sexo(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
