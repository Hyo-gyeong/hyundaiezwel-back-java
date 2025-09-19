public class Run {
    public static void main(String[] args) {
        // 팩토리 클래스 - 설정값들이 정해져있을 때 사용함
        // 설정 값 바뀔 때마다 찾아다니면서 바꾸지 않도록 한 곳에서 객체 생성을 위임해야함
        SMTPConnector connector = ConnectionFactory.create(EmailConfig.NAVER);
        // SMTPConnector connector = ConnectionFactory.create(EmailConfig.DAUM);
        // SMTPConnector connector = ConnectionFactory.create(EmailConfig.GOOGLE);
        connector.connect();
    }
}
