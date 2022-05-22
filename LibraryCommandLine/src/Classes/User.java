package Classes;


import Bdd.Connexion;
import Classes.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class User {
    protected   String Name;
    protected   String LastName;
    protected int ID;
    protected String Password;
    private List<Book> Books;

    public String getName() {
        return Name;
    }

    public String getLastName() {
        return LastName;
    }

    public User(String Name, String LastName, int ID , String Password){
        this.Name = Name ;
        this.LastName = LastName;
        this.ID = ID;
        this.Password = Password;
        this.Books = new ArrayList<Book>();
    }

    public int getID(){
        return this.ID;
    }

    public String AsktoBorrowBook(Book b1){
        if(b1.quantity == 0){
        return "Sorry "+this.Name+" the book you asked for : "+b1.title+" is currently unavailable";
        }
        else {
            return this.Name + " ask to borrow the book: " + b1.title;
        }
    }

    public String ReturnBorrowedBook(Book b1){
        return this.Name+" wants to return the book: "+b1.title;
    }

    public String getCurrentBorrowedBooks(Book b1){
        return this.Name+" currently you have loan"+b1.title;
    }

    public void addBook(Book b1){
        this.Books.add(b1);
    }

    public void removeBooks(Book b1){

        this.Books.remove(b1);

    }

    public String getListofBorrwedBooks(){
        return "Borrowed Books:"+this.Books;
    }
    public static void ReturnBooktoUser(String title) {
        Connection cnt = Connexion.connectorDB();
        Statement st = null;


        //SQL Request for deleting the current
        String req = "UPDATE books SET idUser = null WHERE title = '"+title+"';";
        String req2 = "UPDATE loans SET currentDate = NOW() WHERE idBook = (SELECT idBook FROM books WHERE title = '"+title+"');";
        System.out.println(req);
        try {
            st = cnt.createStatement();
            st.execute(req);
            st.execute(req2);
            System.out.println("Retour Réussie");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", LastName='" + LastName + '\'' +
                ", ID=" + ID +
                ", Password='" + Password + '\'' +
                ", Books=" + Books +
                '}';
    }
}
