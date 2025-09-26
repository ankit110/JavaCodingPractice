package exception;

import exception.controller.UserController;

public class LayeredPropagationExceptionMain {

    public static void main(String[] args) {
        System.out.println(UserController.handleRequest(1));
        System.out.println(UserController.handleRequest(0));
        System.out.println("Hii");
    }
}
