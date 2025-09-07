package j_adaptor.auth;

import j_adaptor.user.UserProfile;

public interface SocialLogin {
    UserProfile login(String token);

}
