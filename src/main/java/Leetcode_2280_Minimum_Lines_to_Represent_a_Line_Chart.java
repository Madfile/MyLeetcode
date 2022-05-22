import java.util.Arrays;

public class Leetcode_2280_Minimum_Lines_to_Represent_a_Line_Chart {
    class Solution {
        public int minimumLines(int[][] stockPrices) {
            int result = 1;

            if (stockPrices.length == 1) return 0;

            Arrays.sort(stockPrices, (a,b) -> a[0] - b[0]);
            for (int[] stockPrice: stockPrices) {
                System.out.println(Arrays.toString(stockPrice));
            }
            //System.out.println(Arrays.toString(stockPrices));

            int diffX = stockPrices[1][0] - stockPrices[0][0];
            int diffY = stockPrices[1][1] - stockPrices[0][1];


            for (int i = 2; i < stockPrices.length; i++) {
                int newDiffX = stockPrices[i][0] - stockPrices[i - 1][0];
                int newDiffY = stockPrices[i][1] - stockPrices[i - 1][1];
                if ((diffX * newDiffY) == (diffY * newDiffX)) {
                    continue;
                } else {
                    result++;
                    diffX = newDiffX;
                    diffY = newDiffY;
                }
            }

            return result;
        }
    }
}
