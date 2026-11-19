package ink.lucasnsnt.exercicio2estruturadedados.service;

import ink.lucasnsnt.exercicio2estruturadedados.models.Piloto;
import ink.lucasnsnt.exercicio2estruturadedados.reader.PilotoTxtReader;
import ink.lucasnsnt.exercicio2estruturadedados.sorting.InsertionSort;
import ink.lucasnsnt.exercicio2estruturadedados.writer.PilotoTxtWriter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ProcessamentoPilotoService {

    private final PilotoTxtReader reader;
    private final PilotoTxtWriter writer;
    private final InsertionSort bubbleSort;

    public ProcessamentoPilotoService(PilotoTxtReader reader,
                                      PilotoTxtWriter writer,
                                      InsertionSort bubbleSort) {
        this.reader = reader;
        this.writer = writer;
        this.bubbleSort = bubbleSort;

    }

    public void processarArquivo(InputStream inputStream) throws IOException {

        List<Piloto> empresas = reader.leituraArquivo(inputStream);
        bubbleSort.sort(empresas);
        writer.write(empresas);

    }

}
