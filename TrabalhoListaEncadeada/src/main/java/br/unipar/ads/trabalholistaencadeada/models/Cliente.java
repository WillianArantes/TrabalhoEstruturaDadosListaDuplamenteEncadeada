
package br.unipar.ads.trabalholistaencadeada.models;

import java.time.LocalDate;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author willh
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {
    private int codigo;
    private String nome;
    private String dtNasimento;
    private String telefone;

    
    
}
