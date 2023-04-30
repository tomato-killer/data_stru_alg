public class BinaryTree {
    public static void main(String[] args) {
        TreeNode root = createTree();
        preOrderRe(root);
        System.out.println();

        inOrderRe(root);
        System.out.println();

        postOrderRe(root);
        System.out.println();
    }

    public static TreeNode createTree() {
        TreeNode[] nodes = new TreeNode[10]; // 生成一颗完全二叉树
        int i, l, r;
        for (i = 1; i < 10; i++) { // 从 1 开始
            nodes[i] = new TreeNode(i);
        }
        for (i = 1; i <= 9; i++) {
            l = 2*i;
            r = 2*i + 1;
            if (l < 10) {
                nodes[i].left = nodes[l];
            }
            if (r < 10) {
                nodes[i].right = nodes[r];
            }
        }
        return nodes[1];
    }

    public static void preOrderRe(TreeNode root) {
        if (root == null) {
            return;
        }
        root.show(); // 先序遍历根节点
        preOrderRe(root.left);
        preOrderRe(root.right);
    }

    public static void inOrderRe(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRe(root.left);
        root.show(); // 中序遍历根节点
        inOrderRe(root.right);
    }

    public static void postOrderRe(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderRe(root.left);
        postOrderRe(root.right);
        root.show(); // 后序遍历根节点
    }

}

// 二叉树节点类型
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int value) {
        this.value = value;
    }

    public void show() {
        System.out.print(value + " ");
    }
}