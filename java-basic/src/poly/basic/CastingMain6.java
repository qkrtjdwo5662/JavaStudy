package poly.basic;

public class CastingMain6 {
    public static void main(String[] args) {
        Parent parent1 = new Parent();
        System.out.println("parent1 호출");
        call(parent1);

        System.out.println();

        Parent parent2 = new Child();
        System.out.println("parent2 호출");
        call(parent2);
    }

    private static void call(Parent parent){
        parent.parentMethod();
        // Child 인스턴스 경우 childMethod() 실행

        if(parent instanceof Child child){ // Java 16부터 변수 선언 가능
            System.out.println("Child Instance");
            child.childMethod();
        }
    }
}

