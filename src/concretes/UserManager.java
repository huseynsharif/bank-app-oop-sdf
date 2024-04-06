package concretes;

import abstracts.UserService;
import entities.dtos.LoginRequestDto;
import entities.dtos.RegisterRequestDto;

import java.util.Scanner;

// implements keywordu interfacein methodlarını classa implement edir
public class UserManager implements UserService {

    private Scanner scanner = null;

    @Override
    public void register() {
        // scanneri bashlat
        scanner = new Scanner(System.in);

        System.out.println("Ad Soyadinizi daxil edin: ");
        String fullNameInput = scanner.nextLine();

        System.out.println("Kard nomresini daxil edin: ");
        // input stringi alıb boshluqlari silirik: 1111 2222 -> 11112222
        String cardNumberInput = scanner.nextLine().replaceAll("\\s", "");

        // card numberde herif ola bilmez
        while (!cardNumberInput.matches("[0-9]+")){
            System.out.println("Kard nömrəsi yalnız rəqəmlərdən ibarət olmalıdır.");
            cardNumberInput = scanner.nextLine().replaceAll("\\s", "");
        }

        System.out.println("Pin kodu daxil edin: ");
        String pinCodeInput = scanner.nextLine();
        while (!pinCodeInput.trim().matches("[0-9]+")){
            System.out.println("Pin kod yalnız rəqəmlərdən ibarət olmalıdır.");
            pinCodeInput = scanner.nextLine();
        }



        scanner.close();
    }

    @Override
    public void login() {
        scanner = new Scanner(System.in);


        scanner.close();
    }
}
