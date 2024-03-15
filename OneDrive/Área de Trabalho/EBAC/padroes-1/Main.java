public class Main {
    public static void main(String[] args) {
        Cliente cliente_contrato = new Cliente("A", false);

        Fabrica fabrica = receberTipoFabrica(cliente_contrato);
        Carro carro = fabrica.criar(cliente_contrato.getTipo());
        carro.Ligar();
        
    }

    private static Fabrica receberTipoFabrica(Cliente cliente){
        if(cliente.isContrato()){
            return new FabricaCliente();
        }
        else{
            return new FabricaNao();
        }
    }
}
