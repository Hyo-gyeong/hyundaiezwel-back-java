public enum EmailConfig {
    NAVER("smtp.naver.com", "mc", "123abc", 5000),
    DAUM("smtp.daum.com", "mc", "123abc", 5000),
    GOOGLE("smtp.google.com", "mc", "123abc", 5000);
    
    public final String url;
    public final String id;
    public final String pw;
    public final int timeout;

    private EmailConfig(String url, String id, String pw, int timeout) {
        this.url = url;
        this.id = id;
        this.pw = pw;
        this.timeout = timeout;
    }
    
}
