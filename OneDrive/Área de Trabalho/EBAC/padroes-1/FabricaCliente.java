public class FabricaCliente extends Fabrica{
    Carro recuperarCarro(String tipo){
        switch (tipo){
            case "A":
                return new Tesla(1000, "cheio", "preto");
            case "B":
                return new Ferrari(1400, "cheio", "vermelho");
            default:
                System.out.println("Escolha inválida!");
                return null;
        }
    }
}
