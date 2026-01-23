package dsa.solution.lc;

import dsa.annotation.RunSolution;
import dsa.solution.Solution;
import dsa.testcase.TestCaseSet;
import dsa.testcase.lc.WordSearchTestCaseSet;
import lombok.Getter;

/**
 * Word Search Solution
 *
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example 1:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 * Example 2:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 *
 * Example 3:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 * Constraints:
 * - m == board.length
 * - n = board[i].length
 * - 1 <= m, n <= 6
 * - 1 <= word.length <= 15
 * - board and word consists of only lowercase and uppercase English letters.
 *
 * Follow-up: Could you use search pruning to make your solution faster with a larger board?
 */
@RunSolution(runByDefault = true)
public class WordSearchSolution implements Solution<Object[], Boolean> {
    @Getter
    private static final WordSearchSolution instance = new WordSearchSolution();
    private WordSearchSolution() {
    }

    @Override
    public Boolean solve(Object[] input) {
        char[][] board = (char[][]) input[0];
        String word = (String) input[1];

        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        // Try starting from each cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, 0, i, j, rows, cols)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int row, int col, int rows, int cols) {
        // Base case: if we've matched all characters
        if (index == word.length()) {
            return true;
        }

        // Check bounds and character match
        if (row < 0 || row >= rows || col < 0 || col >= cols ||
            board[row][col] != word.charAt(index) || board[row][col] == '#') {
            return false;
        }

        // Mark current cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore neighbors (up, down, left, right)
        boolean found = dfs(board, word, index + 1, row - 1, col, rows, cols) ||
                       dfs(board, word, index + 1, row + 1, col, rows, cols) ||
                       dfs(board, word, index + 1, row, col - 1, rows, cols) ||
                       dfs(board, word, index + 1, row, col + 1, rows, cols);

        // Restore the cell
        board[row][col] = temp;

        return found;
    }

    @Override
    public TestCaseSet<Object[], Boolean> getTestCaseSet() {
        return WordSearchTestCaseSet.getInstance();
    }
}