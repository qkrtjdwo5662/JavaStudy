import java.util.ArrayList;

class FindDecimal{
	private static final String numbers = "17";
	private static final boolean [] visited = new boolean[7];
	static ArrayList<Integer> arrList = new ArrayList<>();
	private static final int length = numbers.length();
	public static void main(String[] args) {

//		solution(numbers);
		System.out.println(solution(numbers));
		
	}
	public static int solution(String numbers) {
		int answer = 0;
				
		for(int i=1; i<=length; i++) {
			backtrack("",i);
		}
		
		for(int i=0; i<arrList.size(); i++) {
			if(check(arrList.get(i))) answer++;
		}
		return answer;
		
	}
	public static void backtrack(String s, int depth) {
		if(s.length()==depth) {
			int num = Integer.parseInt(s);
			if(!arrList.contains(num)) {
				arrList.add(num);
			}
			return;
		}
		for(int i=0; i<numbers.length(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				backtrack(s+numbers.charAt(i), depth);
				visited[i] = false;
			}
		}
	}
	public static boolean check(int n) {
		if(n<2) return false;
		
		for(int i=2; i<n; i++) {
			if(n%i==0) return false;
		}
		
		return true;
	}
}