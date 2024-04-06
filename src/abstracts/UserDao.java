package abstracts;

import entities.User;

public interface UserDao {

    // yeni user elave edecek
    void add(User user);

    // card nomresine gore user melumatlarini cekecek
    User findUserByCardNumber(String cardNumber);

}
