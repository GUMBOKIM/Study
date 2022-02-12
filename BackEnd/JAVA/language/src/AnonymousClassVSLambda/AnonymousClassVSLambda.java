package AnonymousClassVSLambda;

public class AnonymousClassVSLambda {
    public static void main(String[] args) {

        CustomAction action = new CustomAction();

        // 익명 클래스 구현
        action.customAction(10, new CustomInterface() {
            @Override
            public void customMethod() {
                System.out.println("Hello I'm Anonymous Class");
            }
        });

        // 람다 구현
        action.customAction(10, () -> System.out.println("Hello I'm Anonymous Lambda"));

        // 익명 클래스 내부 변수 사용
        action.customAction(10, new CustomInterface() {
            int result = 0;
            @Override
            public void customMethod() {
                for (int i = 1; i <= 100; i++) {
                    System.out.println("+" + i);
                    result += i;
                }
                System.out.println("result = " + result);
            }
        });

    }
}

interface CustomInterface {
    void customMethod();
}

class CustomAction {
    void customAction(int n, CustomInterface customInterface) {
        for (int i = 0; i < n; i++) {
            customInterface.customMethod();
        }
    }
}

