package 树.tree;

public class Node<E extends Comparable<E>> implements TreeNode {

    E value;
    Node<E> left;
    Node<E> right;


    public Node(E value) {
        this.value = value;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "[" + value + "]";
    }

    @Override
    public String getPrintInfo() {
        return null;
    }

    @Override
    public TreeNode getLeftChild() {
        return left;
    }

    @Override
    public TreeNode getRightChild() {
        return right;
    }
}
