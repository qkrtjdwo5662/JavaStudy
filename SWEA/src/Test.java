public class Test {
    public static void main(String[] args) {
//        String s = "abcd";
//
//
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j < s.length() - i; j++) {
//                System.out.println(s.substring(j, j+i + 1));
//            }
//            System.out.println();
//        }


        String[][] arr = {{"1", "2", "3", "4"},{"4", "5", "6", "7"}, {"1", "2", "3", "4"}, {"4", "5", "6", "7"}};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i; j++) {
                for (int k = i; k < arr.length ; k++) {
                    String a = "";
                    for (int l = j; l < i+j + 1; l++) {
                        a = a + arr[k][l];
                    }
                    System.out.println(a);

                }

            }

        }
    }
}
