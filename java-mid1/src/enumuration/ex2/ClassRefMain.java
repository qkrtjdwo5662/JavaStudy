package enumuration.ex2;

public class ClassRefMain {
    public static void main(String[] args) {
        System.out.println(ClassGrade.BASIC.getClass());
        System.out.println(ClassGrade.GOLD.getClass());
        System.out.println(ClassGrade.DIAMOND.getClass());
        // 어디서 해당 클래스가 만들어졌는지 정보가 나옴

        System.out.println(ClassGrade.BASIC);
        System.out.println(ClassGrade.GOLD);
        System.out.println(ClassGrade.DIAMOND);
        // 각각의 상수는 서로 다른 인스턴스를 참조하기 때문에 참조값이 다름


    }
}
