package br.pucpr.ed.stream;

import br.pucpr.ed.stream.Pessoa;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApp {

    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("João", 23, "Londrina"));
        pessoas.add(new Pessoa("Ricardo", 56, "Londrina"));
        pessoas.add(new Pessoa("Maria", 77, "Curitiba"));
        pessoas.add(new Pessoa("Lucia", 12, "Curitiba"));
        pessoas.add(new Pessoa("Claudia", 65, "Londrina"));
        Map<String, List<Pessoa>> resultado = pessoas.stream()
            .collect(Collectors.groupingBy(Pessoa::getCidade));
        System.out.println();
    }
}
