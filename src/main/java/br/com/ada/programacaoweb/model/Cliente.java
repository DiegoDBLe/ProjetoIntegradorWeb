package br.com.ada.programacaoweb.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {

    @Id
    private String id;
    private String nome;
    private String telefone;
    private String email;
    private Instant dataCadastro;
}
