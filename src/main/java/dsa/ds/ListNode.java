package dsa.ds;

import org.apache.commons.lang3.ObjectUtils;

public class ListNode<T> {
    public T val;
    public ListNode<T> next;
    public ListNode(T x) {
        val = x;
    }
    public ListNode(T x, ListNode<T> next) {
        val = x;
        this.next = next;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ListNode<?> that = (ListNode<?>) obj;

        // 递归比较链表的每个节点
        ListNode<?> thisCurrent = this;
        ListNode<?> thatCurrent = that;

        while (thisCurrent != null && thatCurrent != null) {
            if (!ObjectUtils.equals(thisCurrent.val, thatCurrent.val)) {
                return false;
            }
            thisCurrent = thisCurrent.next;
            thatCurrent = thatCurrent.next;
        }

        // 如果两个链表都到达末尾，则相等
        return thisCurrent == null && thatCurrent == null;
    }

    /**
     * 创建链表的深拷贝
     */
    public ListNode<T> cloneList() {
        ListNode<T> newNode = new ListNode<>(this.val);
        if (this.next != null) {
            newNode.next = this.next.cloneList();
        }
        return newNode;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.cloneList();
    }
}
