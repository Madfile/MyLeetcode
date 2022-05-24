import java.util.*;

public class Leetcode_1249_Minimum_Remove_to_Make_Valid_Parentheses {
    class Solution {
        public String minRemoveToMakeValid(String s) {
            List<Character> result = new ArrayList<>();
            Map<Character, Character> brackets = new HashMap<Character, Character>();
            brackets.put('(' , ')');

            Deque<Character> stack = new ArrayDeque<>();
            for (char c: s.toCharArray()) {
                if (c != '(' && c != ')') {
                    result.add(c);
                } else if (c == '(') {
                    stack.push('(');
                    result.add(c);
                } else if (c == ')') {
                    if (stack.size() == 0) {
                        continue;
                    }

                    //char next = stack.poll();
                    stack.pop();
                    result.add(c);
                }
            }

            int left = stack.size();
            //remove the last left number of '('
            int i = result.size() - 1;
            while (i >= 0) {
                if (result.get(i) == '(' && left > 0) {
                    result.remove(i);
                    left--;
                }

                i--;
            }


            StringBuilder resultString = new StringBuilder();
            for(char c: result) {
                resultString.append(c);
            }

            return resultString.toString();
        }
    }
}
