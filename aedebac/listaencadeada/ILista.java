package listaencadeada;

public interface ILista {
  void push(int num);
  int pop();
  void insert(int index, int num);
  void remove(int index);
  Node elementAt(int index);
  int size();
  void printList();
}
