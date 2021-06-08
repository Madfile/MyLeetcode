import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode_20_Valid_Parentheses {
    //initial commit
    public boolean isValid(String s) {
        ArrayList<String> leftBracketsPool = new ArrayList<String>();
        ArrayList<String> leftBrakcets = new ArrayList<String>(Arrays.asList("(", "[", "{"));
        ArrayList<String> rightBrakcets = new ArrayList<String>(Arrays.asList(")", "]", "}"));

        for(int i = 0; i < s.length(); i++) {
            String charToTest = String.valueOf(s.charAt(i));
            if(leftBrakcets.contains(charToTest)) {
                leftBracketsPool.add(charToTest);
            }

            if (rightBrakcets.contains(charToTest)) {
                if (leftBracketsPool.size() == 0 || !leftBracketsPool.get(leftBracketsPool.size() - 1).equals(mapBracket(charToTest))) {
                    return false;
                } else {
                    leftBracketsPool.remove(leftBracketsPool.size() - 1);
                }
            }
        }

        if(leftBracketsPool.size() == 0) {
            return true;
        } else return false;
    }

    public String mapBracket(String bracket) {
        if(bracket.equals(")")) {
            return "(";
        } else if (bracket.equals("]")) {
            return "[";
        } else if (bracket.equals("}")) {
            return "{";
        } else return null;
    }
}

//optimal solution (use Stack)
//public boolean isValid(String s) {
//    Stack<Character>  brackets  = new Stack<Character>();
//    for(int i = 0;i < s.length();i++){
//        char c = s.charAt(i);
//        switch(c){
//            case '(':
//            case '[':
//            case '{':
//                brackets.push(c);
//                break;
//            case ')':
//                if(!brackets.empty()){
//                    if(brackets.peek()== '('){
//                        brackets.pop();
//                    }else{
//                        return false;
//                    }
//                }else{
//                    return false;
//                }
//                break;
//            case ']':
//                if(!brackets.empty()){
//                    if(brackets.peek()=='['){
//                        brackets.pop();
//                    }else{
//                        return false;
//                    }
//                }else{
//                    return false;
//                }
//                break;
//            case '}':
//                if(!brackets.empty()){
//                    if(brackets.peek()=='{'){
//                        brackets.pop();
//                    }else{
//                        return false;
//                    }
//                }else{
//                    return false;
//                }
//
//        }
//    }
//
//    return brackets.empty();
//}

