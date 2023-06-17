import java.util.ArrayList;
import java.util.Arrays;

public class AdjList {
    public static int input[][] = {{1,2},{2,3},{2,4},{5,2},{5,1},{5,4}};
    public static void main(String[] args) {
        int N=5;
        ArrayList<Integer>[] adjList = new ArrayList[N+1];

        System.out.println(Arrays.toString(adjList));

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        System.out.println(Arrays.toString(adjList));

        for (int i = 0; i <input.length ; i++) {
            adjList[input[i][0]].add(input[i][1]);
        }
        System.out.println(Arrays.toString(adjList));

        for (int i = 0; i < adjList[5].size(); i++) {
            System.out.print(adjList[5].get(i)+" ");
        }
        
    }
}
