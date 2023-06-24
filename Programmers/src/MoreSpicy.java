import java.util.PriorityQueue;

public class MoreSpicy {
    public static int[] scoville = {1, 2, 3, 9, 10, 12};
    public static int K = 7;
    public static void main(String[] args) {
        System.out.println(solution(scoville, K));
    }
    public static int solution(int[] scoville, int K){
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        while(pq.size()>2){
            int first = pq.poll();
            int second = pq.poll();

            if(first>=K) return answer;

            int mix = first + second*2;
            answer++;
            pq.add(mix);

            int peek = pq.poll();
            if(peek>=K) return answer;
            else pq.add(peek);
        }

        if(pq.size()==2){
            int first = pq.poll();
            int second = pq.poll();

            int mix = first + second*2;
            answer++;
            if(mix>=K) return answer;
        }else return -1;


        return -1;
    }
}
