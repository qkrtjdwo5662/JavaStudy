import java.util.*;

public class BestAlbum {
    public static String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    public static int[] plays = {500, 600, 800, 800, 2500};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(genres, plays)));
    }
    public static int[] solution(String[] genres, int[] plays){
        // 장르 별 재생 횟수 total
        // total 비교하여 큰 것 부터 넣기
        HashMap<String, Integer> total = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            if (total.containsKey(genres[i])) {
                total.put(genres[i], total.get(genres[i]) + plays[i]);
            } else {
                total.put(genres[i], plays[i]);
            }
        }

        PriorityQueue<Integer> total_pq = new PriorityQueue<>(Collections.reverseOrder());
        for(String key: total.keySet()){
            total_pq.add(total.get(key));
        }

        while(!total_pq.isEmpty()){
            int total_poll = total_pq.poll(); // 하나 꺼내고 (내림차순 방향)
            for(String key: total.keySet()){ // 해쉬 맵 탐색해서
                if(total_poll == total.get(key)){
                    String s = key; // 해당 키 추출하고
                    PriorityQueue<Integer> plays_pq = new PriorityQueue<>(Collections.reverseOrder());
                    for (int i = 0; i < genres.length; i++) {
                        if(Objects.equals(s, genres[i])){ // genre 명 같은 것만
                            plays_pq.add(plays[i]); // pq에 넣어줌
                        }
                    }

                    if(plays_pq.size()==1){
                        int plays_poll = plays_pq.poll();
                        for (int i = 0; i < genres.length; i++) {
                            if(plays_poll == plays[i]){
                                arrayList.add(i);
                            }
                        }
                    }else{
                        int except = -1;
                        for (int i = 0; i < 2; i++) {
                            int plays_poll = plays_pq.poll();
                            for (int j = 0; j < genres.length; j++) {
                                if(plays_poll == plays[j]){
                                    if(j==except) continue;
                                    arrayList.add(j);
                                    except = j;
                                    break;
                                }
                            }
                        }
                    }

                }
            }
        }

        int[] answer =new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }
        return answer;
    }
}
