public class Leetcode_200_Number_Of_Islands {
    class Solution {
        int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

        public int numIslands(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int result = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        dfs(i, j, grid, m, n);
                        result++;
                    }
                }
            }

            return result;
        }

        private void dfs(int i, int j, char[][] grid, int m, int n) {
            if (grid[i][j] == '0') {
                return;
            } else {
                grid[i][j] = '0';
                for (int[] dir: directions) {
                    if ((i + dir[0] >= 0) && (i + dir[0] < m) && (j + dir[1] >= 0) && (j + dir[1] < n)) {
                        dfs(i + dir[0], j + dir[1], grid, m, n);
                    }
                }
            }
        }
    }
}
