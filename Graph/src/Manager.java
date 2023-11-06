
import java.util.Scanner;

public class Manager {
    
    public static Scanner sc = new Scanner(System.in);
    public static Graph gr = new Graph();

    
    public static int menu(){
        System.out.println("========== Social App ==========");
        System.out.println("1 - Login.");
        System.out.println("2 - Register");
        System.out.print("Choose an option: ");
        int input = sc.nextInt();
        return input;
    }
    
    public static void login(){
        System.out.print("Username: ");
        String userName = sc.next();
        Vertex user = gr.getVertex(userName);
        loginMenu(user);
    }
    
    public static void Register(){
        System.out.print("Username: ");
        String newUserName = sc.next();
        gr.addVertex(newUserName);
        System.err.println("Register successfully!");
    }
    
    public static void loginMenu(Vertex user){
        System.out.println("1 - Add friends.");
        System.out.println("2 - Show friends List.");
        System.out.println("3 - Find more friends.");
        System.out.print("Choose an option: ");
        int option = sc.nextInt();
        switch(option){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
    
    public static void showListFriends(){
        //tìm các đỉnh kề
    }
    
    public static void findMoreFriends(){
        //dùng để tìm cách đỉnh kề của đỉnh kề
    }
    
    public static void addFriend(){
        //tạo một edge nối giữa 2 đỉnh.
    }
    
    
    
}
