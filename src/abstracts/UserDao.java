package abstracts;

import entities.User;

public interface UserDao {

    void add(User user);
    User findUserByCardNumber(String cardNumber);

}
