import java.util.Arrays;
import java.util.HashMap;

public class Ka2023_1 {
    public static String[] friends = {"muzi", "ryan", "frodo", "neo"}; // 친구 원소
    public static String[] gifts ={"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
    public static void main(String[] args) {
        System.out.println(solution(friends, gifts));
    }

    public static int solution(String[] friends, String[] gifts){
        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        int n = friends.length;
        for (int i = 0; i < n; i++) {
            map.put(friends[i], i);
            count.put(i, 0);
        }

        int[][] board = new int[n+1][n+1];

        for (int i = 0; i < gifts.length; i++) {
            String[] gift = gifts[i].split(" ");

            String a = gift[0];
            String b = gift[1];

            int indexA = map.get(a);
            int indexB = map.get(b);

            board[indexA][indexB] ++;
        }

        System.out.println(Arrays.deepToString(board));

        for (int i = 0; i < n; i++) {
            int sumC = 0;
            int sumR = 0;
            for (int j = 0; j < n; j++) {
                sumC += board[i][j];
                sumR += board[j][i];
            }

            board[i][n] = sumC;
            board[n][i] = sumR;
        }
        System.out.println(Arrays.deepToString(board));


        for (int i = 0; i < n-1; i++) {
            String first = friends[i];
            for (int j = i+1; j < n; j++) {
                String second = friends[j];

                int firstIndex = map.get(first);
                int secondIndex = map.get(second);

                int firstToSecond = board[firstIndex][secondIndex];
                int secondToFirst = board[secondIndex][firstIndex];

                System.out.println(first + firstToSecond+" "  + second + secondToFirst);
                if(firstToSecond > secondToFirst){
                    System.out.println(first + "가 받음");
                    count.put(firstIndex, count.get(firstIndex) + 1);
                }else if(firstToSecond < secondToFirst){
                    System.out.println(second + "가 받음");
                    count.put(secondIndex, count.get(secondIndex) + 1);
                }else{ // equal
                    // 선물 지수 비교
                    int firstGiveTotal = board[firstIndex][n];
                    int firstReceiveTotal = board[n][firstIndex];

                    int secondGiveTotal = board[secondIndex][n];
                    int secondReceiveTotal = board[n][secondIndex];

                    int firstFactor = firstGiveTotal - firstReceiveTotal;
                    int secondFactor = secondGiveTotal - secondReceiveTotal;

                    if(firstFactor > secondFactor){
                        System.out.println(first + "가 받음*");
                        count.put(firstIndex, count.get(firstIndex) + 1);
                    }else if(firstFactor < secondFactor){
                        System.out.println(second + "가 받음*");
                        count.put(secondIndex, count.get(secondIndex) + 1);
                    }
                }
            }
        }

        System.out.println(map);
        System.out.println(count);

        return answer;


    }
}
