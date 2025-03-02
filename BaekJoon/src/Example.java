import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        int n = 5;
        List<Integer>[] adjList = new ArrayList[n + 1];


        for (int i = 1; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }
        int m = 10;
        for (int i = 0; i < m; i++) {
            int u = 1;
            int v = 2;

            adjList[u].add(v);
            adjList[v].add(u);
        }


    }
}
