import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class taskdop {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println();
            System.out.println("1.Cоздание обьекта");
            System.out.println("2.Клонирование обьекта");
            System.out.println("3.выход");
            int n = Integer.parseInt(scanner.nextLine());
            switch (n){
                case 1:{

                    System.out.println("Введите имя");
                    String name = scanner.nextLine();
                    System.out.println("Введите id");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Введите пароль");
                    Password password = new Password(scanner.nextLine());
                    User user = User.CreateUser(name,id,password);
                    System.out.println("обьект " + user.toString() + " создан");
                    break;
                }
                case 2:{
                    System.out.println("Введите id");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Введите метод клонирования");
                    String clone = scanner.nextLine();
                    User newUser = cloneObject(clone,id);
                    break;
                }
                case 3:{
                    return;
                }
            }

        }
    }

    public static User cloneObject(String clone, int id) throws CloneNotSupportedException {
        int ind = -1;
        for (int i = 0; i < User.instances.size(); i++) {
            if (User.instances.get(i).getId() == id){
                ind = i;
                break;
            }
        }
        if(ind == -1)throw new RuntimeException(id + " не существует");

        if(clone.equalsIgnoreCase("shallow")){
            User newUser = (User) User.instances.get(ind).clone();
            User.instances.add(newUser);
            System.out.println("Клонируемый обьект");
            System.out.println(User.instances.get(ind).toString());
            System.out.println("Клонированный обьект");
            System.out.println(newUser.toString());
            return newUser;
        }
        if(clone.equalsIgnoreCase("deep")){
            User newUser = (User) User.instances.get(ind).deepClone();
            User.instances.add(newUser);
            System.out.println("Клонируемый обьект");
            System.out.println(User.instances.get(ind).toString());
            System.out.println("Клонированный обьект");
            System.out.println(newUser.toString());
            return newUser;
        }
        else throw new RuntimeException("метод клонирования введен некорректно");
    }
}
