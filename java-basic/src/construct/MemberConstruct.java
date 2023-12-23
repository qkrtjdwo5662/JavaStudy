package construct;

public class MemberConstruct {
    String name;
    int age;
    int grade;
    MemberConstruct(String name, int age){
        this(name, age, 50);
        // this()를 생성하면 생성자 내부에 다른 생성자를 호출 가능
        // this()는 생성자의 첫줄에서만 사용가능
    }

    MemberConstruct(String name, int age, int grade){
        System.out.println("생성자 호출");
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
