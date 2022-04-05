package Project2;

import java.io.PrintStream;
import java.util.EmptyStackException;

public class MyStack extends SavePrint {
    private Node head;

    public MyStack() {
        this.head = null;
    }

    public void clear() {
        this.head = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void push(Product info) {
        this.head = new Node(info, head);
    }

    public Product top() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.head.getInfo();
    }

    public Product pop() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        Product p = this.head.getInfo();
        this.head = this.head.getNextNode();
        return p;
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
