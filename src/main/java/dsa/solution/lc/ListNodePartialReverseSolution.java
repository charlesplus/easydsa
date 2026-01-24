package dsa.solution.lc;

import dsa.annotation.RunSolution;
import dsa.ds.ListNode;
import dsa.solution.Solution;
import dsa.testcase.ListNodePartialReverseTestCaseSet;
import dsa.testcase.TestCaseSet;
import org.apache.commons.lang3.tuple.Pair;

@RunSolution(runByDefault = true)
public class ListNodePartialReverseSolution implements Solution<Pair<ListNode<Integer>, Pair<Integer, Integer>>, ListNode<Integer>> {

    @Override
    public ListNode<Integer> solve(Pair<ListNode<Integer>, Pair<Integer, Integer>> input) {
        ListNode<Integer> head = input.getLeft();  // 链表头节点
        int left = input.getRight().getLeft();      // 开始反转的位置（索引）
        int right = input.getRight().getRight();    // 结束反转的位置（索引）

        if (head == null || left >= right) {
            return head;
        }

        // 创建虚拟头节点，简化边界处理
        ListNode<Integer> dummy = new ListNode<>(0);
        dummy.next = head;

        // 找到开始反转前的节点
        ListNode<Integer> prevStart = dummy;
        for (int i = 0; i < left; i++) {
            prevStart = prevStart.next;
        }

        // 开始反转的部分的起始节点
        ListNode<Integer> start = prevStart.next;

        // 执行部分反转
        ListNode<Integer> prev = null;
        ListNode<Integer> curr = start;
        ListNode<Integer> next;

        // 反转从left到right的节点
        for (int i = left; i <= right; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 连接反转后的部分
        prevStart.next = prev;  // 连接反转部分的新头
        start.next = curr;      // 连接剩余部分

        return dummy.next;
    }

    @Override
    public TestCaseSet<Pair<ListNode<Integer>, Pair<Integer, Integer>>, ListNode<Integer>> getTestCaseSet() {
        return ListNodePartialReverseTestCaseSet.getInstance();
    }
}