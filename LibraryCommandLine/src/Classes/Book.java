package Classes;

public class Book {
    public int quantity;
    public String title;
    public String author;
    public String ID;

    public Book(String title,String author,String ID, int quantity){
        this.title = title;
        this.author = author;
        this.ID = ID;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "quantity=" + quantity +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
}
