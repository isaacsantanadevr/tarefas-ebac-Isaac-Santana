package TarefaEbac;

public class Ferrari extends Carros{
    private String modelo;
    private String ano;

    public Ferrari(String dono, String modelo, String ano){
        super(dono);
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String toString(){
        return "Dono: " + dono + " Modelo: " + modelo + " Ano: " + ano;
    }
}
