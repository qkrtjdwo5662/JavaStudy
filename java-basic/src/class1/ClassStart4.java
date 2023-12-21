package class1;

public class ClassStart4 {
    public static void main(String[] args) {
        Student student1 = new Student(); // 객체, 인스턴스
        student1.name = "학생 1";
        student1.age = 15;
        student1.grade = 90;

        Student student2 = new Student(); // 객체, 인스턴스
        student2.name = "학생 2";
        student2.age = 16;
        student2.grade = 80;

        Student[] students = new Student[2]; // student 변수를 2개 보관하는 사이즈 2의 배열
        students[0] = student1; // 보관하는 student1 참조값을 복사
        students[1] = student2; // 보관하는 student2 참조값을 복사

        System.out.println(students[0].name + " " + students[0].age + " " + students[0].grade);
        System.out.println(students[1].name + " " + students[1].age + " " + students[1].grade);
    }
}
