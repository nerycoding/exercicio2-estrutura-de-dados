package ink.lucasnsnt.exercicio2estruturadedados.reader;

import ink.lucasnsnt.exercicio2estruturadedados.models.Empresa;
import ink.lucasnsnt.exercicio2estruturadedados.service.ConverteEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
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
public class EmpresaTxtReader {


    private final ConverteEmpresa converteEmpresa;

    public EmpresaTxtReader(ConverteEmpresa converteEmpresa) {
        this.converteEmpresa = converteEmpresa;
    }

    public List<Empresa> leituraArquivo(InputStream arquivo) throws IOException {

        InputStreamReader isr =
                new InputStreamReader(arquivo, StandardCharsets.UTF_8);
        try(BufferedReader br = new BufferedReader(isr)) {
            return br.lines()
                    .map(e -> converteEmpresa.converteLinha(e))
                    .collect(Collectors.toCollection(ArrayList::new));

        }

    }
}
