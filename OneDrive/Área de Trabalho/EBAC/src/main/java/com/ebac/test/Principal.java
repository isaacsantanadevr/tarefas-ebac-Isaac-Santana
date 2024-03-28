package com.ebac.test;

import java.util.List;
import java.util.stream.Collectors;

public class Principal{
    public static void main(String[] args) {
        List<Pessoas> lista = new Pessoas().ListaDePessoas();

        System.out.println("Mulheres: ");

        lista.stream()
            .filter(lista_m -> lista_m.getGen().equals("Mulher"))
            .collect(Collectors.toList())
            .forEach(System.out::println);

        }
    }

