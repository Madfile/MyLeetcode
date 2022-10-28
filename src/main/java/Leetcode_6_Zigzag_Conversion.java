import java.util.ArrayList;
import java.util.List;

public class Leetcode_6_Zigzag_Conversion {
    class Solution {
        public String convert(String s, int numRows) {
        /*
        P   A   H   N
         A P L S I I G
          Y   I   R
        */

            //0, 1, 2, 3, 4, 5, 6, 7, 8
            //0, 1, 2, 1, 0, 1, 2, 1, 0,

            if (numRows == 1) return s;

            List<StringBuilder> sbs = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                sbs.add(new StringBuilder());
            }

            int i = 0;
            int n = 0;
            boolean up = true;

            while(i < s.length()) {
                sbs.get(n).append(s.charAt(i));
                if (n == numRows - 1) up = false;
                if (n == 0) up = true;

                if (up) n++;
                else n--;
                i++;
            }

            StringBuilder result = new StringBuilder();
            for (StringBuilder sb: sbs) {
                //System.out.println(sb.toString());

                result.append(sb.toString());
            }


            return result.toString();
        }
    }
}
