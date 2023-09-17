import java.util.ArrayList;

public class Cache_6 {
    public static String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
    public static int cacheSize = 3;
    public static void main(String[] args) {
        System.out.println(solution(cacheSize, cities));
    }

    public static int solution(int cacheSize, String[] cities){
        ArrayList<String> arrayList = new ArrayList<>();
        int answer =0;

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            if(!arrayList.contains(city)){ // cache miss
                arrayList.add(city);
                if(arrayList.size() > cacheSize){
                    arrayList.remove(0);
                }
                answer = answer +5;
            }else{ // cache hit
                arrayList.remove(city);
                arrayList.add(city);
                answer = answer +1;
            }

        }
        return answer;
    }


}
