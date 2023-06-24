import java.util.ArrayList;

public class MockExam_2 {
    public static int[] answers = {1,3,2,4,2};
    public static void main(String[] args) {
        System.out.println(solution(answers));
    }
    public static int[] solution(int[] answers){
        int[] first = {1, 2, 3, 4, 5}; // 5
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10

        int[] check = new int[3];

        for (int i = 0; i < answers.length; i++) {
           if(answers[i] == first[i%first.length]) check[0] ++;
           if(answers[i] == second[i%second.length]) check[1]++;
           if(answers[i] == third[i%third.length]) check[2] ++;
        }

        int max = -1;

        for (int i = 0; i < check.length; i++) {
            if(max<check[i]) max = check[i];
        }
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < check.length; i++) {
            if(max == check[i]) arrayList.add(i+1);
        }


        int[] answer= new int[arrayList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrayList.get(i);
        }


        return answer;
    }
}

