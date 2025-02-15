package app.vercel.ceaiapp.dto;

public record EnderecoDTO(String logradouro,
                          int numero,
                          String complemento,
                          String cep,
                          String bairro) {
}
