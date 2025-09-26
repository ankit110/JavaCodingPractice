package exception.service;

import exception.customexceptionclasses.DataNotFoundException;
import exception.dao.UserDao;

public class UserService {

    public static String fetchUser(int id) throws DataNotFoundException {
        return UserDao.getUserById(id);
    }
}
