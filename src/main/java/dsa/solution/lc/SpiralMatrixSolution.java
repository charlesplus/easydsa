package dsa.solution.lc;

import dsa.annotation.RunSolution;
import dsa.solution.Solution;
import dsa.testcase.TestCaseSet;
import dsa.testcase.lc.SpiralMatrixTestCaseSet;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix Solution
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * Constraints:
 * - m == matrix.length
 * - n == matrix[i].length
 * - 1 <= m, n <= 10
 * - -100 <= matrix[i][j] <= 100
 */
@RunSolution(runByDefault = true)
public class SpiralMatrixSolution implements Solution<int[][], List<Integer>> {
    @Getter
    private static final SpiralMatrixSolution instance = new SpiralMatrixSolution();
    private SpiralMatrixSolution() {
    }

    @Override
    public List<Integer> solve(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse right
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            // Traverse down
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            // Traverse left (if there are rows left)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // Traverse up (if there are columns left)
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }

        return result;
    }

    @Override
    public TestCaseSet<int[][], List<Integer>> getTestCaseSet() {
        return SpiralMatrixTestCaseSet.getInstance();
    }
}