package com.zipcodewilmington.singlylinkedlist;

public class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T element, Node next){
        data = element;
        this.next = next;
    }

    public Node(T element){
        this(element,null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
