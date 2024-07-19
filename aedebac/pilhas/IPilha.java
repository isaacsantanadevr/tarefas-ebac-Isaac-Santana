package pilhas;

public interface IPilha {
  void push(int num);
  int pop();
  int top();
  boolean isEmpty();
  int size();
  void printarPilha();
}
