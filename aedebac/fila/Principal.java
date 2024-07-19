package fila;

public class Principal {
    public static void main(String[] args) {
        Fila fila = new Fila();

        // Adicionando elementos à fila
        for (int i = 1; i <= 5; i++) {
            fila.enqueue(i);
        }

        // Imprimindo a fila inicial
        fila.printarFila();
        System.out.println("Tamanho inicial: " + fila.size());

        // Removendo dois elementos da fila
        System.out.println("Removendo o elemento " + fila.dequeue());
        System.out.println("Removendo o elemento " + fila.dequeue());
        System.out.println();

        // Imprimindo a fila após remoção
        fila.printarFila();

        // Mostrando o elemento da frente e do final da fila
        System.out.println("Novo elemento da frente: " + fila.front());
        System.out.println("Novo elemento do final: " + fila.rear());

        // Esvaziando a fila
        System.out.println("Esvaziando a fila: ");
        while (!fila.isEmpty()) {
            System.out.println("Removendo o elemento " + fila.dequeue());
        }
        System.out.println("Está vazia: " + fila.isEmpty());
    }
}
