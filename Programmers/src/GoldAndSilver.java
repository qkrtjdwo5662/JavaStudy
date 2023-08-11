public class GoldAndSilver {
    public static int a = 90; // 채워야하는 금
    public static int b = 500; // 채워야하는 은
    public static int[] g = {70, 70, 0}; // 마을 별 금
    public static int[] s = {0, 0, 500}; // 마을 별 은
    public static int[] w = {100, 100, 2}; // 적재 가능한 무게
    public static int[] t = {4, 8, 1}; // 운반 퍈도 시간

    public static void main(String[] args) {
        System.out.println(solution(a, b, g, s, w, t));
    }

    public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t){
        long answer = (long) (10e9 * 2 * 10e5 * 2);
        int n = t.length;

        // 시간 이분탐색
        long start = 0;
        long end = (long) (10e9 * 2 * 10e5 * 2);



        while(start < end){
            long mid = (start + end) / 2;
            long gold = 0;
            long silver = 0;
            long mix = 0;

            for (int i = 0; i < n; i++) {
                long now_g = g[i];
                long now_s = s[i];
                long now_w = w[i];
                long now_t = t[i];

                long move = mid/ (now_t * 2);

                if(mid % (now_t * 2) >= now_t ){
                    move ++;
                }

                gold = gold + Math.min(now_g, move * now_w);
                silver = silver + Math.min(now_s, move * now_w);
                mix = mix + Math.min(now_g + now_s, move * now_w);

            }

            if(gold >= a && silver >= b && mix >= a+b){
                end = mid;
                answer = Math.min(mid, answer);
                continue;
            }
            start = mid + 1;


        }

        // 금과 은을 채우는데에 걸리는 총 시간?

        // 금과 은을 마지막 채웠을 떄는 편도로 계산


        return answer;
    }
}
