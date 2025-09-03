package app.vercel.ceaiapp.mapstruct;

import app.vercel.ceaiapp.dto.EnderecoDTO;
import app.vercel.ceaiapp.entity.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    //@Mapping(target = "id", ignore = true)
    Endereco enderecoDTOParaEndereco(EnderecoDTO enderecoDTO);

    EnderecoDTO endercoParaEnderecoDTO(Endereco endereco);

    List<EnderecoDTO> listaEnderecoParaListaEnderecoDTO(List<Endereco> lista);
}
