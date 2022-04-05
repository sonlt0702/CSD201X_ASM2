package Project2;

public class Product {
    private String id;
    private String title;
    private int quantity;
    private double price;

    public Product() {
    }

    public Product(String id, String title, int quantity, double price) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public boolean equal(Product p) {
        return this.id == p.getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String str = String.format("%-3s | %-8s | %-8d | %-3.1f", this.id, this.title, this.quantity, this.price);
        return str;
    }
}
