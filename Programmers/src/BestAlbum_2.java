import java.util.*;

public class BestAlbum_2 {
    public static String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    public static int[] plays = {500, 600, 150, 800, 2500};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    public static int[] solution(String[] genres, int[] plays){

        // 1. 장르별 재생 횟수의 합을 구한다.
        HashMap<String, Integer> total = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if(total.containsKey(genres[i])){
                total.put(genres[i], total.get(genres[i]) + plays[i]);
            }else total.put(genres[i], plays[i]);
        }

        System.out.println(total);

        //2. 장르별 재생 횟수의 우선 순위를 정해준다.
        PriorityQueue<Integer> total_pq = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순
        for (String key: total.keySet()) {
            total_pq.add(total.get(key));
        }

        ArrayList<Integer> arrayList = new ArrayList<>(); // answer 도출

        while(!total_pq.isEmpty()){ // 재생 순으로 우선순위 큐에서 꺼내주는데
            int total_pq_poll = total_pq.poll();
            String genre = null;
            for (String key: total.keySet()) {
               if(total.get(key) == total_pq_poll){
                   genre = key; // 해당 장르 명을 찾고
                   break;
               }
            }
            PriorityQueue<Integer> plays_pq = new PriorityQueue<>(Collections.reverseOrder()); // 재생횟수
            for (int i = 0; i < genres.length; i++) {
                if(Objects.equals(genres[i], genre)){  // key에 맞는 genre만 뽑기 위해
                    plays_pq.add(plays[i]);
                }
                //600, ,2500,2500 // 1, 4, 5
            }

            if(plays_pq.size()<2){ //
                int plays_pq_poll = plays_pq.poll();
                for (int i = 0; i < plays.length; i++) {
                    if(plays_pq_poll == plays[i]) arrayList.add(i);
                }
            }else{
                int except = -1; // 같은 재생횟소를 가진 고유번호 제외
                for (int i = 0; i < 2; i++) {
                    int plays_pq_poll = plays_pq.poll();
                    for (int j = 0; j < plays.length; j++) {
                        if(plays_pq_poll == plays[j]) {
                            if(except == j) continue;
                            arrayList.add(j);
                            except = j;
                            break;
                        }
                    }
                }
            }
        }

        int[] answer = new int[arrayList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrayList.get(i);
        }
        return answer;
    }
}
