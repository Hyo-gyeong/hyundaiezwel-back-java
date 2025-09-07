package j_adaptor.auth.adaptor;

import j_adaptor.api.google.GoogleApi;
import j_adaptor.api.google.GoogleProfile;
import j_adaptor.auth.SocialLogin;
import j_adaptor.user.UserProfile;

public class GoogleAdaptor implements SocialLogin {

    private final GoogleApi api = new GoogleApi();

    @Override
    public UserProfile login(String token) {
        GoogleProfile profile = api.getProfile(token);
        return new UserProfile(profile.username(), profile.email());
    }
    
}
