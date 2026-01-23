package dsa.solution.lc;

import dsa.annotation.RunSolution;
import dsa.solution.Solution;
import dsa.testcase.TestCaseSet;
import dsa.testcase.lc.RemoveDuplicatesFromSortedArrayTestCaseSet;
import lombok.Getter;

/**
 * Remove Duplicates from Sorted Array Solution
 *
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * Then return the number of unique elements in nums.
 *
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially.
 * The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 *
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Example 2:
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Constraints:
 * - 1 <= nums.length <= 3 * 10^4
 * - -100 <= nums[i] <= 100
 * - nums is sorted in non-decreasing order.
 */
@RunSolution(runByDefault = true)
public class RemoveDuplicatesFromSortedArraySolution implements Solution<int[], Integer> {
    @Getter
    private static final RemoveDuplicatesFromSortedArraySolution instance = new RemoveDuplicatesFromSortedArraySolution();
    private RemoveDuplicatesFromSortedArraySolution() {
    }

    @Override
    public Integer solve(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    @Override
    public TestCaseSet<int[], Integer> getTestCaseSet() {
        return RemoveDuplicatesFromSortedArrayTestCaseSet.getInstance();
    }
}