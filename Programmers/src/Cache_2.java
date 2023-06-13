import java.util.ArrayList;

public class Cache_2 {
    public static int cacheSize = 3;
    public static String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
    public static void main(String[] args) {
        System.out.println(solution(cacheSize, cities));
    }
    public static int solution(int cacheSize, String[] cities){
        int answer =0;

        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < cities.length; i++) {
            // arrayList 크기 비교
            String s = cities[i].toLowerCase();
            if(arrayList.size() < cacheSize){ // 작다면 존재하는지 확인 후 add
                if(arrayList.contains(s)){ // cache hit
                    arrayList.remove(s); // 삭제하고
                    arrayList.add(s); // 가장 끝에 삽입
                    answer = answer + 1;
                }else{ // cache miss
                    arrayList.add(s);
                    answer = answer + 5;
                }
            }else { // 크거나 같다면
                if(arrayList.contains(s)){
                    arrayList.remove(s); // 삭제하고
                    arrayList.add(s); // 가장 끝에 삽입
                    answer = answer + 1;
                }else{
                    arrayList.add(s);
                    arrayList.remove(0);
                    answer = answer +5;
                }
            }
        }


        return answer;
    }
}
