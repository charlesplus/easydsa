package dsa.solution.leetcode;

import dsa.solution.Solution;
import dsa.testcase.TestCaseSet;
import dsa.testcase.leetcode.UniquePathsTestCaseSet;
import lombok.Getter;

/**
 * Unique Paths Solution
 *
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * Example 1:
 * Input: m = 3, n = 7
 * Output: 28
 *
 * Example 2:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 *
 * Constraints:
 * - 1 <= m, n <= 100
 */
public class UniquePathsSolution implements Solution<int[], Integer> {
    @Getter
    private static final UniquePathsSolution instance = new UniquePathsSolution();
    private UniquePathsSolution() {
    }

    @Override
    public Integer solve(int[] input) {
        int m = input[0]; // number of rows
        int n = input[1]; // number of columns

        // Create a 2D array to store the number of unique paths to each cell
        int[][] dp = new int[m][n];

        // Initialize the first row and first column to 1
        // since there's only one way to reach any cell in the first row/column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill the rest of the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1]; // paths from top + paths from left
            }
        }

        return dp[m-1][n-1];
    }

    @Override
    public TestCaseSet<int[], Integer> getTestCaseSet() {
        return UniquePathsTestCaseSet.getInstance();
    }
}