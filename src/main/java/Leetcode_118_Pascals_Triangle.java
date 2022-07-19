import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                List<Integer> firstRow = new ArrayList<>();
                firstRow.add(1);
                result.add(firstRow);
            } else {
                int newLength = result.get(i - 1).size() + 1;
                List<Integer> newRow = new ArrayList<>();
                for (int j = 0; j < newLength; j++) {
                    if (j == 0 || j == newLength - 1) {
                        newRow.add(1);
                    } else {
                        newRow.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                    }
                }
                result.add(newRow);
            }
        }

        return result;
    }

//    better solution
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> ans = new ArrayList<>();
//        for (int i = 0; i < numRows; i++) {
//            List<Integer> sub = new ArrayList<>();
//            for (int j = 0; j <= i; j++) {
//                if (j == 0 || j == i) {
//                    sub.add(1);
//                } else {
//                    List<Integer> last = ans.get(i - 1);
//                    sub.add(last.get(j - 1) + last.get(j));
//                }
//
//            }
//            ans.add(sub);
//        }
//        return ans;
//    }
}
