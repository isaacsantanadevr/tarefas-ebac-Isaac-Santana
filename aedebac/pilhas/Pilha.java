package pilhas;

import java.util.EmptyStackException;

public class Pilha implements IPilha{

  private Node topo;
  private int size;

  @Override
  public void push(int num) {
    Node novoNo = new Node(num);
    novoNo.setNext(topo);
    topo = novoNo;
    size++;
  }

  @Override
  public int pop() {
    if(topo == null){
      throw new EmptyStackException();
    }
    int num = topo.getValor();
    topo = topo.getNext();
    size--;
    return num;
  }

  @Override
  public void printarPilha() {
    Node atual = topo;
    while(atual != null){
      System.out.println(atual.getValor());
      atual = atual.getNext();
    }
    System.out.println();
  }

  @Override
  public int top() {
    int top = topo.getValor();
    return top;
  }

  @Override
  public boolean isEmpty() {
    if(topo == null){
      return true;
    }
    return false;
  }

  @Override
  public int size() {
    return size;
  }
  
}
