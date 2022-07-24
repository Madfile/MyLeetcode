public class Leetcode_240_Search_a_2D_Matrix_II {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            //my solution
            //1. binary search the angle line
            //2. binary search the row and the column
            //3. return result

            //Solution from Youtube
            int row = 0;
            int col = matrix[0].length - 1;
            int num;

            while(row <= matrix.length - 1 && col >= 0) {
                num = matrix[row][col];
                if (num == target) {
                    return true;
                } else if (num > target) {
                    col--;
                } else {
                    row++;
                }
            }

            return false;
        }
    }
}
