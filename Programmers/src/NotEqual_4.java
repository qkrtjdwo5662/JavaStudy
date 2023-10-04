import java.util.ArrayList;
import java.util.Arrays;

public class NotEqual_4 {
    public static int[] arr = {1,1,3,3,0,1,1};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int[] arr){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1] != arr[i]){
                arrayList.add(arr[i]);
            }
        }

        int[] answer = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }
}
