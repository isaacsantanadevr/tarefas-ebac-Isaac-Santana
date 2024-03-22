package TarefaEbac;

public class Fiat extends Carros{
    private String cidade;
    private String n_chassi;

    public Fiat(String dono, String cidade, String n_chassi) {
        super(dono);
        this.cidade = cidade;
        this.n_chassi = n_chassi;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getN_chassi() {
        return n_chassi;
    }

    public void setN_chassi(String n_chassi) {
        this.n_chassi = n_chassi;
    }

    public String toString(){
        return "Dono: " + dono + " Chassi: " + n_chassi + " Cidade: " + cidade;
    }

}
