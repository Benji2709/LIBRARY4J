package Bdd;

import Classes.*;


import java.sql.*;
import java.util.Scanner;

public class MainBdd {

    public static void main(String[] args) throws SQLException {

        Connection cnt = Connexion.connectorDB();
        Statement st = cnt.createStatement();
        //Execute th
        ResultSet res = st.executeQuery("SELECT * FROM books");
        //Saisie d'un pseudo et mdp
        String pseudo;
        String password;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 to login or 2 to register");
        int i = sc.nextInt();
        switch (i) {
            case 1:
                System.out.println("Saisissez un pseudo : ");
                pseudo = sc.next();
                System.out.println("Saisissez un mot de passe : ");
                password = sc.next();
                System.out.println("Enter 1 if you are a user or 2 if you are a librarian");
                int t = sc.nextInt();
                switch (t) {
                    case 1:

                        User user1 = Management.connection(pseudo, password);
                        System.out.println("Here is the list of books");
                        while (res.next()) {
                            System.out.println("Livre :\nId :" + res.getString("idBook") +
                                    "\nAuteur : " + res.getString("author") +
                                    "\nTitre : " + res.getString("Title"));
                        }
                        System.out.println("Enter 1 to loan a book or 2 to return a book :");
                        int j = sc.nextInt();
                        switch (j) {
                            case 1:

                                Scanner sc1 = new Scanner(System.in);

                                System.out.println("Enter the id of the book that you want");
                                int idBook = sc1.nextInt();
                                Management.loanBooktoUserDB(pseudo, idBook);
                                break;

                            case 2:
                                System.out.println("Enter the name of the book that you want to return");
                                String titleLoan = sc.next();
                                user1.ReturnBooktoUser(titleLoan);
                                break;
                        }
                        break;
                    case 2:
                        Librarian librarian = Management.connectionLbr(pseudo, password);
                        System.out.println("Here is the list of loan books");
                        librarian.displayBook();
                        System.out.println("Enter the id of the user that you want to accept the loan");
                        int p = sc.nextInt();
                        librarian.updateLoan(p);

                        break;


                }
                break;
            case 2:
                System.out.println("Saisissez un pseudo : ");
                pseudo = sc.next();
                System.out.println("Saisissez un mot de passe : ");
                password = sc.next();
                Management.registrer(pseudo, password);
                break;
        }
        System.out.println("FIN ! ");
        }




       // Management.deleteUser(pseudo);



    }




