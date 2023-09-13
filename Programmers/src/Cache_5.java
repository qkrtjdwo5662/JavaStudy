import java.util.ArrayList;

public class Cache_5 {
    public static int cacheSize = 3;
    public static String[] cities ={"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
    public static void main(String[] args) {
        System.out.println(solution(cacheSize, cities));
    }
    public static int solution(int cacheSize, String[] cities){
        int answer = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            if(!arrayList.contains(city)){

                arrayList.add(city);
                answer = answer + 5; // cache miss

                if(arrayList.size() > cacheSize) arrayList.remove(0);
            }else{
                arrayList.remove(city);
                arrayList.add(city); //최신화

                answer = answer + 1; // cache hit
            }
        }


        return answer;
    }
}
