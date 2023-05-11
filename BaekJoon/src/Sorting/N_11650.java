package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_11650 {
    private static class Emp {
        int x, y;
        public Emp(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Emp[] emp = new Emp[n];
        for (int i = 0; i < emp.length; i++) {
            st = new StringTokenizer(br.readLine());
            emp[i] = new Emp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(emp, (o1, o2) -> {
            if(o1.x==o2.x){
                return Integer.compare(o1.y, o2.y);
            }
            return Integer.compare(o1.x, o2.x);
        });
        for (int i = 0; i < emp.length; i++) {
            System.out.println(emp[i].x +" "+ emp[i].y);
        }

    }
}
