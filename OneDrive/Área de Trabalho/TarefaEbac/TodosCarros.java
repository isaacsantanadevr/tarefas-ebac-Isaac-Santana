package TarefaEbac;

import java.util.ArrayList;

public class TodosCarros<T extends Carros> {
    private ArrayList<T> carros = new ArrayList<>();

    public void add(T carro){
        carros.add(carro);        
    }

    public void remove(T carro){
        carros.add(carro);
    }

    public void listar(){
        for(T carro : carros){
            System.out.println(carro.toString());
        }
    }

}
