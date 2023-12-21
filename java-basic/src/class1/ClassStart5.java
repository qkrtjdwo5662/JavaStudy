package class1;

public class ClassStart5 {
    public static void main(String[] args) {
        Student student1 = new Student(); // 객체, 인스턴스
        student1.name = "학생 1";
        student1.age = 15;
        student1.grade = 90;

        Student student2 = new Student(); // 객체, 인스턴스
        student2.name = "학생 2";
        student2.age = 16;
        student2.grade = 80;

        Student[] students = new Student[]{student1, student2};
        System.out.println(students[0].name + " " + students[0].age + " " + students[0].grade);
        System.out.println(students[1].name + " " + students[1].age + " " + students[1].grade);

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].name + " " + students[i].age + "  " + students[i].grade);
        }

        for (int i = 0; i < students.length; i++) {
            Student s = students[i];

            System.out.println(s.name + " " + s.age + "  " + s.grade);
        }
        for (Student s : students) {
            System.out.println(s.name + " " + s.age + "  " + s.grade);
        }



    }
}
