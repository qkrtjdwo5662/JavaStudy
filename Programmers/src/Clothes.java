import java.util.HashMap;

public class Clothes {
    public static String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
    public static void main(String[] args) {
        System.out.println(solution(clothes));
    }
    public static int solution(String[][] clothes){
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if(hashMap.containsKey(clothes[i][1])){
               hashMap.put(clothes[i][1], hashMap.get(clothes[i][1])+1);
            }else hashMap.put(clothes[i][1],1);
        }

        for(String key : hashMap.keySet()){
            answer = answer * (hashMap.get(key)+1);
        }

        answer = answer -1;



        return answer;
    }
}
