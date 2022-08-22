import java.util.Map;
import java.util.TreeMap;

public class Palindrome {
    public static void main(String[] args) {
        String S = "110900977723320";
        System.out.println(new Palindrome().solution(S));

    }

    public String solution(String S) {
        char[] sToChar = S.toCharArray();
        final Map<Character, Integer> charAmounts = new TreeMap<>();

        for (char c : sToChar) {
            if (charAmounts.containsKey(c)) {
                charAmounts.put(c, charAmounts.get(c) + 1);
            } else {
                charAmounts.put(c, 1);
            }
        }

        Character maxC = null;

        for (Map.Entry<Character, Integer> entry : charAmounts.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                if (maxC == null || maxC < entry.getKey()) {
                    maxC = entry.getKey();
                }
            }
        }


        if (maxC != null) {
            if (charAmounts.get(maxC) == 1) {
                charAmounts.remove(maxC);
            } else {
                charAmounts.put(maxC, charAmounts.get(maxC) - 1);
            }
        }


        Map<Character, Integer> finalLetters = new TreeMap<>();

        for (Map.Entry<Character, Integer> entry : charAmounts.entrySet()) {
            if (entry.getValue() > 1) {
                if (entry.getValue() % 2 == 1) {
                    finalLetters.put(entry.getKey(), entry.getValue() - 1);
                } else {
                    finalLetters.put(entry.getKey(), entry.getValue());
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : finalLetters.entrySet()) {
            stringBuilder.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue() / 2)));
        }

        String end = stringBuilder.toString();
        String start = stringBuilder.reverse().toString();

        return start + (maxC != null ? maxC : "") + end;
    }
}
