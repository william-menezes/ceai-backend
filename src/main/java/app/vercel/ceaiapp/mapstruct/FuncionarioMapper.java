package app.vercel.ceaiapp.mapstruct;

import app.vercel.ceaiapp.dto.FuncionarioDTO;
import app.vercel.ceaiapp.dto.FuncionarioResumoDTO;
import app.vercel.ceaiapp.entity.Funcionario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {

    //@Mapping(target = "id", ignore = true)
    @Mapping(source = "nome", target = "pessoa.nome")
    @Mapping(source = "sexo", target = "pessoa.sexo")
    @Mapping(source = "dataNascimento", target = "pessoa.dataNascimento")
    @Mapping(source = "whatsapp", target = "pessoa.whatsapp")
    @Mapping(source = "telefone", target = "pessoa.telefone")
    @Mapping(source = "endereco", target = "pessoa.endereco")
    @Mapping(source = "rg", target = "pessoa.rg")
    @Mapping(source = "orgaoExpedidor", target = "pessoa.orgaoExpedidor")
    @Mapping(source = "dataExpedicao", target = "pessoa.dataExpedicao")
    @Mapping(source = "cpf", target = "pessoa.cpf")
    @Mapping(source = "mae", target = "pessoa.mae")
    @Mapping(source = "naturalidade", target = "pessoa.naturalidade")
    Funcionario funcionarioDTOParaFuncionario(FuncionarioDTO funcionarioDTO);

    @Mapping(source = "pessoa.nome", target = "nome")
    @Mapping(source = "pessoa.sexo", target = "sexo")
    @Mapping(source = "pessoa.dataNascimento", target = "dataNascimento")
    @Mapping(source = "pessoa.whatsapp", target = "whatsapp")
    @Mapping(source = "pessoa.telefone", target = "telefone")
    @Mapping(source = "pessoa.endereco", target = "endereco")
    @Mapping(source = "pessoa.rg", target = "rg")
    @Mapping(source = "pessoa.orgaoExpedidor", target = "orgaoExpedidor")
    @Mapping(source = "pessoa.dataExpedicao", target = "dataExpedicao")
    @Mapping(source = "pessoa.cpf", target = "cpf")
    @Mapping(source = "pessoa.mae", target = "mae")
    @Mapping(source = "pessoa.naturalidade", target = "naturalidade")
    FuncionarioDTO funcionarioParaFuncionarioDTO(Funcionario funcionario);

    @Mapping(source = "pessoa.nome", target = "nome")
    FuncionarioResumoDTO funcionarioParaFuncionarioResumoDTO(Funcionario funcionario);
}
