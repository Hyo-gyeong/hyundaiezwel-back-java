package oopClass.sec17;

public class Earth {
  // 클래스별 상수 : 상수의 일반적인 의미
  // 대문자로 선언하는게 일반적
  static final double EARTH_RADIUS = 6400;
  static final double EARTH_SURFACE_AREA;

  static { // 좀 복잡한 값은 static block에서 정의해줄 수 있음
            // 보통은 선언 후 static block에서 초기화 함
    EARTH_SURFACE_AREA = 4*Math.PI+EARTH_RADIUS;
  }
}
