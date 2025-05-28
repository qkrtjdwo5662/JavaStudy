import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_4446 {
    static final char[] VOWELS = {'a', 'i', 'y', 'e', 'o', 'u'};
    static final HashMap<Character, Integer> VOWELS_MAP = new HashMap<>();

    static final char[] CONSTANTS = {'b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w',
            'g', 'p', 'v', 'j', 'q', 't', 's', 'r', 'l', 'm', 'f'};
    static final HashMap<Character, Integer> CONSTANTS_MAP = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        VOWELS_MAP.put('a', 0);
        VOWELS_MAP.put('i', 1);
        VOWELS_MAP.put('y', 2);
        VOWELS_MAP.put('e', 3);
        VOWELS_MAP.put('o', 4);
        VOWELS_MAP.put('u', 5);

        CONSTANTS_MAP.put('b', 0);
        CONSTANTS_MAP.put('k', 1);
        CONSTANTS_MAP.put('x', 2);
        CONSTANTS_MAP.put('z', 3);
        CONSTANTS_MAP.put('n', 4);
        CONSTANTS_MAP.put('h', 5);
        CONSTANTS_MAP.put('d', 6);
        CONSTANTS_MAP.put('c', 7);
        CONSTANTS_MAP.put('w', 8);
        CONSTANTS_MAP.put('g', 9);
        CONSTANTS_MAP.put('p', 10);
        CONSTANTS_MAP.put('v', 11);
        CONSTANTS_MAP.put('j', 12);
        CONSTANTS_MAP.put('q', 13);
        CONSTANTS_MAP.put('t', 14);
        CONSTANTS_MAP.put('s', 15);
        CONSTANTS_MAP.put('r', 16);
        CONSTANTS_MAP.put('l', 17);
        CONSTANTS_MAP.put('m', 18);
        CONSTANTS_MAP.put('f', 19);

        String s;
        while((s = br.readLine()) != null && !s.isEmpty()) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c >= 65 && c <= 90) {
                    if (VOWELS_MAP.containsKey((char) (c + 32))) {
                        int index = VOWELS_MAP.get((char) (c + 32));
                        sb.append((char) (VOWELS[(index + 3) % VOWELS.length] - 32));
                    } else {
                        int index = CONSTANTS_MAP.get((char) (c + 32));
                        sb.append((char) (CONSTANTS[(index + 10) % CONSTANTS.length] - 32));
                    }
                } else if (c >= 97 && c <= 122) {
                    if (VOWELS_MAP.containsKey(c)) {
                        int index = VOWELS_MAP.get(c);
                        sb.append((VOWELS[(index + 3) % VOWELS.length]));
                    } else {
                        int index = CONSTANTS_MAP.get((c));
                        sb.append((CONSTANTS[(index + 10) % CONSTANTS.length]));
                    }
                } else {
                    sb.append(c);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
