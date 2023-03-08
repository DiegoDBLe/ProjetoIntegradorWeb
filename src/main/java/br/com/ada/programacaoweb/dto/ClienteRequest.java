package br.com.ada.programacaoweb.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class ClienteRequest {

    private String nome;
    private String telefone;
    private String email;
    private Instant dataCadastro;
}
