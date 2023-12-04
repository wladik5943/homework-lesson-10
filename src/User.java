import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements Cloneable {
    String name;
    int id;
    Password password;

    public static ArrayList<User> instances = new ArrayList<User>();
    public static User CreateUser(String name, int id, Password password){
        User newUser = new User(name, id, password);
        instances.add(newUser);
        return new User(name,id,password);
    }

    public User deepClone() throws CloneNotSupportedException {
        User newUser = (User)super.clone();
        Password password = (Password) this.getPassword().clone();
        newUser.setPassword(password);
        return newUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", password=" + password +
                '}';
    }

    public User(String name, int id, Password password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!Objects.equals(name, user.name)) return false;
        return Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private User(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
