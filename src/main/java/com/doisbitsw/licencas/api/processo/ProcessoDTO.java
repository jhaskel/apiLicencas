package com.doisbitsw.licencas.api.processo;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ProcessoDTO {
    private Long id;
    private String code;
    private String protocolo;
    private Long empreendedor;
    private Long empreendimento;
    private String caracterizacao;
    private String atividade;
    private String fase;
    private Double quantidade;
    private String unidade;
    private String local;
    private Double valor;
    private String status;
    private String obs;
    private String porte;
    private String potencial;
    private String classe;
    private Boolean isfatura_paga;
    private Boolean isemitida;
    private Boolean isisento;
    private Boolean issecundarias;
    private Boolean islicenca;
    private Boolean iscertidao;
    private String created;
    private String modified;
    private Boolean ativo;



    public static ProcessoDTO create(Processo processo) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(processo, ProcessoDTO.class);
    }
}
