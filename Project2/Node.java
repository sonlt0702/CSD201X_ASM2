package Project2;

public class Node {
    private Product info;
    private Node nextNode;

    public Node(Product info, Node nextNode) {
        this.info = info;
        this.nextNode = nextNode;
    }

    public Node(Product info) {
        this(info, null);
    }

    public Product getInfo() {
        return info;
    }

    public void setInfo(Product info) {
        this.info = info;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return this.info.toString();
    }

}
