package Classes;

import Bdd.Connexion;
import Classes.User;
import Classes.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Librarian extends User{
    public Librarian(String Name, String LastName, int ID, String Password) {

        super(Name, LastName, ID, Password);
    }

    public String getUserName(User p1){

        return p1.Name;
    }
    public String getUserLastName(User p1){

        return p1.LastName;
    }

    public String getUserID(User p1){
        return  p1.Name+" ID="+p1.ID;
    }

    public String getBookID(Book b1){
        return b1.title+" ID="+b1.ID;
    }

    public void getBookQuantity(Book b1){
        System.out.println(b1.title+" Quantity="+b1.quantity);
    }


    public void LoanBooktoUser(Book b1,User p1){

        if(b1.quantity == 0){
            System.out.println(b1.title+" by "+b1.author+" is not available");
        }
        else{
            b1.quantity--;
        }
        p1.addBook(b1);

    }
    public void displayBook() throws SQLException {
        Connection cnt = Connexion.connectorDB();
        Statement st = cnt.createStatement();
        //Execute th
        ResultSet res = st.executeQuery("SELECT * FROM loans WHERE Statut ='E' ;");
        while (res.next()) {
            System.out.println("Livre :\nId :" + res.getString("idBook") +
                    "\n Id Emprunteur : " + res.getString("idUser") +
                    "\nDate Emprunt : " + res.getString("BorrowDate"));
        }
    }
    public void updateLoan(int id) throws SQLException{
        Connection cnt = Connexion.connectorDB();
        Statement st = cnt.createStatement();
        String date = "'2022-06-25'";
        String req = "UPDATE loans  SET Statut = \'En cours\'  WHERE idUser = "+id+" ; ";
        String req2 = "UPDATE loans SET limitDate = "+date+" WHERE idUser = "+id+";";
        st.execute(req);
        st.execute(req2);
    }
    public void ReturnBook(Book b1,User p1){
        b1.quantity++;
        p1.removeBooks(b1);
    }

    public String getListofBorrowedBooksbyUser(User p1){
        return "User:"+p1.Name+" "+p1.getListofBorrwedBooks();
    }



}
