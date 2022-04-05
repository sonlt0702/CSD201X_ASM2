package Project2;

import java.io.PrintStream;

public class MyList extends SavePrint {
    private Node head;
    private Node tail;

    public MyList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
    }

    public void addHead(Product info) {
        Node newNode = new Node(info);
        if (this.head == null) {
            this.tail = newNode;
        }
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    public void addTail(Product info) {
        Node newNode = new Node(info);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        this.tail.setNextNode(newNode);
        this.tail = newNode;
    }

    public void addPosition(Product info, int position, PrintStream old) {
        if (position < 0 || position >= this.length()) {
            savePrintln(old, "Out of length List!");
            return;
        }
        if (position == 0) {
            this.addHead(info);
        } else if (position == this.length() - 1) {
            this.addTail(info);
        } else {
            int length = 0;
            Node current = this.head;
            while (current != null) {
                length++;
                if (length == position) {
                    Node newNode = new Node(info);
                    newNode.setNextNode(current.getNextNode());
                    current.setNextNode(newNode);
                }
                current = current.getNextNode();
            }
        }
    }

    public void deleteFromHead() {
        this.head = this.head.getNextNode();
    }

    public int length() {
        int length = 0;
        Node current = this.head;
        while (current != null) {
            length++;
            current = current.getNextNode();
        }
        return length;
    }

    @Override
    public String toString() {
        return this.head.toString();
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
}
