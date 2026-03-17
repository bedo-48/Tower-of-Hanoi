package towerofhanoi;

import stack.StackInterface;
import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T> {

    private Node topNode;
    private int size;

    public LinkedStack() {
        topNode = null;
        size = 0;
    }

    private class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }


        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }


        public T getData() {
            return data;
        }


        public Node getNextNode() {
            return next;
        }


        public void setNextNode(Node node) {
            this.next = node;
        }
    }

    public int size() {

        return size;
    }


    @Override
    public void clear() {
        // TODO Auto-generated method stub

        topNode = null;
        size = 0;

    }


    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size == 0;

    }


    @Override
    public T peek() {

        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return topNode.getData();
    }


    @Override
    public T pop() {
        
        if(isEmpty()) {
            throw new EmptyStackException();
            
        }
        
        
        T topData = topNode.getData();
        topNode = topNode.getNextNode();
        
        size--;
        
        return topData;
    }


    @Override
    public void push(T anEntry) {

        Node newNode = new Node(anEntry);

        newNode.setNextNode(topNode);

        topNode = newNode;

        size++;

    }
}
