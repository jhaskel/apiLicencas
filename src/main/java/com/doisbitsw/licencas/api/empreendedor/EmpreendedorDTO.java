package com.doisbitsw.licencas.api.empreendedor;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class EmpreendedorDTO {
    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private String cpf;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private String celular;
    private String created;
    private String modified;

    public static EmpreendedorDTO create(Empreendedor empreendedor) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(empreendedor, EmpreendedorDTO.class);
    }
}
