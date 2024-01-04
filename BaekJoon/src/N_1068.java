import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1068 {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        int[] parents = new int[n]; // 부모 정보
        ArrayList<Integer>[] nodeList = new ArrayList[n]; // 부모 - 자식
        for (int i = 0; i < n; i++) {
            nodeList[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int root = -1;
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            parents[i] = parent;

            if(parent == -1) {
                root = i;
                continue;
            }
            nodeList[parent].add(i);
        }

        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        if(root == v) {
            System.out.println(0);
            return;
        }
        removeNode(nodeList, parents, v);
        int answer = countLeaf(nodeList, root);
        System.out.println(answer);


    }
    public static int countLeaf(ArrayList<Integer>[] nodeList, int start){
        boolean[] visited = new boolean[n];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        visited[start] = true;
        deque.addLast(start);
        int count = 0;
        while(!deque.isEmpty()){
            int now = deque.pollFirst();

            if(nodeList[now].size() == 0){
                count++;
            }

            for (int i = 0; i < nodeList[now].size(); i++) {
                int next=  nodeList[now].get(i);

                if(!visited[next]){
                    visited[next] = true;
                    deque.addLast(next);
                }
            }
        }

        return count;
    }

    public static void removeNode(ArrayList<Integer>[] nodeList, int[] parents, int v){
        nodeList[v].clear();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nodeList[i].size(); j++) {
                if(nodeList[i].get(j) == v){
                    nodeList[i].remove(Integer.valueOf(v));
                }
            }
        }


    }
}
