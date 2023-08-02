public class Test {
    public static int[] arr1 = {1,2,3,4};
    public static int[] arr2 = {5,6,7};
    public static boolean[] visited1;
    public static void main(String[] args) {

        backtrack("", 2);
    }

    public static void backtrack(String s, int depth){

        if(s.length() == depth){
            System.out.println(s);
            return;
        }
        visited1 = new boolean[4];
        if(s.length() == 0){

            for (int i = 0; i < arr1.length; i++) {
                if(!visited1[i]){
                    visited1[i] = true;
                    backtrack(s+arr1[i], depth);
                    visited1[i] = false;
                }
            }
        }else {

            for (int i = 0; i < arr2.length; i++) {
                if(!visited1[i]){
                    visited1[i] = true;
                    backtrack(s+arr2[i], depth);
                    visited1[i] = false;
                }
            }
        }

    }
}
