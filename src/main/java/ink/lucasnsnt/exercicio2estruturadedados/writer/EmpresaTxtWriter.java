package ink.lucasnsnt.exercicio2estruturadedados.writer;

import ink.lucasnsnt.exercicio2estruturadedados.models.Empresa;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
public class EmpresaTxtWriter {


    public void write(List<Empresa> empresa) throws IOException {

        try (BufferedWriter writer = Files
                .newBufferedWriter(Path.of("empresa-ordenada.txt"), StandardCharsets.UTF_8)) {

            for (Empresa emp : empresa) {

                writer.write
                        (emp.getNomeFantasia()
                                + " | " + emp.getInscricaoEstadual()
                                + " | " + emp.getValorDeMercado());
                writer.newLine();

            }

        }
    }
}