public class Leetcode_5242_Greatest_English_Letter_in_Upper_and_Lower_Case {
    class Solution {
        public String greatestLetter(String s) {
            int diff = 'a' - 'A';
            char biggest = 'A' - 1;

            for (char c: s.toCharArray()) {
                if (c > 'Z') {
                    for (char c2: s.toCharArray()) {
                        if (c2 == c - diff) {
                            if (c2 > biggest) {
                                biggest = c2;
                                break;
                            }
                        }
                    }
                } else {
                    for (char c2: s.toCharArray()) {
                        if (c2 == c + diff) {
                            if (c > biggest) {
                                biggest = c;
                                break;
                            }
                        }
                    }
                }
            }

            if (biggest == 'A' - 1) {
                return "";
            } else {
                return Character.toString(biggest);
            }
        }
    }
}
