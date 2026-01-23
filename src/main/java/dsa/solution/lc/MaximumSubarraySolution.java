package dsa.solution.lc;

import dsa.annotation.RunSolution;
import dsa.solution.Solution;
import dsa.testcase.TestCaseSet;
import dsa.testcase.lc.MaximumSubarrayTestCaseSet;
import lombok.Getter;

/**
 * Maximum Subarray Solution
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * A subarray is a contiguous part of an array.
 *
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 *
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -10^4 <= nums[i] <= 10^4
 *
 * Follow-up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
@RunSolution(runByDefault = true)
public class MaximumSubarraySolution implements Solution<int[], Integer> {
    @Getter
    private static final MaximumSubarraySolution instance = new MaximumSubarraySolution();
    private MaximumSubarraySolution() {
    }

    @Override
    public Integer solve(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    @Override
    public TestCaseSet<int[], Integer> getTestCaseSet() {
        return MaximumSubarrayTestCaseSet.getInstance();
    }
}