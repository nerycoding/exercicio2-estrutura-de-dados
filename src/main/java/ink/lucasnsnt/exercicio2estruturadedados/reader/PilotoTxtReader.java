package ink.lucasnsnt.exercicio2estruturadedados.reader;

import ink.lucasnsnt.exercicio2estruturadedados.models.Piloto;
import ink.lucasnsnt.exercicio2estruturadedados.service.ConvertePiloto;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PilotoTxtReader {

    private final ConvertePiloto convertePiloto;

    public PilotoTxtReader(ConvertePiloto convertePiloto) {
        this.convertePiloto = convertePiloto;
    }


    public List<Piloto> leituraArquivo(InputStream arquivo) throws IOException {

        InputStreamReader isr = new InputStreamReader(arquivo, StandardCharsets.UTF_8);

        try (BufferedReader br = new BufferedReader(isr)) {
            return br.lines()
                    .map(convertePiloto::converteLinha)
                    .collect(Collectors.toCollection(ArrayList::new));

        }

    }

}
