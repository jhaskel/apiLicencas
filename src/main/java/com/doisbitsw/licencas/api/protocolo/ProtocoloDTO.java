package com.doisbitsw.licencas.api.protocolo;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ProtocoloDTO {
    private Long id;
    private String code;
    private Long empreendedor;
    private Long empreendimento;
    private String descricao;
    private String created;



    public static ProtocoloDTO create(Protocolo protocolo) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(protocolo, ProtocoloDTO.class);
    }
}
