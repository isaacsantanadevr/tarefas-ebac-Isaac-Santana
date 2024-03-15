public class Cliente {
    private String tipo;
    private boolean contrato;

    public Cliente(String tipo, boolean contrato){
        this.tipo = tipo;
        this.contrato = contrato;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isContrato() {
        return contrato;
    }
    
}
