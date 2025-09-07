package j_adaptor.user;

import j_adaptor.auth.AuthService;
import j_adaptor.auth.SocialLoginProvider;

public class UserController {
    private final AuthService authService;

    public UserController(AuthService authService){
        super();
        this.authService = authService;
    }

    public String googleLogin(){
        authService.SocialLogin(SocialLoginProvider.GOOGLE, "abc");
        return "200 OK";
    }

    public String naverLogin(){
        authService.SocialLogin(SocialLoginProvider.NAVER, "abc");
        return "200 OK";
    }
}
