package fila;

public interface IFila {
  void enqueue(int num); //add elemento
  int dequeue(); //remove elemento
  int rear(); //retorna elemento do fim
  int front(); //retorna elemento do inicio
  int size(); //retorna tamanho da fila
  boolean isEmpty(); //retorna true ou false indicando estado da fila
  void printarFila(); //printarFila
}
