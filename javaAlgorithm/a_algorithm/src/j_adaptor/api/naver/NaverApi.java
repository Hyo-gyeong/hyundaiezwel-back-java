package j_adaptor.api.naver;

public class NaverApi {
    public NaverProfile getProfile(String token){
        return new NaverProfile("hyo_naver", "aaa@naver.com");
    }
}
