import java.util.ArrayDeque;
import java.util.Arrays;

public class MatrixAndOperation {
    public static int [][] rc = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    public static String[] operations = {"ShiftRow", "Rotate", "ShiftRow", "Rotate"};
    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(solution(rc, operations)));
    }

    public static int[][] solution(int[][] rc, String[] operations){
        int[][] answer= new int[rc.length][rc[0].length];

        ArrayDeque<Integer> left = new ArrayDeque<>(); // 모든 행의 첫 번째 열 원소
        ArrayDeque<Integer> right = new ArrayDeque<>(); // 모든 행의 마지막 열 원소
        ArrayDeque<ArrayDeque<Integer>> mid = new ArrayDeque<>();

        for (int i = 0; i < rc.length; i++) {
            left.addLast(rc[i][0]);

            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int j = 1; j < rc[0].length-1; j++) {
                deque.addLast(rc[i][j]);
            }
            mid.addLast(deque);

            right.addLast(rc[i][rc[0].length-1]);
        }

        for (int i = 0; i < operations.length; i++) { // 연산 시작
            if(operations[i].equals("ShiftRow")){ // ShiftRow
                left.addFirst(left.pollLast());
                mid.addFirst(mid.pollLast());
                right.addFirst(right.pollLast());
            }else{ // Rotate
                mid.getFirst().addFirst(left.pollFirst());
                right.addFirst(mid.getFirst().pollLast());
                mid.getLast().addLast(right.pollLast());
                left.addLast(mid.getLast().pollFirst());
            }
        }

        for (int i = 0; i <answer.length ; i++) { // 위 연산 후 세 개의 deque을 answer[][]에 담아줌
            answer[i][0] = left.pollFirst();
            ArrayDeque<Integer> deque = mid.pollFirst();
            for (int j = 1; j < answer[0].length - 1; j++) {
                answer[i][j] = deque.pollFirst();
            }
            answer[i][answer[0].length-1] = right.pollFirst();
        }

        return answer;
    }
}
