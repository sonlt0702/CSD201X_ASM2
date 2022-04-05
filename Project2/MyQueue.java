package Project2;

import java.io.PrintStream;
import java.util.EmptyStackException;

public class MyQueue extends SavePrint {
    private Node head;
    private Node tail;

    public MyQueue() {
        this.head = null;
        this.tail = null;
    }

    public void clear() {
        this.head = this.tail = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public Product front() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.head.getInfo();
    }

    public Product dequeue() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        Product p = this.head.getInfo();
        this.head = this.head.getNextNode();
        if (this.head == null) {
            tail = null;
        }
        return p;
    }

    public void enqueue(Product info) {
        Node newNode = new Node(info);
        if (this.isEmpty()) {
            this.head = this.tail = newNode;
        } else {
            this.tail.setNextNode(newNode);
            this.tail = newNode;
        }
    }

    public void display(PrintStream old) {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        Node current = this.head;
        while (current != null) {
            savePrintln(old, current.toString());
            current = current.getNextNode();
        }
    }
}
