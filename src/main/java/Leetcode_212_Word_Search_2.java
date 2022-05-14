import java.util.*;

public class Leetcode_212_Word_Search_2 {
    //TODO: optimise with preTree
    int m;
    int n;

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;

        Set<String> result = new HashSet<String>();

        words = reverse(words);

        for (String word: words) {
            if (wordIsContained(word, result)) result.add(word);
            if (exist(board, word)) result.add(word);
        }

        return new ArrayList<>(result);
    }

    private boolean wordIsContained(String word, Set<String> result) {
        for (String candidate: result) {
            if (candidate.contains(word)) return true;
        }

        return false;
    }

    private String[] reverse(String[] str)
    {
        String[] result = new String[str.length];
        int j = str.length;
        for (int i = 0; i < str.length; i++) {
            result[j - 1] = str[i];
            j = j - 1;
        }

        return result;
    }

    private boolean exist(char[][] board, String word) {
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
