package wangzheng.datastruct;

import org.w3c.dom.Node;

public class BTree {
    private Node tree;

    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data < p.data) p = p.left;
            else if (data > p.data) p = p.right;
            else return p;
        }
        return null;
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public void delete(int data) {
        Node p = tree; // p指向要删除的节点，初始化指向根节点
        Node pp = null; // pp记录的是p的父节点
//        p=find(data);
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) p = p.right;
            else p = p.left;
        }
        if (p == null) return; // 没有找到

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) { // 查找右子树中最小节点
            Node minP = p.right;
            Node minPP = p; // minPP表示minP的父节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }

            //好的。我们用后继节点替换到要删除节点的位置。 然后就变成删除后继节点的问题了。为了逻辑统一 代码书写简洁。我们把后继节点赋给了p
            p.data = minP.data; // 将minP的数据替换到p中
            p = minP; // 下面就变成了删除minP了
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node child; // p的子节点
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        if (pp == null) tree = child; // 删除的是根节点
        else if (pp.left == p) pp.left = child;
        else pp.right = child;

//        看删除代码最后三行，开始确实没有看懂，根据图来理解以为是先获取要替换的对象，然后删除掉要删除的对象，最后将要替换的对象转移过去。
//        其实这三行代码的真正含义是，直接将要替换的对象的值赋值上去，这个时候那个要删除的对象就不用删除了，然后把要替换的那个对象删除就好了。
//        这个时候因为那个要替换的对象只可能存在一个右子树或者是没有子树。这就又变成了删除只有一个子树或者没有子树的问题，这段代码写的确实非比寻常，点个赞
    }
}
