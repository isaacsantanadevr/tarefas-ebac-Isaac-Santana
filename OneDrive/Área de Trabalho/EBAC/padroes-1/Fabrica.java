public abstract class Fabrica{
    public Carro criar(String tipo){
        Carro carro = recuperarCarro(tipo);
        carro = prepararCarro(carro);
        return carro;
    }

    private Carro prepararCarro(Carro carro){
        carro.Limpar();
        carro.Checagem();
        carro.Combustivel();
        return carro;
    }

    abstract Carro recuperarCarro(String tipo);
}