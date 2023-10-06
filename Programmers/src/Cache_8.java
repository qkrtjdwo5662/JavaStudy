import java.util.ArrayList;

public class Cache_8 {
    public static int cacheSize = 3;
    public static String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

    public static void main(String[] args) {
        System.out.println(solution(cacheSize, cities));
    }

    public static int solution(int cacheSize, String[] cities){
        int answer = 0;

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase(); // 대소문자 구분 X -> 대문자 OR 소문자 통일

            if(arrayList.contains(city)){ // cache hit 1
                arrayList.remove(city);
                arrayList.add(city);
                answer = answer+1;
                continue;
            }

            // cache miss 5
            arrayList.add(city);
            if(arrayList.size() > cacheSize){
                arrayList.remove(0);
            }
            answer = answer+5;
        }
        return answer;
    }
}
