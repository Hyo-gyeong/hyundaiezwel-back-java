package testPackage;

class A {
	
}

class B {
	// 클랫는 한개의 java파일에 여러개 생성할 수 있지만 main을 포함하는 클래스는 1개만 있어야 함
}

// java 프로그램은 파일명과 동일한 public 클래스를 찾고 내포된 main()에서부터 실행 시작
public class Test { // main을 담고있는 클래스가 파일명
	// main이 없는 클래스들만 있으면 puclic 클래스는 파일에서 한개만 구성하고 public인 클래스를 파일명으로 사용
	// public은 접근 제한이 없음

	public static void main(String[] args) {
		// 자바 프로젝트 실행 시작점
		// 객체 생성하지 않고 main함수 사용 가능하도록 static으로 생성 - 객체 없이 바로 호출 가능
		// main함수가 종료되면 프로그램 종료 - 프로젝트에서 한 번만 표현됨
		// main함수가 포함된 클래스는 public이어야 함
		// main은 return값이 없어야 함 - void
		// String[] args : main을 가상머신이 호출할 때 전달되는 data가 args로 전달됨
		// 매개변수도 변수이기 때문에 변수의 type을 String[]으로 결정했음
		System.out.println("테스트입니ss다.");
		
	} // 프로그램 종료

}
