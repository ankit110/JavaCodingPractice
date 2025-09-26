package exception.controller;

import exception.customexceptionclasses.DataNotFoundException;
import exception.service.UserService;

public class UserController {

    public static String handleRequest(int id) {

        String res = "";
        try {
            res = UserService.fetchUser(id);
        } catch (DataNotFoundException ex) {
            System.out.println("Error:- " + ex.getMessage());
            res = "User not found";
        }

        return res;
    }
}
