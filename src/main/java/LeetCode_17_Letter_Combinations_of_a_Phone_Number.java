package src.main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//initial commitment
public class LeetCode_17_Letter_Combinations_of_a_Phone_Number {
    private static final ArrayList<String> button2Characters = new ArrayList<String>(Arrays.asList("a", "b", "c"));
    private static final ArrayList<String> button3Characters = new ArrayList<String>(Arrays.asList("d", "e", "f"));
    private static final ArrayList<String> button4Characters = new ArrayList<String>(Arrays.asList("g", "h", "i"));
    private static final ArrayList<String> button5Characters = new ArrayList<String>(Arrays.asList("j", "k", "l"));
    private static final ArrayList<String> button6Characters = new ArrayList<String>(Arrays.asList("m", "n", "o"));
    private static final ArrayList<String> button7Characters = new ArrayList<String>(Arrays.asList("p", "q", "r", "s"));
    private static final ArrayList<String> button8Characters = new ArrayList<String>(Arrays.asList("t", "u", "v"));
    private static final ArrayList<String> button9Characters = new ArrayList<String>(Arrays.asList("w", "x", "y", "z"));

    public List<String> letterCombinations(String digits) {

        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < digits.length(); i++) {
           result = append(result, digits.charAt(i));
        }

        return result;
    }

    public ArrayList<String> append(ArrayList<String> input, Character character) {
        ArrayList<String> charactersToAdd = new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();

        switch(character) {
            case '2':
                charactersToAdd = button2Characters;
                break;
            case '3':
                charactersToAdd = button3Characters;
                break;
            case '4':
                charactersToAdd = button4Characters;
                break;
            case '5':
                charactersToAdd = button5Characters;
                break;
            case '6':
                charactersToAdd = button6Characters;
                break;
            case '7':
                charactersToAdd = button7Characters;
                break;
            case '8':
                charactersToAdd = button8Characters;
                break;
            case '9':
                charactersToAdd = button9Characters;
                break;
        }

        if (input.size() == 0) {
            return charactersToAdd;
        } else {
            for (String s: input) {
                for (String newCharacter: charactersToAdd) {
                    result.add(s.concat(newCharacter));
                }
            }
        }

        return result;
    }
}

//an optimal solution for multiplying list
//public List<String> letterCombinations(String digits) {
//    List<String> ans = new ArrayList<String>();
//    for (int i = 0; i < digits.length(); i++) {
//        ans = mul(ans, getList(digits.charAt(i) - '0'));
//    }
//    return ans;
//
//}
//
//    public List<String> getList(int digit) {
//        String digitLetter[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
//        List<String> ans = new ArrayList<String>();
//        for (int i = 0; i < digitLetter[digit].length(); i++) {
//            ans.add(digitLetter[digit].charAt(i) + "");
//        }
//        return ans;
//    }
//    //定义成两个 List 相乘
//    public List<String> mul(List<String> l1, List<String> l2) {
//        if (l1.size() != 0 && l2.size() == 0) {
//            return l1;
//        }
//        if (l1.size() == 0 && l2.size() != 0) {
//            return l2;
//        }
//        List<String> ans = new ArrayList<String>();
//        for (int i = 0; i < l1.size(); i++)
//            for (int j = 0; j < l2.size(); j++) {
//                ans.add(l1.get(i) + l2.get(j));
//            }
//        return ans;
//    }
//
//
//soluction 2: iterate on LinkedList
//public List<String> letterCombinations(String digits) {
//    LinkedList<String> ans = new LinkedList<String>();
//    if(digits.isEmpty()) return ans;
//    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//    ans.add("");
//    for(int i =0; i<digits.length();i++){
//        int x = Character.getNumericValue(digits.charAt(i));
//        while(ans.peek().length()==i){ //查看队首元素
//            String t = ans.remove(); //队首元素出队
//            for(char s : mapping[x].toCharArray())
//                ans.add(t+s);
//        }
//    }
//    return ans;
//}
//
//
//
//solution 3: dynamic solution
//private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
//
//    public List<String> letterCombinations(String digits) {
//        if(digits.equals("")) {
//            return new ArrayList<String>();
//        }
//        List<String> ret = new LinkedList<String>();
//        combination("", digits, 0, ret);
//        return ret;
//    }
//
//    private void combination(String prefix, String digits, int offset, List<String> ret) {
//        //offset 代表在加哪个数字
//        if (offset == digits.length()) {
//            ret.add(prefix);
//            return;
//        }
//        String letters = KEYS[(digits.charAt(offset) - '0')];
//        for (int i = 0; i < letters.length(); i++) {
//            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
//        }
//    }
