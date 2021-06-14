public class Leetcode_1071_Greatest_Common_Divisor_of_Strings {
    public String gcdOfStrings(String str1, String str2) {
        int lengthOfGCD = getGCD(str1.length(), str2.length());

        if (lengthOfGCD == -1) {
            return "";
        }

        String GCDStr = str1.substring(0, lengthOfGCD);
        if (canBeDivided(str1, GCDStr) && canBeDivided(str2, GCDStr)) {
            return GCDStr;
        } else {
            return "";
        }

    }

    public boolean canBeDivided(String s, String t) {
        int slength = s.length();
        int tLength = t.length();

        if (slength%tLength != 0) {
            return false;
        }

        String concat = "";
        for (int i = 0; i < slength/tLength; i++) {
            concat = concat.concat(t);
        }

        return concat.equals(s);
    }

    public int getGCD(int a, int b) {
        if (a < 0 || b < 0) {
            return -1;
        }
        if (b == 0) {
            return a;
        }
        return a % b == 0 ? b : getGCD(b, a % b);
    }
}
