public class Book {
    String title;
    String author;
    int quantity;

    // Create a class constructor for the Book class
    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public boolean borrow(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
            return true;
        }
        return false;
    }
}
