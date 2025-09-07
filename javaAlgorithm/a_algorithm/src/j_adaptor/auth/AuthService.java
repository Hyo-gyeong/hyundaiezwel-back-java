package j_adaptor.auth;

import j_adaptor.api.google.GoogleApi;
import j_adaptor.api.google.GoogleProfile;
import j_adaptor.api.naver.NaverApi;
import j_adaptor.api.naver.NaverProfile;
import j_adaptor.auth.adaptor.GoogleAdaptor;
import j_adaptor.auth.adaptor.NaverAdaptor;
import j_adaptor.user.UserProfile;

public class AuthService {

    public void SocialLogin(SocialLoginProvider provider, String token){
        SocialLogin socialLogin = switch (provider){
            case NAVER -> new NaverAdaptor();
            case GOOGLE -> new GoogleAdaptor();
            default ->
                throw new IllegalArgumentException("Unexpected value : " + provider);
        };

        UserProfile userProfile = socialLogin.login(token);
        System.out.println(userProfile.username()+" 로그인 로직 시작");
        
    }
    
}
