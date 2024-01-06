public class Test5 {
    public static int[] arr = {1, 2, 5};
    public static void main(String[] args) {
        backtrack(arr, "");
    }

    public static void backtrack(int[] arr, String s){
        if(Integer.parseInt(s) > 1000) return;

        if(s.length() == 3){
            System.out.println(s);
            return;
        }


        for (int i = 0; i < arr.length; i++) {
            backtrack(arr, s + arr[i]);
        }

    }
}
