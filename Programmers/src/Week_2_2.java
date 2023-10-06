import java.util.ArrayList;

public class Week_2_2 {
    public static int cacheSize = 3;
    public static String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

    public static void main(String[] args) {
        System.out.println(solution(cacheSize, cities));
    }

    public static int solution(int cacheSize, String[] cities){
        int answer = 0;

        ArrayList<String> cache = new ArrayList<>();

        for (int i = 0; i <cities.length ; i++) {
            String city = cities[i].toUpperCase();

            if(cache.contains(city)){ // cache hit 1
                cache.remove(city);
                cache.add(city);
                answer = answer +1;
                continue;
            }
            // cache miss 5
            cache.add(city);
            if(cache.size() > cacheSize){
                cache.remove(0); // 가장 오래전에 저장된 데이터 삭제
            }
            answer = answer+5;
        }
        return answer;
    }
}
