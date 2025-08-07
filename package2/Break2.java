package package2;

public class Break2 {
  public static void main(String[] args) {
    // 중첩 반복일 때 break 범위
    for (char upper = 'A'; upper <= 'Z'; upper++){
      for (char lower = 'a'; lower <= 'z'; lower++){
        System.out.println(upper + "-" + lower);
        if (lower=='g'){
          break;
        }
      }
    }

    // 중첩 반복일 때 break 범위 - label 사용
    Outer:
    for (char upper = 'A'; upper <= 'Z'; upper++){
      for (char lower = 'a'; lower <= 'z'; lower++){
        System.out.println(upper + "-" + lower);
        if (lower=='g'){
          break Outer;
        }
      }
    }
  }
}
