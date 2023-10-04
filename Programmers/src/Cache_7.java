import java.util.ArrayList;

public class Cache_7 {
    public static int cacheSize = 3;
    public static String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
    public static void main(String[] args) {
        System.out.println(solution(cacheSize, cities));
    }

    public static int solution(int cacheSize, String[] cities){
        int answer = 0;

        ArrayList<String> cache = new ArrayList<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            if(!cache.contains(city)){
                cache.add(city);
                answer = answer + 5; // cache miss
                if(cache.size() > cacheSize) cache.remove(0);
            }else{
                cache.remove(city);
                cache.add(city);
                answer = answer+1; // cache hit
            }

        }

        return answer;
    }
}
