import java.util.Scanner;

public class SteppingStone {
    static int []stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
    static int k=3;

    public static void main(String[] args) {
        System.out.println(solution(stones,k));

    }
    static int solution(int[] stones, int k) {
        int people = 1;
        int check = 0;

        while (check != k) {
            check = 0;
            for (int i = 0; i < stones.length; i++) {
                stones[i]--;
//                System.out.print(stones[i]);
                if (stones[i] <= 0) {
                    check++;
                    if(check==k) return people;
                } else {
                    check = 0;
                }

            }
            people++;
        }
        return people;
    }
}
