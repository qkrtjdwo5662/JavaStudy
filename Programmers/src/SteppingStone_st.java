import java.util.PriorityQueue;

public class SteppingStone_st {
    public static int[] stones = {2,4,5,3,2,1,4,2,5,1};
    public static int k = 3;

    public static int s_idx;
    public static int[] tree;
    public static void main(String[] args) {
        System.out.println(solution(stones, k));
    }

    public static int solution(int[] stones, int k){
        int n = stones.length;

        s_idx = 1;

        while(s_idx < n){
            s_idx *= 2;
        }

        tree = new int[s_idx *2];
        int answer = 0;

        for(int i=0; i<n; i++){
            update(i, stones[i]);
            answer = Math.max(answer, stones[i]);
        }

        for(int i=0; i< n-k +1; i++){
            int max = query(i, i+k-1);
            answer = Math.min(answer, max);
        }
        return answer;
    }

    public static int query(int left, int right){
        left = left + s_idx;
        right = right + s_idx;

        int max = 0;
        while(left<= right){
            if(left%2 == 1){
                max = Math.max(max, tree[left]);
            }

            if(right %2 == 0){
                max = Math.max(max, tree[right]);
            }

            left = (left+1)/2;
            right = (right-1)/2;
        }

        return max;
    }

    public static void update(int idx, int num){
        idx = idx + s_idx;
        tree[idx] = num;
        idx = idx/2;

        while(idx>=1){
            tree[idx] = Math.max(tree[idx*2], tree[idx*2 + 1]);
            idx = idx/2;
        }

    }
}
