package ink.lucasnsnt.exercicio2estruturadedados.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Empresa {
    private String nomeFantasia;

    private String inscricaoEstadual;

    private BigDecimal valorDeMercado;

   private BigDecimal converteBigDecimal(String valor) {
       return new BigDecimal(valor);
   }
}
