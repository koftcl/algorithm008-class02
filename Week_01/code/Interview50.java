import org.junit.Test;

public class Interview50 {
    @Test
    public void name() {
        System.out.println(firstUniqChar("cc"));
    }

    public char firstUniqChar(String s) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (array[ch - 'a'] == 0) {
                array[ch - 'a'] = i+1;
            } else {
                array[ch - 'a'] = s.length()+1;
            }
        }

        int min = s.length()+1;
        for (int i : array) {
            if (i == 0) continue;
            min = Math.min(i, min);
        }
        if (min == s.length()+1) return ' ';
        return s.charAt(min-1);
    }
}
