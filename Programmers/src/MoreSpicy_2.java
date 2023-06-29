import java.util.PriorityQueue;

public class MoreSpicy_2 {
    public static int[] scoville = {1,2,3,9,10,12};
    public static int K = 7;
    public static void main(String[] args) {
        System.out.println(solution(scoville, K));
    }
    public static int solution(int[] scoville, int K){
        int answer =0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]); // 우선순위 큐에 데이터 넣어주고
        }

        // 처음 꺼냈을 때 K 이상 경우의 예외처리
        int fisrt = pq.poll();
        if(fisrt >= K) return answer;
        else pq.add(fisrt);

        while(pq.size() > 2){ // 우선순위 큐 사이즈가 2보다 클 때만 반복
            int pollFirst = pq.poll();
            int pollSecond = pq.poll(); // 2개 꺼내주고

            int comb = pollFirst + (pollSecond*2); // 조합
            pq.add(comb); // 조합한거 넣어주고
            answer++; // 조합 완료 했으면 카운트 증가

            int poll = pq.poll(); // 새로 하나 꺼내보고
            if(poll >= K) return answer; // K 이상이면 answer 출력

            pq.add(poll); // 꺼낸거 다시 넣어주고
        }

        int pollFirst = pq.poll();
        int pollSecond = pq.poll();
        int comb = pollFirst + (pollSecond*2);
        answer = answer +1;

        if(comb>=K) return answer;
        else return -1;

    }
}
