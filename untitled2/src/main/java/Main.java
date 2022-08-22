public class Main {

    Boolean solution( String S) {
        boolean b = false;
        for (Character c: S.toCharArray()) {
            if (c == 'a') {
                if (b) {
                    return false;
                }
            }
            if (c == 'b') {
                b = true;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String S = "abba";
        System.out.println(new Main().solution(S));

    }
}
