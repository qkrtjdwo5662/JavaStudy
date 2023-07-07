public class AdjMatrix {
    public static int[][] edges = {{1, 2}, {3, 1}, {3, 2}, {4, 1}, {5, 2}, {5, 4}}; // 간선
    public static int n = 5; // 정점의 수

    public static void main(String[] args) {
        int[][] matrix = new int[n+1][n+1]; // 0번 무시 1번 ~ 5번 정점만 사용

        for (int i = 0; i < edges.length; i++) {
            matrix[edges[i][0]][edges[i][1]] = 1;
            matrix[edges[i][1]][edges[i][0]] = 1;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
