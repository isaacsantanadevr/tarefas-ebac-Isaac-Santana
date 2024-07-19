package listaencadeada;

import java.util.NoSuchElementException;

public class Lista implements ILista{
    private Node head;
    private int size;

    @Override
    public void push(int num) {
        Node novoNo = new Node(num);
        novoNo.setNext(head);
        head = novoNo;
        size++;
    }

    @Override
    public int pop() {
        if (head == null) throw new NoSuchElementException();
        int valor = head.getValor();
        head = head.getNext();
        size--;
        return valor;
    }

    @Override
    public void insert(int index, int num) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            push(num);
            return;
        }
        Node novoNo = new Node(num);
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        novoNo.setNext(current.getNext());
        current.setNext(novoNo);
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            pop();
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        size--;
    }

    @Override
    public Node elementAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty(){
      if(head == null){
        return true;
      }
      return false;
    }

    @Override
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getValor() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
