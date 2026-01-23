package dsa.solution.lc;

import dsa.annotation.RunSolution;
import dsa.ds.ListNode;
import dsa.solution.Solution;
import dsa.testcase.ListNodeReverseTestCaseSet;
import dsa.testcase.TestCaseSet;
import lombok.Getter;

@RunSolution(runByDefault = true)
public class ListNodeReverseSolution implements Solution<ListNode<Integer>, ListNode<Integer>> {
    @Getter
    private static final ListNodeReverseSolution instance = new ListNodeReverseSolution();
    private ListNodeReverseSolution() {
    }

    @Override
    public ListNode<Integer> solve(ListNode<Integer> listNode) {
        ListNode<Integer> pre = null;
        ListNode<Integer> cur = listNode;
        while (cur != null) {
            ListNode<Integer> next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    @Override
    public TestCaseSet<ListNode<Integer>, ListNode<Integer>> getTestCaseSet() {
        return ListNodeReverseTestCaseSet.getInstance();
    }
}
