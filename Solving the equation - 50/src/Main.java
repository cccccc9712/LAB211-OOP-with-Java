
public class Main {

    public static void main(String[] args) {
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.caculateSuperlative();
                    break;
                case 2:
                    Manager.caculateQuadratic();
                    break;
                case 3:
                    return;
            }
        }
    }
}
