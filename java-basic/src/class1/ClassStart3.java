package class1;

public class ClassStart3 {
    public static void main(String[] args) {
        Student student1 = new Student(); // 객체, 인스턴스
        student1.name = "학생 1";
        student1.age = 15;
        student1.grade = 90;

        Student student2 = new Student(); // 객체, 인스턴스
        student2.name = "학생 2";
        student2.age = 16;
        student2.grade = 80;

        System.out.println(student1.name + " " + student1.age + " " + student1.grade);
        System.out.println(student2.name + " " + student2.age + " " + student2.grade);

        // 클래스 도입의 유래는 내가 원하는 타입을 선언하고 사용하기 위한 설계도
        // 객체, 인스턴스는 설계도인 클래스를 통해 실제 메모리에 만들어진 것

        Student student3 = null; // Student 타입을 받을 수 있는 변수
        System.out.println(student3); // student 3의 참조 값
        student3 = new Student(); // 설계도 클래스를 기반으로 객체(인스턴스) 생성, 메모리 공간 확보, 참조값 리턴하여 student3에 반환
        System.out.println(student3); // @뒤의 값 : student 3의 참조 값
        System.out.println(student3.age); // 0
        System.out.println(student3.grade); // 0
        System.out.println(student3.name); // null

        // student3.  -> 참조 값을 읽어서 메모리에 존재하는 객체에 접근
        student3.name = "학생3"; // name 멤버 변수에 데이터 저장


    }
}
