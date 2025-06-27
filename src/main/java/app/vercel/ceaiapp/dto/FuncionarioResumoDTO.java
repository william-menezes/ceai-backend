package app.vercel.ceaiapp.dto;

import app.vercel.ceaiapp.entity.Funcionario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioResumoDTO {
    private Long id;
    private String nome;
    private String matricula;
    private String cargo;
    private String funcao;
    private String vinculo;
    private String empresa;

    public FuncionarioResumoDTO(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getPessoa().getNome();
        this.matricula = funcionario.getMatricula();
        this.cargo = funcionario.getCargo();
        this.funcao = funcionario.getFuncao();
        this.vinculo = funcionario.getVinculo();
        this.empresa = funcionario.getEmpresa();

    }
}
