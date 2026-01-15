二叉树**经典的遍历顺序有 4 种**（按访问“根节点”的时机来区分），工程面试与日常编码里基本都围绕这些来考：

---

## 一、二叉树遍历顺序总览

| 遍历方式 | 顺序规则      | 记忆口诀    |
| ---- | --------- | ------- |
| 前序遍历 | 根 → 左 → 右 | **根在前** |
| 中序遍历 | 左 → 根 → 右 | **根在中** |
| 后序遍历 | 左 → 右 → 根 | **根在后** |
| 层序遍历 | 按层从左到右    | **BFS** |

---

## 二、二叉树节点定义（Java）

```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
```

---

## 三、深度优先遍历（DFS）

### 1️⃣ 前序遍历（Preorder）

**顺序**：根 → 左 → 右
常用于：**复制树、表达式求值**

#### 递归实现

```java
void preorder(TreeNode root) {
    if (root == null) return;
    System.out.print(root.val + " ");
    preorder(root.left);
    preorder(root.right);
}
```

---

### 2️⃣ 中序遍历（Inorder）

**顺序**：左 → 根 → 右
👉 **二叉搜索树中序遍历 = 有序序列**

#### 递归实现

```java
void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.val + " ");
    inorder(root.right);
}
```

---

### 3️⃣ 后序遍历（Postorder）

**顺序**：左 → 右 → 根
常用于：**删除节点、释放资源**

#### 递归实现

```java
void postorder(TreeNode root) {
    if (root == null) return;
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.val + " ");
}
```

---

## 四、广度优先遍历（BFS）

### 4️⃣ 层序遍历（Level Order）

**顺序**：一层一层，从左到右
👉 本质：**队列**

```java
import java.util.*;

void levelOrder(TreeNode root) {
    if (root == null) return;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        System.out.print(node.val + " ");

        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
    }
}
```

---

## 五、进阶：非递归遍历（面试加分）

### 前序遍历（栈）

```java
void preorderIter(TreeNode root) {
    if (root == null) return;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        System.out.print(node.val + " ");

        if (node.right != null) stack.push(node.right);
        if (node.left != null) stack.push(node.left);
    }
}
```

---

## 六、记忆 & 面试总结

* **前 / 中 / 后序**：区别只是 **根节点访问时机**
* **DFS → 栈 / 递归**
* **BFS → 队列**
* **BST 中序遍历一定有序**（高频考点）

[//]: # (---)

[//]: # ()
[//]: # (如果你愿意，我可以帮你：)

[//]: # ()
[//]: # (* 把 **4 种遍历统一成一个模板**)

[//]: # (* 或画一棵树 + **一步步执行顺序图**)

[//]: # (* 或写成 **LeetCode 标准题解版本**)

[//]: # ()
[//]: # (你更想往 **面试** 还是 **工程实践** 方向深入？)
