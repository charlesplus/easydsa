package dsa.ds;

import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;

@Data
public class BinaryTreeNode<T> {
    private T value;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode(T value, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BinaryTreeNode<?> that = (BinaryTreeNode<?>) obj;
        return ObjectUtils.equals(value, that.value) &&
                ObjectUtils.equals(left, that.left) &&
                ObjectUtils.equals(right, that.right);
    }

    public BinaryTreeNode<T> clone() {
        BinaryTreeNode clonedNode = new BinaryTreeNode<>(this.value);
        if (this.left != null) {
            clonedNode.left = this.left.clone();
        }
        if (this.right != null) {
            clonedNode.right = this.right.clone();
        }
        return clonedNode;
    }

}
