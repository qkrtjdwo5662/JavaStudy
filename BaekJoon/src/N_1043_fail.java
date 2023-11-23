import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_1043_fail {

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 사람 수
        int m = Integer.parseInt(st.nextToken()); //  파티 수

        int[] parent = new int[n+1];

        for(int i=1; i<= n; i++){
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken()); // 진실 아는 사람 수

        for (int i = 0; i <tc ; i++) {
            int num = Integer.parseInt(st.nextToken());

            parent[num] = 0;
        }


        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int party = Integer.parseInt(st.nextToken()); // 파티 참가 인원
//            int[] people = new int[party]; // 파티 사람 담아줌
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < party; j++) {
                int num = Integer.parseInt(st.nextToken());
//                people[j] = num;
                list.add(num);
            }
            boolean flag = false;
            for (int j = 0; j < party; j++) {
                int num = list.get(j);

                if(parent[num] == 0){
                    flag = true;
                    break;
                }
            }

            if(flag){ // 진실 아는 사람이 한명이라도 존재하면
                for (int j = 0; j < party; j++) {
                    int num = list.get(j);

                    if(parent[num] != 0){
                        parent[num] = 0;
                    }
                }
            }

            arrayList.add(list);
        }

        int answer = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            ArrayList<Integer> list = arrayList.get(i);

            boolean check = false;
            for (int j = 0; j < list.size(); j++) {
                int num = list.get(j);

                if(parent[num] == 0){
                    check = true;
                    break;
                }
            }

            if(!check) answer ++;

        }

        System.out.println(answer);
    }
}
