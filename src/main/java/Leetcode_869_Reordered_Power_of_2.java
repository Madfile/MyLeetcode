import java.util.Arrays;

public class Leetcode_869_Reordered_Power_of_2 {
    class Solution {
        public boolean reorderedPowerOf2(int n) {
            String s = String.valueOf(n);
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            for (int i = 1; i < 1e9; i *= 2) {
                char[] temp = String.valueOf(i).toCharArray();
                Arrays.sort(temp);
                if (Arrays.equals(temp, chars)) {
                    return true;
                }
            }

            return false;
        }
    }
}
