package dsa.solution.lc;

import dsa.solution.Solution;
import dsa.testcase.TestCaseSet;
import dsa.testcase.lc.GroupAnagramsTestCaseSet;
import lombok.Getter;

import java.util.*;

/**
 * Group Anagrams Solution
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * Constraints:
 * - 1 <= strs.length <= 10^4
 * - 0 <= strs[i].length <= 100
 * - strs[i] consists of lowercase English letters.
 */
public class GroupAnagramsSolution implements Solution<String[], List<List<String>>> {
    @Getter
    private static final GroupAnagramsSolution instance = new GroupAnagramsSolution();
    private GroupAnagramsSolution() {
    }

    @Override
    public List<List<String>> solve(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Sort the characters to create a canonical form for anagrams
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            // Add the original string to the list for this sorted form
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }

        return new ArrayList<>(map.values());
    }

    @Override
    public TestCaseSet<String[], List<List<String>>> getTestCaseSet() {
        return GroupAnagramsTestCaseSet.getInstance();
    }
}