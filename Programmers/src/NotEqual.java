import java.util.ArrayList;
import java.util.Objects;

public class NotEqual {
    public static int []arr = {1, 1, 3, 3, 0, 1, 1};
    public static void main(String[] args) {
        solution(arr);
    }
    public static int[] solution(int[] arr){
        int[] answer;
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(arr[0]);
        for(int i=1; i<arr.length; i++){

            if(arr[i]!=arr[i-1]){
                arrayList.add(arr[i]);
            }
        }
        answer = new int[arrayList.size()];

        for(int i=0; i<arrayList.size(); i++){
            answer[i] = arrayList.get(i);
            System.out.println(answer[i]);
        }


        return answer;
    }
}
