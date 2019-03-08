package 树.tree;

public class Demo2 {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        node1.left = new Node(2);
        node1.right = new Node(2);
        //从根开始打印
        TreePrintUtil.pirnt(node1);
    }

}
