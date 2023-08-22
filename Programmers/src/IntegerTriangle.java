public class IntegerTriangle {
    public static int[][] triangle = {{7}, {3,8}, {8,1,0}, {2,7,4,4}, {4,5,2,6,5}};
    public static void main(String[] args) {
        System.out.println(solution(triangle));
    }

    public static int solution(int[][] triangle){
        int answer = 0;

        //         0 0
        //       1 0   1 1
        //     2 0  2 1  2 2
        //   3 0  3 1  3 2  3 3

        triangle[1][0] = triangle[0][0] + triangle[1][0];
        triangle[1][1] = triangle[0][0] + triangle[1][1];

        for (int i = 2; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if(j==0){
                    triangle[i][j] = triangle[i-1][j] + triangle[i][j];
                }else if(j==triangle[i].length-1){
                    triangle[i][j] = triangle[i-1][j-1] + triangle[i][j];
                }else{
                    triangle[i][j] = Math.max(triangle[i-1][j-1] + triangle[i][j], triangle[i-1][j] + triangle[i][j]);
                }
                answer = Math.max(answer, triangle[i][j]);
            }
        }

        return answer;
    }
}
