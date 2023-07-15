public class SportsWear {
    public static int n = 5;
    public static int[] lost = {2, 4};
    public static int[] reserve = {3};
    public static int[] rx = {-1, 1};
    public static void main(String[] args) {
        System.out.println(solution(n, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve){
        int answer = 0;

        int[] result = new int[n+1]; // 0 ~ 5 // 0 무시

        for (int i = 1; i <= n; i++) {
            result[i] = 1; // 기본 1
        }
        
        for (int i = 0; i < reserve.length; i++) {
            result[reserve[i]] = 2; // reserve 2
        }

        for (int i = 0; i < lost.length; i++) {
            if(result[lost[i]] == 2){
                result[lost[i]] = 1; // lost 1
            }else result[lost[i]] = 0; // lost 0
        }

        for (int i = 1; i <= n; i++) {
            if(result[i] == 0){ // lost
                for (int j = 0; j < 2; j++) {
                    int index = i+rx[j]; // -1, +1

                    if(index < 1 || index > n) continue; // 범위 넘어가면

                    if (result[index] == 2) {
                        result[index] = result[index]-1;
                        result[i] = 1;
                        break;
                    }
                }
            }
        }


        for (int i = 1; i <= n; i++) {
            if(result[i]>0) answer++;
        }
        

        
        return answer;
    }
}
