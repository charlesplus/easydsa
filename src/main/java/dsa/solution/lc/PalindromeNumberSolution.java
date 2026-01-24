package dsa.solution.lc;

import dsa.annotation.RunSolution;
import dsa.solution.Solution;
import dsa.testcase.TestCaseSet;
import dsa.testcase.lc.PalindromeNumberTestCaseSet;

/**
 * Palindrome Number Solution
 *
 * Given an integer x, return true if x is palindrome integer.
 * An integer is a palindrome when it reads the same backward as forward.
 * For example, 121 is palindrome while 123 is not.
 *
 * Example 1:
 * Input: x = 121
 * Output: true
 *
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome number.
 *
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome number.
 *
 * Constraints:
 * - -2^31 <= x <= 2^31 - 1
 *
 * Follow-up: Could you solve it without converting the integer to a string?
 */
@RunSolution(runByDefault = true)
public class PalindromeNumberSolution implements Solution<Integer, Boolean> {

    @Override
    public Boolean solve(Integer x) {
        // Negative numbers are not palindromes
        if (x < 0) {
            return false;
        }

        // Single digit numbers are palindromes
        if (x < 10) {
            return true;
        }

        // Reverse the number and compare with original
        int reversed = 0;
        int original = x;

        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return original == reversed;
    }

    @Override
    public TestCaseSet<Integer, Boolean> getTestCaseSet() {
        return PalindromeNumberTestCaseSet.getInstance();
    }
}