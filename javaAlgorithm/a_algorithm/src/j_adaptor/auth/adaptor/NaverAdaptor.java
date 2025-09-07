package j_adaptor.auth.adaptor;

import j_adaptor.api.naver.NaverApi;
import j_adaptor.api.naver.NaverProfile;
import j_adaptor.auth.SocialLogin;
import j_adaptor.user.UserProfile;

public class NaverAdaptor implements SocialLogin {

    private final NaverApi api = new NaverApi();

    @Override
    public UserProfile login(String token) {
        NaverProfile profile = api.getProfile(token);
        return new UserProfile(profile.name(), profile.mail());
    }
    
}
