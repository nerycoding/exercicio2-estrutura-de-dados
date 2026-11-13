package ink.lucasnsnt.exercicio2estruturadedados.sorting;

import ink.lucasnsnt.exercicio2estruturadedados.models.Empresa;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class BubbleSort {

    public void sort(List<Empresa> empresas) {

        for(int i = 0; i < empresas.size(); i++) {

            for(int j = 1; j < empresas.size() - i; j++) {

                var empresaAnterior = empresas.get(j - 1);
                var empresaAtual = empresas.get(j);

                if (empresaAnterior.getValorDeMercado().compareTo(empresaAtual.getValorDeMercado()) < 0) {
                    empresas.set(j - 1, empresaAtual);
                    empresas.set(j, empresaAnterior);

                }

            }

        }

    }

}
