package dsa.solution.lc;

import dsa.solution.Solution;
import dsa.testcase.TestCaseSet;
import dsa.testcase.lc.TwoSumTestCaseSet;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum Solution
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 * Constraints:
 * - 2 <= nums.length <= 10^4
 * - -10^9 <= nums[i] <= 10^9
 * - -10^9 <= target <= 10^9
 * - Only one valid answer exists.
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?
 */
public class TwoSumSolution implements Solution<Pair<int[], Integer>, int[]> {
    @Getter
    private static final TwoSumSolution instance = new TwoSumSolution();
    private TwoSumSolution() {
    }

    @Override
    public int[] solve(Pair<int[], Integer> input) {
        int[] nums = input.getLeft();
        int target = input.getRight();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{}; // Should not reach here given problem constraints
    }

    @Override
    public TestCaseSet<Pair<int[], Integer>, int[]> getTestCaseSet() {
        return TwoSumTestCaseSet.getInstance();
    }
}