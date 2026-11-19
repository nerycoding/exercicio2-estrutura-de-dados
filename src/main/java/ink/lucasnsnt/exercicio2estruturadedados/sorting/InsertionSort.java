package ink.lucasnsnt.exercicio2estruturadedados.sorting;

import ink.lucasnsnt.exercicio2estruturadedados.models.Empresa;
import ink.lucasnsnt.exercicio2estruturadedados.models.Piloto;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component
public class InsertionSort {

    public void sort(List<Piloto> voltas) {

        for (int i = 1; i < voltas.size(); i++) {

            int j = i - 1;

            Piloto key = voltas.get(i);

            while (j >=0 &&
                    (voltas.get(j).getTempo().compareTo(key.getTempo()) > 0
                            || (voltas.get(j).getTempo().compareTo(key.getTempo()) == 0
                            && voltas.get(j).getNome().compareTo(key.getNome()) > 0))) {

                voltas.set(j + 1, voltas.get(j));
                j =  j - 1;

            }

            voltas.set(j + 1, key);

        }
    }

}
