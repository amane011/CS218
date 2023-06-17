package Assignment3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MorseCode {
    private static Map<String, Character> morseToChar = new HashMap<String, Character>() {{
        put(".-", 'A'); put("-...", 'B'); put("-.-.", 'C'); put("-..", 'D');
        put(".", 'E'); put("..-.", 'F'); put("--.", 'G'); put("....", 'H');
        put("..", 'I'); put(".---", 'J'); put("-.-", 'K'); put(".-..", 'L');
        put("--", 'M'); put("-.", 'N'); put("---", 'O'); put(".--.", 'P');
        put("--.-", 'Q'); put(".-.", 'R'); put("...", 'S'); put("-", 'T');
        put("..-", 'U'); put("...-", 'V'); put(".--", 'W'); put("-..-", 'X');
        put("-.--", 'Y'); put("--..", 'Z');
    }};

    private static Map<Character, Integer> charToStroke = new HashMap<Character, Integer>() {{
        put('A', 3); put('B', 2); put('C', 1); put('D', 2);
        put('E', 3); put('F', 3); put('G', 2); put('H', 3);
        put('I', 3); put('J', 1); put('K', 2); put('L', 1);
        put('M', 2); put('N', 2); put('O', 1); put('P', 2);
        put('Q', 2); put('R', 2); put('S', 1); put('T', 2);
        put('U', 1); put('V', 1); put('W', 1); put('X', 2);
        put('Y', 2); put('Z', 1);
    }};

    public static void main(String[] args) {
        String X = "..--.-..-.";
        System.out.println(fewestStrokes(X));
    }
    public static int fewestStrokes(String X) {
        int n = X.length();
        int[] f = new int[n + 1];

        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String sub = X.substring(j, i);
                if (morseToChar.containsKey(sub)) {
                    char c = morseToChar.get(sub);
                    int strokeCount = charToStroke.get(c);
                    f[i] = Math.min(f[i], f[j] + strokeCount);
                }
            }
        }

        return f[n];
    }

}
