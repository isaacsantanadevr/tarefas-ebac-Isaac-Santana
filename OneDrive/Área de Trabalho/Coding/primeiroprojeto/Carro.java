package primeiroprojeto;

public class Carro {  //Adicionando as variáveis e valores

    private String marca = "Chevrolet";
    private String modelo =  "Onix";
    private int ano = 2023;
    private String cor = "Branco";

    public Carro(String marca, String modelo, int ano, String cor){ //Construindo classe - Carro
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }

    public void informacoes(){ //Método para obter as características do carro
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Ano: " + this.ano);
        System.out.println("Cor: " + this.cor);
    }
}


