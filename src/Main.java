import abstracts.UserService;
import concretes.UserDaoImpl;
import concretes.UserManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserManager(
                new Scanner(System.in),
                new UserDaoImpl()
        );

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("<<-----BANK APPLICATION----->>");
            line();

            System.out.println("\n1) Login");
            System.out.println("2) Register\n");
            line();
            System.out.print("\nSechiminiz: ");
            int choise;
            try{
                choise = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Input yalnishdir.");
                continue;
            }

            switch (choise){
                case 1 : userService.login(); break;
                case 2 : userService.register(); break;
                default:
                    System.out.println("Yalnish secim!");
            }
        }

    }

    public static void line() {
        System.out.println("------------------------------");
    }
}