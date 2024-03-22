package TarefaEbac;

public class Main {
    public static void main(String[] args) {
        TodosCarros<Carros> carros = new TodosCarros<>();

        carros.add(new Ferrari("Isaac", "296GTB", "2024"));
        carros.add(new Fiat("Joao", "São Paulo", "12345"));
        carros.add(new Toyota("Marcos", "180 km/h", "Azul"));

        carros.listar();
    }
}
