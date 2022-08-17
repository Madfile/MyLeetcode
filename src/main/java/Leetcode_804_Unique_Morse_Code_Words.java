import java.util.HashSet;
import java.util.Set;

public class Leetcode_804_Unique_Morse_Code_Words {
    class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            Set<String> morseStringSet = new HashSet<>();
            String[] morses = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

            for (String s: words) {
                StringBuilder sb = new StringBuilder();
                for (char c: s.toCharArray()) {
                    sb.append(morses[c - 'a']);
                }

                String morseString = sb.toString();
                if (!morseStringSet.contains(morseString)) {
                    morseStringSet.add(morseString);
                }
            }

            return morseStringSet.size();
        }
    }
}
