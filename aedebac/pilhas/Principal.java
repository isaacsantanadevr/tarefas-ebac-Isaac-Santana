package pilhas;

public class Principal {
  public static void main(String[] args) {
    Pilha pilha = new Pilha();

    for(int i = 5; i >= 1; i--){
      pilha.push(i);
    }

    pilha.printarPilha();
    System.out.println("Tamanho inicial: " + pilha.size());

    System.out.println("Removendo o elemento " + pilha.pop());
    System.out.println("Removendo o elemento " + pilha.pop());
    System.out.println();

    pilha.printarPilha();

    System.out.println("Novo elemento do topo: " + pilha.top());

    System.out.println("Esvaziando a pilha: ");
    System.out.println("Removendo o elemento " + pilha.pop());
    System.out.println("Removendo o elemento " + pilha.pop());
    System.out.println("Removendo o elemento " + pilha.pop());
    System.out.println("Está vazia: " + pilha.isEmpty());

  }
}
