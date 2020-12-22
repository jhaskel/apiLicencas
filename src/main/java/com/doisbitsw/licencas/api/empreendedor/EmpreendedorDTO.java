package com.doisbitsw.licencas.api.empreendedor;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class EmpreendedorDTO {
    private Long id;
    private String nome;


    public static EmpreendedorDTO create(Empreendedor empreendedor) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(empreendedor, EmpreendedorDTO.class);
    }
}
