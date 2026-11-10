package ink.lucasnsnt.exercicio2estruturadedados.service;

import ink.lucasnsnt.exercicio2estruturadedados.models.Empresa;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Component
public class ConverteEmpresa {

    public Empresa converteLinha(String linha) {
        List<String> dadosEmpresa = Arrays.stream(linha.split("\\|"))
                .map(String::trim).toList();

        BigDecimal valorDeMercado = new BigDecimal(dadosEmpresa.get(2));

        return new Empresa(
                dadosEmpresa.getFirst(),
                dadosEmpresa.get(1), valorDeMercado);
    }
}
