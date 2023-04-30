package huffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = new int[]{13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);
        preOrder(root);
        //测试一把

    }
    //前序遍历的方法
    public static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }else {
            System.out.println("树为空！");
        }
    }

    //创建哈夫曼树
    public static Node createHuffmanTree(int[] arr) {
        // 1、遍历数组，将每个元素构建成一个Node
        // 2、将Node放入ArrayList中
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nodes.add(new Node(arr[i]));
        }


        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);

            //1、取出权值最小的二叉树
            // 1 取权值最小的节点
            Node left = nodes.get(0);
            // 2 取权值次小的节点
            Node right = nodes.get(1);

            // 3 构建新的二叉树
            Node parent = new Node(left.value + right.value);
            parent.left = left;
            parent.right = right;

            //删除left right
            nodes.remove(left);
            nodes.remove(right);
            //将parent加进去
            nodes.add(parent);
        }

        //返回头节点
        return nodes.get(0);
    }
}

//创建节点类
//为了让Node 对象持续排序Collections集合排序
//让Node 实现Comparable接口
class Node implements Comparable<Node> {
    int value; //节点权值
    Node left;  //左子节点
    Node right; //右子节点

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.value - o.value;
    }

    public void preOrder(){
        System.out.println(this.value);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }
}