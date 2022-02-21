package hello.core.singleton;

public class SingletonService {

    // static 영역에 객체를 딱 1개만 생성
    // 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private static final SingletonService instance = new SingletonService();

    // 조회할 때, 이 메서드를 통해서만 조회 가능
    public static SingletonService getInstance() {
        return instance;
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
