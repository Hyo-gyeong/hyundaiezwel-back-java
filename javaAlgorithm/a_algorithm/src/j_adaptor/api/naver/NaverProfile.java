package j_adaptor.api.naver;

// {"name":"naver", "email":"aaa@ggg.com"} 이렇게 들어옴
public record NaverProfile(
    String name,
    String mail
) {

}
