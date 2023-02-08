//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class permutation{
//    static int count =0;
//    static int arr[];
//    static boolean visited[];
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        long k = Long.parseLong(st.nextToken());
//
//        arr = new int[n];
//        visited = new boolean[n];
//
//        perm(arr,visited, 0,n,n,k);
//    }
//    static void perm(int[] arr, boolean visited[], int depth, int n,int r,int k){
//
//        if(depth == r ){
//            for (int i = 0; i < n; i++) {
//                System.out.print(arr[i] + " ");
//            }
//            System.out.println();
//            count = count+1;
//            solution(n,k);
//        }
//        for (int i = 0; i < n; i++) {
//            if(!visited[i]) {
//                visited[i] = true;
//                arr[depth] = i + 1;
//                perm(arr,visited,depth+1,n, n);
//                visited[i] = false;
//            }
//        }
//    }
//    static int[] solution(int n, long k){
//        int []answer = new int[n];
//        if(count ==k){
//
//        }
//        return answer;
//    }
//
//}