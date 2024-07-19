package listaencadeada;

public class Principal {
    public static void main(String[] args) {
        Lista lista = new Lista();

        // Adicionando elementos à lista
        lista.push(10);
        lista.push(20);
        lista.push(30);

        // Imprimindo a lista
        System.out.print("Lista: ");
        lista.printList(); // Saída: Lista: 30 20 10 

        // Inserindo elementos na lista
        lista.insert(1, 15);
        System.out.print("Lista após inserção: ");
        lista.printList(); // Saída: Lista após inserção: 30 15 20 10 

        // Removendo um elemento da lista
        lista.remove(2);
        System.out.print("Lista após remoção: ");
        lista.printList(); // Saída: Lista após remoção: 30 15 10 

        // Acessando um elemento na lista
        System.out.println("Elemento no índice 1: " + lista.elementAt(1).getValor()); // Saída: Elemento no índice 1: 15

        // Tamanho da lista
        System.out.println("Tamanho da lista: " + lista.size()); // Saída: Tamanho da lista: 3

        // Removendo todos os elementos da lista
        System.out.println("Esvaziando a lista: ");
        while (!lista.isEmpty()) {
            System.out.println("Removendo: " + lista.pop());
        }
        System.out.println("Está vazia: " + lista.isEmpty()); // Saída: Está vazia: true
    }
}
