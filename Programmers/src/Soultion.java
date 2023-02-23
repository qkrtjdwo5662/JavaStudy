public class Soultion {
    public static void main(String[] args) {
        int[][] lines = {{0,1},{2,5},{3,9}};
//        int[][] lines = {{-1,1},{1,3},{3,9}};
//        int[][] lines = {{0,5},{3,9},{1,10}};
        System.out.println(s(lines));
    }
    static int s(int[][] lines){
        int answer = 0;
        int[] check = new int[200];
        for (int i = 0; i < lines.length; i++) {
            for (int j = lines[i][0]; j <= lines[i][1]; j++) {
                check[100+j]++;
            }
        }
        for (int i = 0; i < check.length-1; i++) {
            if(check[i]>1 && check[i+1]>1){
                answer++;
            }
        }

        return answer;
    }
}
