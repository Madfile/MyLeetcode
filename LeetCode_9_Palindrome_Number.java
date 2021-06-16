public class LeetCode_9_Palindrome_Number {
    public boolean isPalindrome(int x) {
        String strValue = String.valueOf(x);
        int fullLength = strValue.length();
        int halfLength = strValue.length() / 2;

        for (int i = 0; i < halfLength; i++) {
            if (strValue.charAt(i) != strValue.charAt(fullLength - i - 1)) {
                return false;
            }
        }

        return true;
    }

    //optimal solution, for the reverse part refer leetcode 7
//    public boolean isPalindrome(int x) {
//        if (x < 0) {
//            return false;
//        }
//        int digit = (int) (Math.log(x) / Math.log(10) + 1); //总位数
//        int revert = 0;
//        int pop = 0;
//        //倒置右半部分
//        for (int i = 0; i < digit / 2; i++) {
//            pop = x % 10;
//            revert = revert * 10 + pop;
//            x /= 10;
//        }
//        if (digit % 2 == 0 && x == revert) {
//            return true;
//        }
//        //奇数情况 x 除以 10 去除 1 位
//        if (digit % 2 != 0 && x / 10 == revert) {
//            return true;
//        }
//        return false;
//    }
}
