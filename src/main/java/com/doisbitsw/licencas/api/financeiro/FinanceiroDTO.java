package com.doisbitsw.licencas.api.financeiro;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class FinanceiroDTO {
    private Long id;
    private String code;
    private String codeProcesso;
    private Long empreendimento;
    private Double valor;
    private String situacao;
    private String imagem;
    private Boolean ativo;
    private String created;
    private String modified;
    //query
    private String nome;
    private String fase;
    private String cpf;
    private String celular;
    private String logradouro;
    private String numero;
    private String bairro;
    private Double quantidade;
    private String unidade;
    private String caracterizacao;
    private String atividade;
    private Boolean certidao;




    public static FinanceiroDTO create(Financeiro financeiro) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(financeiro, FinanceiroDTO.class);
    }
}
