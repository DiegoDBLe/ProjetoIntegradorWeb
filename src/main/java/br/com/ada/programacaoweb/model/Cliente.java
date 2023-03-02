package br.com.ada.programacaoweb.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {

    @Id
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private Instant dataCadastro;
}
