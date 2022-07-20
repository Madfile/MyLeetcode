public class Leetcode_792_Number_of_Matching_Subsequences {
    class Solution {
        //abcde
        //ace
        public int numMatchingSubseq(String s, String[] words) {
            int res = 0;
            char[] chars = s.toCharArray();

            for (String word: words) {
                if (isSubsequence(chars, word)) {
                    res++;
                }
            }

            return res;
        }

        private boolean isSubsequence(char[] chars, String word) {
            char[] charsToPair = word.toCharArray();
            int i = 0;
            int j = 0;

            while(i < chars.length && j < word.length()) {
                if (word.charAt(j) == chars[i]) {
                    j++;
                }

                i++;
            }

            if (j == word.length()) {
                return true;
            } else {
                return false;
            }
        }
    }

//    better solution
//    class Solution {
//        public int numMatchingSubseq(String S, String[] words) {
//            int res = 0;
//
//            Map<Character, Queue<String>> map = new HashMap<>();
//
//            for (char c : S.toCharArray()) {
//                if (!map.containsKey(c)) {
//                    map.put(c, new LinkedList<>());
//                }
//            }
//
//            for (String word : words) {
//                if (word.length() > S.length()) continue;
//
//                if (map.containsKey(word.charAt(0))) {
//                    map.get(word.charAt(0)).add(word);
//                }
//            }
//
//            for (char c : S.toCharArray()) {
//                Queue<String> queue = map.get(c);
//
//                int size = queue.size();
//
//                for (int i = 0; i < size; i++) {
//                    String curWord = queue.remove();
//
//                    if (curWord.length() == 1) {
//                        ++res;
//                    }
//                    else if (map.containsKey(curWord.charAt(1))) {
//                        map.get(curWord.charAt(1)).add(curWord.substring(1));
//                    }
//                }
//            }
//            return res;
//        }
//    }
}
