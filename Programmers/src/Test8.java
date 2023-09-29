
public class Test8 {
//    public static String s = "centerminus";
//    public static String[] word_dict = {"cent", "center", "term", "terminus", "rm", "min", "minus", "us"};

    public static String s = "aaaababab";
    public static String[] word_dict = {"aaa", "aaaa", "ab", "bab", "aababa"};
    public static int answer;
    public static boolean[] visited;
    public static void main(String[] args) {
        System.out.println(solution(s, word_dict));
    }

    public static int solution(String s, String[] word_dict){
        answer = 0;
        int n = word_dict.length;


        backtrack(s, word_dict, 0, 0, 0);
        return answer;

    }
    public static void backtrack(String now, String[] word_dict, int count, int index, int num){
        if(now.equals("")){
            System.out.println(count);
            System.out.println(num);
            return;
        }

        while(!now.equals("")){
            if(now.startsWith(word_dict[index%word_dict.length])){
                if(now.equals(word_dict[index%word_dict.length])){
                    backtrack(now.replace(word_dict[index%word_dict.length], ""), word_dict, count+1, index+1, num+index);

                }else{
                    char last = word_dict[index].charAt(word_dict[index%word_dict.length].length()-1);
                    backtrack(last + now.replace(word_dict[index%word_dict.length], ""), word_dict, count+1, index+1, num+index);
                }
            }


            index++;
        }
        System.out.println(count);
    }
}
