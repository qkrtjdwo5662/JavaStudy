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

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String s = "";

                s += arr[i][j];

                if(j != 3){
                    for (int k = j+1; k < 4 ; k++) {
                        s += arr[i][k];

                        System.out.println(s);
                    }
                }

            }
            System.out.println(" ");
            for (int j = 0; j < 4; j++) {
                String s = "";

                s += arr[j][i];

                if(j != 3){
                    for (int k = j+1; k < 4 ; k++) {
                        s += arr[k][i];

                        System.out.println(s);
                    }
                }

            }
        }
    }
}
