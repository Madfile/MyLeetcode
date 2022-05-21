public class Leetcode_79_Word_Search {
    int m;
    int n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = 0;
                boolean[][] visited = new boolean[m][n];
                if (wordExist(word, index, i, j, board, visited)) {
                    return true;
                } else {
                    continue;
                }
            }
        }

        return false;
    }
    //A, B, C, E
    //S, F, E, S
    //A, D, E, E

    private boolean wordExist(String word, int index, int i, int j, char[][] board, boolean[][] visited) {
        char next = word.charAt(index);
        if (i > m - 1 || i < 0) return false;
        if (j > n - 1 || j < 0) return false;
        if (visited[i][j] == true) return false;

        char current = board[i][j];
        if (current == next) {
            if (index == word.length() - 1) return true;

            visited[i][j] = true;
            if (wordExist(word, index + 1, i + 1, j, board, visited)) return true;
            if (wordExist(word, index + 1, i, j + 1, board, visited)) return true;
            if (wordExist(word, index + 1, i - 1, j, board, visited)) return true;
            if (wordExist(word, index + 1, i, j - 1, board, visited)) return true;
            visited[i][j] = false;
        } else {
            return false;
        }

        return false;
    }
}
