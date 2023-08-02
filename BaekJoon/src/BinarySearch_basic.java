import java.util.Arrays;

public class BinarySearch_basic {
    public static int count;
    public static void main(String[] args) {
        int ANS = 17;
        binarySearch(ANS);
    }

    public static void binarySearch(int ANS){
        int left = 1;
        int right = 1_000_000_000;

        while(left < right){
            System.out.print(left + " " + right);
            System.out.println();
            int mid = (left + right) / 2; // 답이 맞니?
            count++;
            if(mid >= ANS) right = mid;
            else left = mid + 1;
        }
        System.out.println("");
        System.out.println(right);
        System.out.println(count);
    }
}
