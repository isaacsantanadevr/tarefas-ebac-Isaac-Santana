package TarefaEbac;

public class Toyota extends Carros{
    private String velocidade;
    private String cor;

    public Toyota(String dono, String velocidade, String cor){
        super(dono);
        this.velocidade = velocidade;
        this.cor = cor;
    }

    public String getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(String velocidade) {
        this.velocidade = velocidade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String toString(){
        return "Dono: " + dono + " Velocidade: " + velocidade + " Cor: " + cor;
    }

}
