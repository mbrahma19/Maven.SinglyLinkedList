package com.zipcodewilmington.singlylinkedlist;


/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable> {

    private Node<T> HEAD;

    public SinglyLinkedList() {
        HEAD = null;
    }

    public SinglyLinkedList(Node<T> head) {
        HEAD = head;
    }

    public Node<T> getHead() {
        return HEAD;
    }

    public void setHead(Node<T> newHead) {
        if(HEAD != null){
            newHead.setNext(HEAD.getNext());
            HEAD.setNext(null);
            this.HEAD = newHead;
        }else {
            this.HEAD = newHead;
        }
    }

    public void add(T element) throws UnsupportedOperationException{
        if(element == null){
            throw new UnsupportedOperationException(" Cannot add the specified element. Null is not a valid element");
        }else {
            if (HEAD == null) {
                HEAD = new Node(element);
            } else {
                Node<T> temp = HEAD;
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                }
                temp.setNext(new Node<>(element));
            }
        }
    }

    public void remove(T element) throws UnsupportedOperationException {
        Integer flag = find(element);
        if (flag < 0) {
            throw new UnsupportedOperationException(" Cannot remove the specified element. Element does not exist in list.");
        } else if (flag.equals(0)) {
            this.HEAD = HEAD.getNext();
        }else if (flag.equals(size()-1)){
            this.get(flag-2).setNext(null);
        }else{
            this.get(flag-1).setNext(get(flag+1));
        }
    }

    public Boolean contains(T element) {
        boolean result = false;
        Node<T> temp = HEAD;
        while(temp != null){
            if(temp.getData().equals(element)){
                result = true;
                break;
            }else{
                temp = temp.getNext();
            }
        }
        return result;
    }

    public Integer find(T element) {
        Integer result = -1;
        if(contains(element)){
            result = 0;
            Node<T> temp = HEAD;
            while(!temp.getData().equals(element)){
                temp = temp.getNext();
                result++;
            }
        }
        return result;
    }

    public Integer size() {
        Integer counter = 0;
        if(HEAD != null){
            Node<T> temp = HEAD;
            counter++;
            while (temp.hasNext()) {
                temp = temp.getNext();
                counter++;
            }
        }
        return counter;
    }

    public Node<T> get(Integer index) {
        int counter = 0;
        Node<T> temp = HEAD;
        while (counter < index && temp.getNext() != null) {
            counter++;
            temp = temp.getNext();
        }
        return temp;
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> newList = new SinglyLinkedList<>();
        Node<T> temp = HEAD;
        while(temp != null){
            newList.add(temp.getData());
            temp = temp.getNext();
        }
        return newList;
    }

    public void sort() {

    }

    //TODO:
    public void reverse() {

    }

    //TODO:
    public SinglyLinkedList<T> slice(Integer start, Integer stop) {
        return null;
    }


}
