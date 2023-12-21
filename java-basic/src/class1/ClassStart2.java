package class1;

public class ClassStart2 {
    public static void main(String[] args) {
        // ---------------------------------------------------------------------
        // 배열을 사용하여 해결
        String[] studentNames = {"학생1", "학생2"};
        int[] studentAges = {15, 16};
        int[] studentGrades = {90, 80};

        for (int i = 0; i < studentNames.length; i++) {
            System.out.println(studentNames[i] + " " + studentAges[i] + " " +studentGrades[i]);
        }
        // 배열로 학생 데이터를 관리하는 경우는 각각의 요소를 정확하게 맞춰줘야함
        // ---------------------------------------------------------------------

        // ---------------------------------------------------------------------
        // 클래스 도입 -> 학생이라는 개념으로 묶음
    }
}
