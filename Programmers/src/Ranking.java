import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Ranking {
    static String[] user_scores;
    public static void main(String[] args) {
        user_scores = new String[]{"alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300", "cheries2 110"};

        solution(3,user_scores);
    }
    static int solution(int k, String[] user_scores){
        int answer = 0;
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < user_scores.length; i++) {
            map1.put(user_scores[i].split(" ")[0], Integer.valueOf(user_scores[i].split(" ")[1]));

            System.out.println("*map1*");
            for (String key : map1.keySet()) {
                int value = map1.get(key);
                System.out.println(key+" : "+value);
            }
            System.out.println("*map2*");
            for (String key : map2.keySet()) {
                int value = map2.get(key);
                System.out.println(key+" : "+value);
            }
            map2.put(user_scores[i].split(" ")[0], Integer.valueOf(user_scores[i].split(" ")[1]));
            System.out.println("*****");
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map1.entrySet());


        entryList.sort(Map.Entry.comparingByValue());
        System.out.println("----------------------------------------");
        for (HashMap.Entry<String, Integer> entry : entryList){
            System.out.println(entry.getKey() +" : "+entry.getValue());
        }
//        for (int i = 0; i < entryList.size(); i++) {
//            System.out.println(entryList.get(i));
//        }

        return answer;
    }
}
