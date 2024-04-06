package concretes;

import abstracts.UserDao;
import abstracts.UserService;
import entities.Card;
import entities.User;

import java.util.Scanner;

// implements keywordu interfacein methodlarını classa implement edir
public class UserManager implements UserService {

    private final Scanner scanner;
    private final UserDao userDao;

    public UserManager(Scanner scanner, UserDao userDao) {
        this.scanner = scanner;
        this.userDao = userDao;
    }

    @Override
    public void register() {

        System.out.println("Ad Soyadinizi daxil edin: ");
        String fullNameInput = scanner.nextLine();

        String cardNumberInput = getCardNumberInput();

        int pinCodeInput = getPinCodeInput();

        // inputlari user objectine yigiriq

        User user = new User(
                fullNameInput,
                new Card(
                        cardNumberInput,
                        pinCodeInput
                )
        );

        this.userDao.add(user);
    }



    @Override
    public void login() {

        String cardNumberInput = getCardNumberInput();
        User user = this.userDao.findUserByCardNumber(cardNumberInput);

        if (user==null){
            System.out.println("Daxil etdiyiniz kard nomresine uygun kard tapilmadi.");
            return;
        }

        int pinCodeInput = getPinCodeInput();
        int tryLeft = 3;

        while (pinCodeInput != user.getCard().getPinCode()){
            System.out.println("Pinkod yalnışdır. Geri qalan cəhd sayınız: " + --tryLeft);
            if (tryLeft==0){
                break;
            }
            pinCodeInput = getPinCodeInput();
        }

        if (tryLeft!=0){
            System.out.println("Login oldunuz, " + user.getFullName());
        }

    }

    // tekrarciliq olmasin deye bu methodlari ayirdim
    private int getPinCodeInput() {
        System.out.println("Pin kodu daxil edin: ");
        String pinCodeInput = scanner.nextLine();
        while (!pinCodeInput.trim().matches("[0-9]+") || pinCodeInput.length()!=4){
            System.out.println("Input yalnishdir. Pin kod yalnız rəqəmlərdən ve 4 simvoldan ibaret olmalidir.");
            System.out.println("Zehmet olmasa, pin kodu yeniden daxil edin: ");
            pinCodeInput = scanner.nextLine();
        }
        return Integer.parseInt(pinCodeInput);
    }

    private String getCardNumberInput(){
        System.out.println("Kard nomresini daxil edin: ");
        // input stringi alıb boshluqlari silirik: 1111 2222 -> 11112222
        String cardNumberInput = scanner.nextLine().replaceAll("\\s", "");

        // card numberde herif ola bilmez
        while (!cardNumberInput.matches("[0-9]+") || cardNumberInput.length()!=16){
            System.out.println("Input yalnishdir. Kard nömrəsi yalnız rəqəmlərdən ve 16 simvoldan ibaret olmalidir.");
            System.out.println("Zehmet olmasa, kard nomresini yeniden daxil edin: ");
            cardNumberInput = scanner.nextLine().replaceAll("\\s", "");
        }

        return cardNumberInput;
    }
}
