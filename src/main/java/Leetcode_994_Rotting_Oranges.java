import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_994_Rotting_Oranges {
    class Solution {
        public int orangesRotting(int[][] grid) {
            int result = 0;
            int width = grid.length;
            int height = grid[0].length;
            boolean hasGoodOrange = false;

            int dirs[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
            Queue<int[]> rottenOranges = new LinkedList<>();

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if (grid[i][j] == 2) {
                        rottenOranges.offer(new int[]{i,j});
                    }
                    if (grid[i][j] == 1) {
                        hasGoodOrange = true;
                    }
                }
            }

            if (rottenOranges.size() == 0) {
                if (hasGoodOrange == true) {
                    return -1;
                } else {
                    return 0;
                }
            }

            while (rottenOranges.size() != 0) {
                int size = rottenOranges.size();
                for (int i = 0; i < size; i++) {
                    int[] rottenOrange = rottenOranges.poll();
                    for (int[] dir: dirs) {
                        int newX = rottenOrange[0] + dir[0];
                        int newY = rottenOrange[1] + dir[1];
                        if ( newX >= 0 && newX < width &&
                                newY >= 0 && newY < height) {
                            if (grid[newX][newY] == 1) {
                                grid[newX][newY] = 2;
                                rottenOranges.offer(new int[]{newX, newY});
                            }
                        }
                    }
                }

                result++;
                // for (int[] row: grid) {
                //      System.out.println(Arrays.toString(row));
                // }

            }

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }

            return result - 1;
        }
    }
}
