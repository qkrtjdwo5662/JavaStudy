public class NetWork {
    static int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
    public static void main(String[] args) {
        System.out.println(soultion(3,computers));
    }

    static int soultion(int n, int[][] computers){
        int answer = 0;
        boolean check[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!check[i]){
                dfs(computers, i, check);
                answer++;
            }
        }

        return answer;
    }
    static boolean[] dfs(int[][] computers, int i, boolean[] check){
        check[i] = true;

        for (int j = 0; j < computers.length; j++) {
            if(i!=j && computers[i][j]==1 && check[j]==false){
                check = dfs(computers,j,check);
            }
        }
        return check;
    }

}
