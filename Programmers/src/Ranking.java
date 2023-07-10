import java.util.*;

public class Ranking {
    public static int n = 5;
    public static int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

    public static ArrayList<Integer>[] adjList;
    public static ArrayList<Integer> arrayList;
    public static HashMap<Integer, Integer> hashMap;
    public static void main(String[] args) {
        System.out.println(solution(n, results));
    }
    public static int solution(int n, int[][] results){
        int answer = 0;

        adjList = new ArrayList[n+1];

        hashMap = new HashMap<>();
        arrayList = new ArrayList<>();

        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < results.length; i++) {
            adjList[results[i][0]].add(results[i][1]);
        }

        for (int i = 1; i <= n; i++) {
            hashMap.put(i, 0);
            if(hashMap.containsKey(i) && !arrayList.contains(i)){
                arrayList.add(i);
            }
            dfs(i);
        }

        answer = arrayList.size();
        System.out.println(arrayList);
        return answer;
    }
    public static void dfs(int n){
        for (int i = 0; i < adjList[n].size(); i++) {
            System.out.println(adjList[n].get(i));
            if(hashMap.containsKey(adjList[n].get(i)) && !arrayList.contains(adjList[n].get(i))){
                arrayList.add(adjList[n].get(i));
                hashMap.put(adjList[n].get(i), 0);
            }
            hashMap.put(adjList[n].get(i), 0);
            dfs(adjList[n].get(i));
        }
    }
}
