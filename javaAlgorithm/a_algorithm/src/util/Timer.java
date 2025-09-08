package util;

@FunctionalInterface // 람다로 사용하기 위한 인터페이스임을 알 수 있음
public interface Timer {
    void measure();
    // void end(); // 어노테이션으로 인해 오버라이드할 메서드 개수 제한 가능하게 해줌
}
