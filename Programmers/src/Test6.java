import java.util.*;

public class Test6 {
    public static String[] a = {"abab", "bbaa", "bababa", "bbbabababbbaa"};
    public static HashMap <String, Boolean> hashMap;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(a)));
    }
    public static boolean[] solution(String[] a){
        int n = a.length;
        boolean[] answer = new boolean[n];

        hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            answer[i] = bfs("a", a[i]);
        }
        System.out.println(hashMap);
        return answer;
    }


    public static boolean bfs(String start, String target){
        if(start.equals(target)){
            return true;
        }

        HashMap<String, Integer> check = new HashMap<>();
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.add(start);
        check.put(start, 1);


        while(!deque.isEmpty()){
            String now = deque.pollFirst();
            int x = check.get(now);
            for (int i = 0; i < 3; i++) {
                StringBuilder next = new StringBuilder(now);

                if(i==0){ // 양쪽 끝 b 붙이기
                    for (int j = 0; j < x; j++) {
                        next.append("b");
                        next.insert(0, "b");
                    }
                    if(next.toString().equals(target)) return true;

                    if(next.length() <= target.length()){
                        check.put(next.toString(), check.get(now));
                        deque.addLast(next.toString());
                    }
                }else if(i==1){
                    next.insert(0, "a");
                    if(next.toString().equals(target)) return true;

                    if(next.length() <= target.length()){
                        check.put(next.toString(), check.get(now) + 1);
                        deque.addLast(next.toString());
                    }
                }else {
                    next.append("a");
                    if(next.toString().equals(target)) return true;

                    if(next.length() <= target.length()){
                        check.put(next.toString(), check.get(now) + 1);
                        deque.addLast(next.toString());
                    }
                }

            }
        }

        return false;
    }
}
