import Classes.Librarian;
import Classes.User;

public class ReturnType {
    public Librarian lib;
    public User user;

    public ReturnType(Librarian lib,int j) {
        this.lib = lib;
        this.user = new User("0","0",0,"0");
    }

    public ReturnType(User user, String l) {
        this.user = user;
        this.lib = new Librarian("0","0",0,"0");
    }
}
