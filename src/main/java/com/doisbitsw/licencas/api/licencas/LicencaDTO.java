package com.doisbitsw.licencas.api.licencas;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class LicencaDTO {
    private Long id;
    private String nome;
    private String tipo;




    public static LicencaDTO create(Licenca licenca) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(licenca, LicencaDTO.class);
    }
}
