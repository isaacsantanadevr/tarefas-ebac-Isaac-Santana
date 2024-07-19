package fila;

import java.util.NoSuchElementException;

public class Fila implements IFila{

  private Node front, rear;
  private int size;

  @Override
  public void enqueue(int num) {
    Node novoNo = new Node(num);
    if(rear != null){
      rear.setNext(novoNo);
    }
    rear = novoNo;
    if(front == null){
      front = rear;
    }
    size++;
  }

  @Override
  public int dequeue() {
    if(isEmpty()){
      throw new NoSuchElementException();
    }
    int valor = front.getValor();
    front = front.getNext();
    size--;
    return valor;
  }

  @Override
  public int rear() {
    return rear.getValor();
  }

  @Override
  public int front() {
    return front.getValor();
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    if(front == null && rear == null){
      return true;
    }
    return false;
  }

  @Override
  public void printarFila() {
    Node atual = front;
    while(atual != null){
      System.out.println(atual.getValor());
      atual = atual.getNext();
    }
  }
}
