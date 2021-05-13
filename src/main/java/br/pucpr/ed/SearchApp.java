package br.pucpr.ed;

import br.pucpr.ed.list.List;
import br.pucpr.ed.list.OrderedArrayList;
import br.pucpr.ed.list.UnorderedArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class SearchApp {
    private static final int QUANTIDADE_NUMEROS = 100000;
    private static final int VARIEDADE_NUMEROS = 100000;
    private static final int QUANTIDADE_BUSCAS = 500000;
    private static long start;
    private static long stop;

    public static void main(String[] args) {
        Random random = new Random();
        // Criação de array com $QUANTIDADE_NUMEROS números aleatórios de 0 a $VARIEDADE_NUMEROS.
        int[] numerosGerados = IntStream.generate(() -> random.nextInt(VARIEDADE_NUMEROS)).limit(
            QUANTIDADE_NUMEROS)
            .toArray();
        // Criação do array que obtém $QUANTIDADE_BUSCAS números do array numerosGerados que serão
        // procurados nas listas ordenada e não ordenada.
        int[] numerosParaProcurar = new int[QUANTIDADE_BUSCAS];
        for(int i = 0; i < numerosParaProcurar.length; i++){
            numerosParaProcurar[i] = numerosGerados[random.nextInt(QUANTIDADE_NUMEROS)];
        }

        startTimer();
        List<Integer> numberList = alocacaoArrayNaoOrdenado(numerosGerados);
        stopTimer();

        startTimer();
        buscaSequencial(numberList, numerosParaProcurar);
        stopTimer();

        System.out.println("\n");

        startTimer();
        numberList = alocacaoArrayOrdenado(numerosGerados);
        stopTimer();

        startTimer();
        buscaBinaria(numberList, numerosParaProcurar);
        stopTimer();
    }

    private static List<Integer> alocacaoArrayNaoOrdenado(int[] numbersArray) {
        System.out.println("Alocação Array Não Ordenado");
        List<Integer> numberList = new UnorderedArrayList(QUANTIDADE_NUMEROS);
        for (int i = 0; i < numbersArray.length; i++) {
            numberList.add(numbersArray[i]);
        }
        return numberList;
    }

    private static void buscaSequencial(List<Integer> numberList, int[] numbersToSearch) {
        System.out.println("Busca Sequencial");
        for(int i = 0; i < numbersToSearch.length; i++){
            numberList.exists(numbersToSearch[i]);
        }
    }

    private static List<Integer> alocacaoArrayOrdenado(int[] numbersArray) {
        System.out.println("Alocação Array Ordenado");
        List<Integer> numberList = new OrderedArrayList(QUANTIDADE_NUMEROS);
        for (int i = 0; i < numbersArray.length; i++) {
            numberList.add(numbersArray[i]);
        }
        return numberList;
    }

    private static void buscaBinaria(List<Integer> numberList, int[] numbersToSearch) {
        System.out.println("Busca Binária");
        for(int i = 0; i < numbersToSearch.length; i++){
            numberList.exists(numbersToSearch[i]);
        }
    }

    private static void startTimer(){
        start = System.currentTimeMillis();
    }

    private static void stopTimer(){
        stop = System.currentTimeMillis();
        System.out.println("Duração: " + (stop - start) + " ms.");
    }
}
