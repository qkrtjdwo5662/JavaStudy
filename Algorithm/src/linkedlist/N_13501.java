package linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N_13501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            LinkedList<Integer> linkedList = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                linkedList.addLast(num);
            }


            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                String opr = st.nextToken();

                if(opr.equals("I")){
                    int index = Integer.parseInt(st.nextToken());
                    int num = Integer.parseInt(st.nextToken());

                    linkedList.add(index, num);
                }else if(opr.equals("D")){
                    int index = Integer.parseInt(st.nextToken());

                    linkedList.remove(index);
                }else if(opr.equals("C")){
                    int index = Integer.parseInt(st.nextToken());
                    int num = Integer.parseInt(st.nextToken());

                    linkedList.set(index, num);
                }
            }
            sb.append("#").append(i).append(" ");
            if(linkedList.size() <= l){
                sb.append(-1).append("\n");
                continue;
            }

            sb.append(linkedList.get(l)).append("\n");
        }
        System.out.println(sb);


    }
}
