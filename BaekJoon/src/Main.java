public class Main {
    public static int count;
    public static void main(String[] args) {
        int ANS = 17;
        binarySearch(ANS);
    }

    public static void binarySearch(int ANS){
        int left = 1;
        int right = 1_000_000_000;

        while(left < right){
            System.out.println("left :" + left);
            System.out.println("right :" + right);
            int mid = (left + right) / 2; // 중간 값, 답이 맞는지 질문자와 같은 역할
            count++;

            if(mid >= ANS) right = mid;
            else left = mid + 1;
        }
        System.out.println("count" + count);
    }
}