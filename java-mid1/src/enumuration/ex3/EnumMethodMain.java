package enumuration.ex3;

import java.util.Arrays;

public class EnumMethodMain {
    public static void main(String[] args) {
        Grade[] value = Grade.values();
        System.out.println(Arrays.toString(value));

        for (Grade grade : value) {
            System.out.println(grade.name() + " " + grade.ordinal());
        }
        // ordinal은 가급적 사용하지 않는 것이 좋음
        // 중간에 상수 위치 변경되면 전체 상수의 위치가 모두 변경될 수 있음

        String input = "GOLD";
        Grade gold = Grade.valueOf(input);
        System.out.println(gold);
    }
}
