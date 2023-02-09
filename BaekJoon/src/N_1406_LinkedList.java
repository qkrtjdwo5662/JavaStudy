import java.io.*;
import java.util.LinkedList;

public class N_1406_LinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        LinkedList<Character>linked = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            linked.addLast(s.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());
        int index=linked.size();

        for (int i = 0; i < n; i++) {
            String k=br.readLine();
            switch (k.charAt(0)){
                case 'P':
                    linked.add(index,k.charAt(2));
                    index = index+1;
                    break;
                case 'L':
                    index--;
                    if(index<0){
                        index =0;
                    }
                    break;
                case 'D':
                    index++;
                    if(index>linked.size()){
                        index = linked.size();
                    }
                    break;
                case 'B':
                    if(index<=0){
                        index=0;
                        break;
                    }
                    if(!linked.isEmpty()){
                        linked.remove(--index);
                    }else break;

            }

        }
        while(!linked.isEmpty()){
            bw.write(linked.pollFirst());
        }
        bw.flush();
        bw.close();

    }
}
