public class Password implements Cloneable {
    String password;

    public Password(String password) {
        this.password = password;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Password)super.clone();
    }
}
