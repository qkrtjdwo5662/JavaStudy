public class LeastCommonMultiple {
    public static int[] arr = {5, 7, 10, 14};
    public static void main(String[] args) {
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr){
        int answer = 0;

        if(arr.length == 1) return arr[0];

        int g = gcd(arr[0], arr[1]);
        answer = (arr[0] * arr[1]) / g;

        if(arr.length > 2) {
            for(int i = 2; i < arr.length; i++) {
                g = gcd(answer, arr[i]);
                answer = (answer * arr[i]) / g;
            }
        }

        return answer;
    }
    public static int gcd(int a, int b){
        int r = a % b;
        System.out.println("r: " + r);
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println();
        if(r==0) return b;
        else return gcd(b,r);
    }
}
