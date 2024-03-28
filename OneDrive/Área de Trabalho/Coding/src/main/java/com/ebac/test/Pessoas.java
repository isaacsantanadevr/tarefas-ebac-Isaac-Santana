package com.ebac.test;

import java.util.List;
import java.util.Objects;

public class Pessoas{

    private int id;
    private String nome;
    private String gen;

    public Pessoas(int id, String nome, String gen){
        this.id = id;
        this.nome = nome;
        this.gen = gen;
    }

    public Pessoas(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public List<Pessoas> ListaDePessoas(){
        Pessoas pessoa1 = new Pessoas(1, "Isaac", "Homem");
        Pessoas pessoa2 = new Pessoas(2, "Luiza", "Mulher");
        Pessoas pessoa3 = new Pessoas(3, "Maria", "Mulher");
        Pessoas pessoa4 = new Pessoas(4, "Joao", "Homem");
        Pessoas pessoa5 = new Pessoas(5, "Joana", "Mulher");

        return List.of(pessoa1, pessoa2, pessoa3, pessoa4, pessoa5);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoas pessoas = (Pessoas) o;
        return id == pessoas.id && Objects.equals(nome, pessoas.nome) && Objects.equals(gen, pessoas.gen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, gen);
    }

    @Override
    public String toString() {
        return "Pessoas{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", gen='" + gen + '\'' +
            '}';
    }
}
