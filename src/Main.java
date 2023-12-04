import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        Password password = new Password("321");

        User vlad = new User("Vlad", 1234, password);
        User vlad1 = new User("Vlad", 1234, password);
        System.out.println(vlad.equals(vlad1));

        User anon = (User)vlad.clone();
        System.out.println(vlad.toString());
        System.out.println(anon.toString());

        User anon1 = vlad.deepClone();
        System.out.println(vlad.toString());
        System.out.println(anon1.toString());

    }


}