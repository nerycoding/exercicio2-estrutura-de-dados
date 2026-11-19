package ink.lucasnsnt.exercicio2estruturadedados.writer;

import ink.lucasnsnt.exercicio2estruturadedados.models.Empresa;
import ink.lucasnsnt.exercicio2estruturadedados.models.Piloto;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
public class PilotoTxtWriter {


    public void write(List<Piloto> piloto) throws IOException {

        try (BufferedWriter writer = Files
                .newBufferedWriter(Path.of("voltas-ordenadas.txt"), StandardCharsets.UTF_8)) {

            for (Piloto p : piloto) {

                writer.write
                        (p.getDataHora()
                                + " | " + p.getNome()
                                + " | " + p.getEquipe()
                                + " | " + p.getTempo());
                writer.newLine();

            }

        }
    }
}