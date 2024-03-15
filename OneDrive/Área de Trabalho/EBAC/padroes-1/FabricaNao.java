public class FabricaNao extends Fabrica{
    Carro recuperarCarro(String tipo){
        switch (tipo){
            case "A":
                return new Caoa(800, "cheio", "azul");
            case "B":
                return new Chevrolet(500, "cheio", "branco");
            default:
                System.out.println("Escolha inválida!");
                return null;
        }
    }
}
