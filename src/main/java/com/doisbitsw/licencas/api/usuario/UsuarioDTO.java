package com.doisbitsw.licencas.api.usuario;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private String urlFoto;
    private Long cpf;
    private Long recuperar;
    private String celular;
    private String role;
    private Boolean ativo;
    private String created;
    private Boolean modified;



    public static UsuarioDTO create(Usuario usuario) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usuario, UsuarioDTO.class);
    }
}
