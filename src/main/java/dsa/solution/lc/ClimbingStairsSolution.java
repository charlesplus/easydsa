package dsa.solution.lc;

import dsa.annotation.RunSolution;
import dsa.solution.Solution;
import dsa.testcase.TestCaseSet;
import dsa.testcase.lc.ClimbingStairsTestCaseSet;

/**
 * Climbing Stairs Solution
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * Constraints:
 * - 1 <= n <= 45
 */
@RunSolution(runByDefault = true)
public class ClimbingStairsSolution implements Solution<Integer, Integer> {

    @Override
    public Integer solve(Integer n) {
        if (n <= 2) {
            return n;
        }

        int prev = 1;
        int curr = 2;

        for (int i = 3; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }

        return curr;
    }

    @Override
    public TestCaseSet<Integer, Integer> getTestCaseSet() {
        return ClimbingStairsTestCaseSet.getInstance();
    }
}