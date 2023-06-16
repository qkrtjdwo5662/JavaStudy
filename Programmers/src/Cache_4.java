import java.util.ArrayDeque;

public class Cache_4 {
        public static int cacheSize = 3;
        public static String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        public static void main(String[] args) {
            System.out.println(solution(cacheSize, cities));
        }
        public static int solution(int cacheSize, String[] cities){
            int answer = 0;
            ArrayDeque<String> arrayDeque = new ArrayDeque<>();
            for (int i = 0; i < cities.length; i++) {
                String city = cities[i].toUpperCase();
                if(!arrayDeque.contains(city)){ // cache miss
                    arrayDeque.addFirst(city);
                    answer = answer + 5;
                    if(arrayDeque.size()>cacheSize){
                        arrayDeque.pollLast();
                    }
                }else{ // cache miss
                    arrayDeque.remove(city);
                    arrayDeque.addFirst(city);
                    answer = answer + 1;
                }
            }


            return answer;
        }

}
