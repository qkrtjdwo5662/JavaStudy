import java.util.ArrayDeque;

public class Cache_3 {
    public static int cacheSize = 3;
    public static String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
    public static void main(String[] args) {
        System.out.println(solution(cacheSize, cities));
    }
    public static int solution(int cacheSize, String[] cities){
        int answer =0;
        ArrayDeque<String> deque = new ArrayDeque<>();

        for (int i = 0; i < cities.length; i++) {
            String s = cities[i].toLowerCase(); // 대소문자 구분 x

            if(deque.contains(s)){ // 존재하면
                deque.remove(s); // 있던거 삭제
                deque.addFirst(s); // 최신에 추가
                answer = answer + 1; // cache hit
            }else{ // 존재하지 않을때만 사이즈가 변함
                deque.addFirst(s); // 최신에 추가
                if(deque.size()>cacheSize){ // 사이즈 넘치면
                    deque.pollLast(); // 오래된 거 삭제
                }
                answer = answer + 5; // cache miss
            }
        }


        return answer;
    }
}
