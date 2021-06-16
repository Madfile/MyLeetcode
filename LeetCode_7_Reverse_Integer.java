import com.sun.deploy.util.StringUtils;

public class LeetCode_7_Reverse_Integer {
    private boolean positive = true;

    public int reverse(int x) {
        positive = x >= 0;

        String strValue = String.valueOf(x);
        if (!positive) {
            strValue = strValue.substring(1);
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(strValue);
        stringBuilder.reverse();

        String newStr = stringBuilder.toString();
        long newValue = Long.valueOf(newStr);

        if (newValue > Integer.MAX_VALUE || newValue < Integer.MIN_VALUE) {
            return 0;
        }

        return positive ? (int)newValue : (int)newValue * (-1);
    }
}
