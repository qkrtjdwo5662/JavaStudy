import java.util.ArrayList;

public class Cache {
    public static int cacheSize = 3;
//    public static String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
    public static String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
    public static void main(String[] args) {
        // 페이지 교체 알고리즘
        // LRU : 가장 오랫동안 참조되지 않은 페이지를 교체

        // 알고리즘 구현 방식 -> ArrayList
        // 1. 대소문자 구분을 위해 cities 배열의 원소마다 toUpperCase() 메소드를 통해 대문자로 바꾸어줌

        // 2. ArrayList에 city가 원소로 포함되지 않았다면
        // 2-1. city를 포함하고 answer+5

        // 3. ArrayList에 city가 원소로 포함되었다면
        // 3-1. 기존에 포함되었던 city를 ArrayList에서 찾아 지우고,
        // 3-2. 새로 ArrayList에 city를 포함시킨 후 answer + 1

        // 4. ArrayList의 크기가 cacheSize보다 크다면
        // 4-1. 가장 나중에 포함된 원소를 제거

        System.out.println(solution(cacheSize, cities));
    }

    public static int solution(int cacheSize, String[] cities){
        int answer = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i=0; i< cities.length; i++){
            String city = cities[i].toUpperCase();
            if(!arrayList.contains(city)){
                arrayList.add(city);
                answer = answer + 5;
            }else {
                arrayList.remove(city);
                arrayList.add(city);
                answer = answer + 1;
            }

            if(arrayList.size()>cacheSize){
                arrayList.remove(0);
            }
        }

        return answer;
    }
}
