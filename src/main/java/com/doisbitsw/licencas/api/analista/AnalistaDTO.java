package com.doisbitsw.licencas.api.analista;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class AnalistaDTO {
    private Long id;
    private String conselho;
    private String registro;
    private String titulo;

    public static AnalistaDTO create(Analista analista) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(analista, AnalistaDTO.class);
    }
}
