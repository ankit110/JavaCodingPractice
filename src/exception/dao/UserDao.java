package exception.dao;

import exception.customexceptionclasses.DataNotFoundException;

public class UserDao {

    public static String getUserById(int id) throws DataNotFoundException {

        if(id <= 0) {
            throw new DataNotFoundException("User not found for ID: " + id);
        }

        return "user fetched successfully.";
    }
}

