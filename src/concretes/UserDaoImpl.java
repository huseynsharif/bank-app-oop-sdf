package concretes;

import abstracts.UserDao;
import constants.Constants;
import entities.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        try {
            // file i bufferedwriter ile aciriq, daha suretlidir
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(Constants.FILE_PATH_USERS, true)
            );
            String line = String.format("%s&%s&%s", user.getFullName(), user.getCard().getCardNumber(), user.getCard().getPinCode());
            writer.write(line);

            // sonda close edirik
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
