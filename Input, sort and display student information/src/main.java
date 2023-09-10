
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author tmtmt
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        display();
    }
    
    public static void display(){
        ArrayList<Student> list = new ArrayList<>();
        addStudent(list);
        String Yes = "Y";
        while (true) {
            System.out.print("Do you want to enter more student information?(Y/N): ");
            Scanner sc = new Scanner(System.in);
            String input = sc.next();
            if (input.equalsIgnoreCase("Y")) {
                addStudent(list);
            }else if(input.equalsIgnoreCase("N")){
                break;
            }else{
                System.out.println("Invalid input. Please enter 'Y' to continue or 'N' to stop.");
            }
        }
        print(list);
    }
    
    public static void addStudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input student information ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Classes: ");
        String classes = sc.nextLine();
        System.out.print("Mark: ");
        float mark = sc.nextFloat();
        list.add(new Student(name, mark, classes));
    }
    
    private static void print(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("--------Student " + i + 1 + "--------");
            System.out.println("Name: " + list.get(i).getName());
            System.out.println("Classes: " + list.get(i).getClasses());
            System.out.println("Mark: " + list.get(i).getMark());
        }
    }
}
