

import Classes.Book;
import Classes.Librarian;
import Classes.User;

public class Test {
    public static void main(String[] agrs){
        //admin
        Librarian p1 = new Librarian("Benjamin","Bewekedi",0001,"jspfrr");
        //users
        User p2 = new User("Bruneck","Agomade",0010,"jspnonplus");
        User p3 = new User("Théophile","Berthier",0011,"moinonplusjsp");

        //Books
        Book b1 = new Book("Robinson Crusoé","Dafoe","B0001",5);
        Book b2 = new Book("Les Misérables","Victor Hugo","B0002",1);
        Book b3 = new Book("Les 3 Mousquetaires","Alexandre Dumas","B0003",1);

        //tasks and tests
        System.out.println(p2.AsktoBorrowBook(b1));
        p1.LoanBooktoUser(b1,p2);
        p1.getBookQuantity(b1);//ici il doit nous afficher 4
        p2.ReturnBorrowedBook(b1);
        System.out.println(p2.ReturnBorrowedBook(b1));
        p1.ReturnBook(b1,p1);
        p1.getBookQuantity(b1);//ici il doit afficher 5

        p1.getBookQuantity(b2);
        System.out.println(p2.AsktoBorrowBook(b2));
        p1.LoanBooktoUser(b2,p2);
        p1.getBookQuantity(b2);
        System.out.println(p3.AsktoBorrowBook(b2));
        p2.getListofBorrwedBooks();
        System.out.println(p1.getListofBorrowedBooksbyUser(p2));


    }

}
