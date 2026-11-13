package ink.lucasnsnt.exercicio2estruturadedados.service;

import ink.lucasnsnt.exercicio2estruturadedados.models.Empresa;
import ink.lucasnsnt.exercicio2estruturadedados.reader.EmpresaTxtReader;
import ink.lucasnsnt.exercicio2estruturadedados.sorting.BubbleSort;
import ink.lucasnsnt.exercicio2estruturadedados.writer.EmpresaTxtWriter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ProcessamentoEmpresaService {

    private final EmpresaTxtReader reader;
    private final EmpresaTxtWriter writer;
    private final BubbleSort bubbleSort;

    public ProcessamentoEmpresaService(EmpresaTxtReader reader,
                                       EmpresaTxtWriter writer,
                                       BubbleSort bubbleSort) {
        this.reader = reader;
        this.writer = writer;
        this.bubbleSort = bubbleSort;

    }

    public void processarArquivo(InputStream inputStream) throws IOException {

        List<Empresa> empresas = reader.leituraArquivo(inputStream);
        bubbleSort.sort(empresas);
        writer.write(empresas);

    }

}
