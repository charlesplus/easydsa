package dsa.testcase.lc;

import dsa.ds.ListNode;
import dsa.testcase.TestCaseSet;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedListsTestCaseSet implements TestCaseSet<Object[], ListNode<Integer>> {
    @Getter
    public static final MergeTwoSortedListsTestCaseSet instance = new MergeTwoSortedListsTestCaseSet();
    private MergeTwoSortedListsTestCaseSet() {
    }

    @Override
    public List<Pair<Object[], ListNode<Integer>>> getTestCases() {
        // Creating test cases for merging two sorted linked lists
        
        // Test case 1: [1,2,4] and [1,3,4] -> [1,1,2,3,4,4]
        ListNode<Integer> list1_1 = new ListNode<>(1);
        list1_1.next = new ListNode<>(2);
        list1_1.next.next = new ListNode<>(4);
        
        ListNode<Integer> list1_2 = new ListNode<>(1);
        list1_2.next = new ListNode<>(3);
        list1_2.next.next = new ListNode<>(4);
        
        ListNode<Integer> expected1 = new ListNode<>(1);
        expected1.next = new ListNode<>(1);
        expected1.next.next = new ListNode<>(2);
        expected1.next.next.next = new ListNode<>(3);
        expected1.next.next.next.next = new ListNode<>(4);
        expected1.next.next.next.next.next = new ListNode<>(4);
        
        // Test case 2: [] and [] -> []
        ListNode<Integer> list2_1 = null;
        ListNode<Integer> list2_2 = null;
        ListNode<Integer> expected2 = null;
        
        // Test case 3: [] and [0] -> [0]
        ListNode<Integer> list3_1 = null;
        ListNode<Integer> list3_2 = new ListNode<>(0);
        ListNode<Integer> expected3 = new ListNode<>(0);
        
        return Arrays.asList(
            Pair.of(new Object[]{list1_1, list1_2}, expected1),
            Pair.of(new Object[]{list2_1, list2_2}, expected2),
            Pair.of(new Object[]{list3_1, list3_2}, expected3)
        );
    }
}