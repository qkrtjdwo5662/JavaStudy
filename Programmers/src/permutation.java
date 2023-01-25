//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class permutation {
//    static int n;
//    static long k;
//    static int[] arr;
//    static int depth;
//    static boolean[] visited;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken());
//        k  = Long.parseLong(st.nextToken());
//
//        arr = new int[n];
//        visited = new boolean[n];
//        depth = 0;
//        solution(n,k);
//    }
//    static public int[] solution(int n, long k){
//        int[] answer = {};
//
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
//
//        for (int i = 0; i < n; i++) {
//            if(!visited[i]){
//                visited[i] = true;
//                arr[depth] = i+1;
//                solution()
//
//            }
//        }
//
//
//        return answer;
//    }
//}
