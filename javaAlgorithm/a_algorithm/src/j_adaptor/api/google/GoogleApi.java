package j_adaptor.api.google;

public class GoogleApi {
    public GoogleProfile getProfile(String token){
        return new GoogleProfile("hyo", "aaa@bbb.com");
    }
}
