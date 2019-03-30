import java.util.*;

//proba
public class Huma extends Usuari {

    private String Password;

    public Huma(String nom, String Password){
        super(nom);
        this.Password = Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getPassword() {
        return Password;
    }
}
