public class Leetcode_28_Implement_strStr {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 || needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (contains(i, haystack, needle)) {
                return i;
            }
        }

        return -1;
    }

    public boolean contains(int index, String haystack, String needle) {
        for (int i = 0; i < needle.length(); i++) {
            if (haystack.charAt(i + index) != needle.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
