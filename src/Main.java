import abstracts.UserService;
import concretes.UserDaoImpl;
import concretes.UserManager;
import entities.Card;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserManager(
                new Scanner(System.in),
                new UserDaoImpl()
        );
        userService.register();

    }
}