import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 회의실 개수
        int m = Integer.parseInt(st.nextToken()); // 회의 예약 수

        HashMap<String, ArrayList<int[]>> hashMap = new HashMap<>();
        TreeSet<String> treeSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            hashMap.put(name, new ArrayList<>()); // 기본 세팅
            treeSet.add(name);
        }

        System.out.println(hashMap);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            ArrayList<int[]> arr = hashMap.get(name);
            arr.add(new int[]{start, end});
            hashMap.put(name, arr);
        }



        for(String s : treeSet){
            ArrayList<int[]> arrayList = hashMap.get(s);
            boolean[] check  = new boolean[19];
            for (int i = 0; i < arrayList.size(); i++) {
                int start = arrayList.get(i)[0];
                int end = arrayList.get(i)[1];

                for (int j = start + 1; j <= end; j++) {
                    check[j] = true;
                }
                if(check[10]) check[9] = true;

            }
            System.out.println(s);
            int index =9;
            for (int i = index; i < 19; i++) {
                System.out.println(i+ " " + index);
                if(i==9 && !check[i]){
                    while(true){
                        if(check[index]) break;
                        index++;
                    }
                    System.out.println(9 + " ~ " + (index));
                    continue;
                }

                if(i!=9 && !check[i]){
                    while(true){
                        if(check[index]) break;
                        index++;
                    }
                    System.out.println(i + " ~ " + index);
                }
            }

        }
    }
}
