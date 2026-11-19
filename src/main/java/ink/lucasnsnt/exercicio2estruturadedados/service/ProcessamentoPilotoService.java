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
    private final InsertionSort insertionSort;

    public ProcessamentoPilotoService(PilotoTxtReader reader,
                                      PilotoTxtWriter writer,
                                      InsertionSort insertionSort) {
        this.reader = reader;
        this.writer = writer;
        this.insertionSort = insertionSort;

    }

    public void processarArquivo(InputStream inputStream) throws IOException {

        List<Piloto> pilotos = reader.leituraArquivo(inputStream);
        insertionSort.sort(pilotos);
        writer.write(pilotos);

    }

}
