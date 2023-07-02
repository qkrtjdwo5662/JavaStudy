import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class N_7662_TreeMap {
    public static TreeMap<Integer, Integer> treeMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 0; i < tc; i++) {
            st=  new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            treeMap = new TreeMap<>();
            for (int j = 0; j < n; j++) {
                st=  new StringTokenizer(br.readLine());
                String operation = st.nextToken();
                int num = Integer.parseInt(st.nextToken());


                if(operation.equals("I")){
                    if(treeMap.containsKey(num)){
                        treeMap.put(num, treeMap.get(num) + 1);
                    }else{
                        treeMap.put(num, 1);
                    }
                }else{
                    if(treeMap.size() == 0) continue;

                    if(num==-1){
                        treeMap.put(treeMap.firstKey(), treeMap.get(treeMap.firstKey()) - 1);
                        if(treeMap.get(treeMap.firstKey())<1){
                            treeMap.remove(treeMap.firstKey());
                        }
                    }else{
                        treeMap.put(treeMap.lastKey(), treeMap.get(treeMap.lastKey()) - 1);
                        if(treeMap.get(treeMap.lastKey())<1){
                            treeMap.remove(treeMap.lastKey());
                        }
                    }
                }
            }
            if(treeMap.size() ==0 ){
                sb.append("EMPTY").append("\n");
                continue;
            }
            sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
        }
        System.out.print(sb);
    }
}
