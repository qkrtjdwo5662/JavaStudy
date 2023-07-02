public class SkillCheck2 {
    public static int x = 10;
    public static int y = 40;
    public static int n = 5;
    public static void main(String[] args) {
        System.out.println(solution(x, y, n));
    }

    public static int solution(int x, int y, int n){
        int answer = 0;

        int[] arr = new int[y+1];

        int index = x;
        int count = 0;

        while(index < arr.length){ // X2 처리
            arr[index] = count;

            count++;
            index = index*2;
        }

        index = x;
        count = 0;
        while(index < arr.length){ // X2 처리
            arr[index] = count;

            count++;
            index = index*3;
        }

        index = x;
        count = 0;
        while(index < arr.length){ // X2 처리
            arr[index] = count;

            count++;
            index = index+n;
        }


        System.out.println(arr[40]);

        return answer;
    }
}
