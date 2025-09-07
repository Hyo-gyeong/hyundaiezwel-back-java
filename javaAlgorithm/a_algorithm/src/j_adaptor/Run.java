package j_adaptor;

import j_adaptor.auth.AuthService;
import j_adaptor.user.UserController;

public class Run {
    public static void main(String[] args) {
        UserController userController = new UserController(new AuthService());
        String response = userController.googleLogin();
        System.out.println(response);
    }
}
