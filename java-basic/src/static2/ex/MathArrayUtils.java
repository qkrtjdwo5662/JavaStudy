package static2.ex;

public class MathArrayUtils {

    private MathArrayUtils(){
        // private를 통해 인스턴스 생성자를 막는다.
    }
    public static int sum(int[] arr){
        int sum = 0;
        for(int e : arr){
            sum += e;
        }

        return sum;
    }

    public static double average(int[] arr){

        return (double)sum(arr)/ arr.length;
    }

    public static int min(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int e: arr){
            min = Math.min(min, e);
        }

        return min;
    }

    public static int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int e: arr){
            max = Math.max(max, e);
        }

        return max;
    }


}
