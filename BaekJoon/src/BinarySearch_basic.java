public class BinarySearch_basic {

    public static void main(String[] args) {
        int ANS = 15;
        binarySearch(ANS);
    }

    public static void binarySearch(int ANS){
        int left = 1;
        int right = 50;

        while(left<right){
            System.out.print(left + " " + right);
            System.out.println();
            int mid = (left + right) / 2;

            if(mid >= ANS) right = mid;
            else left = mid + 1;
        }
    }
}
