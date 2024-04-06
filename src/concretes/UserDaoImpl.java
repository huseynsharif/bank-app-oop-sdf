package concretes;

import abstracts.UserDao;
import constants.Constants;
import entities.Card;
import entities.User;

import java.io.*;

public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        try {
            // file i bufferedwriter ile aciriq, daha suretlidir
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(Constants.FILE_PATH_USERS, true)
            );
            String line = String.format("%s&%s&%s\n", user.getFullName(), user.getCard().getCardNumber(), user.getCard().getPinCode());
            writer.write(line);

            // sonda close edirik
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findUserByCardNumber(String cardNumber) {
        User user = null;
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(Constants.FILE_PATH_USERS)
            );
            String line;
            String[] datas;

            while ((line = reader.readLine()) != null){
                datas = line.split("&");
                if (datas[1].equals(cardNumber)){
                    user = new User(
                            datas[0],
                            new Card(
                                    datas[1],
                                    Integer.parseInt(datas[2])
                            )
                    );
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return user;
    }
}
