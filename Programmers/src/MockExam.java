import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MockExam {
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};
        System.out.println(Arrays.toString(solution(answers)));
    }
    static public int[] solution(int[] answers){
        //1번 수포자 패턴 1,2,3,4,5 5개
        int[] num1 = {1,2,3,4,5};
        //2번 수포자 패턴 2,1,2,3,2,4,2,5 8개
        int[] num2 = {2,1,2,3,2,4,2,5};
        //3번 수포자 패턴 3,3,1,1,2,2,4,4,5,5, 10개
        int[] num3 = {3,3,1,1,2,2,4,4,5,5};

        int[] score = {0,0,0};
        int max =0;


        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == num1[i%5]) score[0]++;
            if(answers[i] == num2[i%8]) score[1]++;
            if(answers[i] == num3[i%10]) score[2]++;
        }
        for (int j : score) {
            if (max < j) max = j;
        }
        System.out.println(max);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if(max==score[i]) list.add(i+1);
        }
        int []answer = new int[list.size()];
        System.out.println(list.size());
        for (int i = 0; i <list.size() ; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
