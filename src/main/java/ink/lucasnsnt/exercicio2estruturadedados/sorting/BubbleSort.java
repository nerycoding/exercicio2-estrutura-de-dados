package ink.lucasnsnt.exercicio2estruturadedados.sorting;

import ink.lucasnsnt.exercicio2estruturadedados.models.Empresa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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
