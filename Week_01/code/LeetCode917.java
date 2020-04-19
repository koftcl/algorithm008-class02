import org.junit.Test;

public class LeetCode917 {
    @Test
    public void name() {
        System.out.println(reverseOnlyLetters("?6C40E"));
    }

    @Test
    public void test1() {
        System.out.println((int)'A');
        System.out.println((int)'Z');
        System.out.println((int)'a');
        System.out.println((int)'z');
        System.out.println((int)']');
        System.out.println((int)'_');
    }

    public String reverseOnlyLetters(String S) {
        if (S == null) return null;
        int len = S.length();
        StringBuilder builder = new StringBuilder();

        int index = len - 1;
        for (int i = 0; i < len; i++) {
            char ch = S.charAt(i);
            if (isLetter(ch)) {
                while (!isLetter(S.charAt(index))) index--;
                builder.append(S.charAt(index));
                index--;
            } else {
                builder.append(ch);
            }
        }


        return builder.toString();

    }

    private boolean isLetter(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }
}
