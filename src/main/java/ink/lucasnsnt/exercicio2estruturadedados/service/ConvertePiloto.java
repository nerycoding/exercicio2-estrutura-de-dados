package ink.lucasnsnt.exercicio2estruturadedados.service;

import ink.lucasnsnt.exercicio2estruturadedados.models.Empresa;
import ink.lucasnsnt.exercicio2estruturadedados.models.Piloto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Component
public class ConvertePiloto {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    DateTimeFormatter timeFormatter= DateTimeFormatter.ofPattern("HH:mm:ss");

    public Piloto converteLinha(String linha) {
        List<String> dadosPiloto = Arrays.stream(linha.split("\\|"))
                .map(String::trim).toList();

        LocalDateTime data = LocalDateTime.parse(dadosPiloto.get(0), formatter);

        LocalTime tempo = LocalTime.parse(dadosPiloto.get(3), timeFormatter);

        return new Piloto(
                data,
                dadosPiloto.get(1), dadosPiloto.get(2),
                tempo);
    }
}
