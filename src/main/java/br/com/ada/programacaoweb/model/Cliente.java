package br.com.ada.programacaoweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class Cliente {

    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private Instant dataCadastro;
}
