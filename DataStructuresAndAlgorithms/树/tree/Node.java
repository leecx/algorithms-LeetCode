package 树.tree;

/**
 * @author lichenxin
 */
public class Node<E extends Comparable<E>> implements TreeNode {
    /**
     * 值
     */
    public E value;
    /**
     * 左节点
     */
    public Node<E> left;
    /**
     * 右节点
     */
    public Node<E> right;
    /**
     * 父节点
     */
    public Node<E> parent;

    public Node(E value) {
        this.value = value;
        left = null;
        right = null;
    }
    public Node(E value, Node<E> parent, Node<E> left, Node<E> right) {
        this.value = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
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
