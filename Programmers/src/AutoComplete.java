public class AutoComplete {
    public static void main(String[] args) {
        String words[] = {"go","gone","guild"};
        System.out.println(solution(words));
    }
    static int solution(String[] words) {
        int answer = 0;
        int[] arr = new int[words.length];

        for (int i = 0; i < words.length-1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                for (int k = i+1; k < words.length; k++) {
                    if(words[i].charAt(j)==words[k].charAt(j)){
                        arr[i]++;
                        if(k==words.length-1){
                            arr[k]++;
                            System.out.println("?");
                        }

                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

        return answer;
    }
}
