package concretes;

import abstracts.UserDao;
import entities.Card;
import entities.User;

import java.io.*;

import static constants.Constants.FILE_PATH_USERS;

public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        try {
            // file i bufferedwriter ile aciriq, daha suretlidir
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(FILE_PATH_USERS, true)
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

        File file = new File(FILE_PATH_USERS);
        if (!file.exists()){
            return null;
        }
        User user = null;

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(file)
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
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
