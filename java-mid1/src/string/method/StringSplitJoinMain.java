package string.method;

public class StringSplitJoinMain {
    public static void main(String[] args) {
        String str = "Apple,Banana,Orange";

        // split
        String[] splitStr = str.split(",");
        for (String s: splitStr) {
            System.out.println(s);
        }

        String joinStr = "";
        for(String string : splitStr){
            joinStr += string + "-";
        }
        System.out.println(joinStr);

        String joinedStr = String.join("-", "A", "B", "C");
        System.out.println(joinedStr);

        String result = String.join("-", splitStr);
        System.out.println(result);


    }
}
