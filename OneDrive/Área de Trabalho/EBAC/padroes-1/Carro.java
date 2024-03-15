public abstract class Carro {

    private int Potencia;
    private String Fonte;
    private String Cor;

    public Carro(int Potencia, String Fonte, String Cor){
        this.Potencia = Potencia;
        this.Fonte = Fonte;
        this.Cor = Cor;
    }

    public void Ligar(){
        System.out.println("O mecanismo " + Fonte + " foi iniciada e esta pronta para utilizar " + Potencia + " cavalos!");
    }

    public void Limpar(){
        System.out.println("O carro foi limpo e o " + Cor.toLowerCase() + " brilha");
    }

    public void Checagem(){
        System.out.println("O mecanico verificou o carro e esta tudo certo!");
    }

    public void Combustivel(){
        System.out.println("O carro esta abastecido com " + Fonte.toLowerCase());
    }
}