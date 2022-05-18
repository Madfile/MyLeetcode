package src.main.java;

public class Leetcode_14_Longest_Common_Prefix {
    //Original Solution
    public String longestCommonPrefix(String[] strs) {
        String longestCommonPrefix = "";
        int commonPos = 0;

        String s = strs[0];
        for (int i=0; i<s.length(); i++) {
            if (matchesAllSubstrings(s.charAt(i), i, strs)) {
                commonPos += 1;
            } else {
                break;
            }
        }

        if (commonPos != 0) {
            longestCommonPrefix = s.substring(0, commonPos);
        }
        return longestCommonPrefix;
    }

    public boolean matchesAllSubstrings(char c, int pos, String[] strs) {
        for (String s: strs) {
            if (s.length() <= pos) return false;
            if (s.charAt(pos) != c) return false;
        }

        return true;
    }

}

