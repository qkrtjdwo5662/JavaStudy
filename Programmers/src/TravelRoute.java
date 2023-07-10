import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class TravelRoute {
//    public static String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
    public static String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

    public static ArrayList<String> list = new ArrayList<>();
    public static boolean[] useTickets;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(tickets)));
    }

    public static String[] solution(String[][] tickets){
        useTickets = new boolean[tickets.length];

        dfs(0, "ICN", "ICN", tickets);

        Collections.sort(list);

        return list.get(0).split(" ");
    }
    public static void dfs(int depth, String now, String path, String[][] tickets){
        if(depth == tickets.length){
            list.add(path);
            return;
        }

        for (int i = 0; i < useTickets.length; i++) {
            if(!useTickets[i] && now.equals(tickets[i][0])){
                useTickets[i] = true;
                dfs(depth+1, tickets[i][1], path + " " +tickets[i][1], tickets);
                useTickets[i] = false;
            }
        }
    }
}
