package 树.tree;

import org.junit.Test;

/**
 * 二叉排序树   左小右大
 */
public class BSTree<E extends Comparable<E>> {

    /**
     * 根结点
     */
    private Node<E> root;

    /**
     * 前序遍历
     *
     * @param tree
     */
    private void preOrder(Node<E> tree) {
        if (tree != null) {
            System.out.print(tree.value + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    /**
     * 中序遍历
     *
     * @param tree
     */
    private void inOrder(Node<E> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.print(tree.value + " ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    /**
     * 后序遍历
     *
     * @param tree
     */
    private void postOrder(Node<E> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.value + " ");
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    /**
     * (递归实现)查找"二叉树x"中键值为value的节点
     */
    private Node<E> search(Node<E> x, E value) {
        if (x == null) {
            return x;
        }
        int cmp = value.compareTo(x.value);
        if (cmp < 0) {
            return search(x.left, value);
        } else if (cmp > 0) {
            return search(x.right, value);
        } else {
            return x;
        }
    }

    public Node<E> search(E value) {
        return search(root, value);
    }


    /**
     * (非递归实现)查找"二叉树x"中键值为key的节点
     */
    private Node<E> iterativeSearch(Node<E> x, E value) {
        while (x != null) {
            int cmp = value.compareTo(x.value);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x;
            }
        }

        return x;
    }

    public Node<E> iterativeSearch(E value) {
        return iterativeSearch(root, value);
    }

    /**
     * 将结点插入到二叉树中
     * <p>
     * 参数说明：
     * tree 二叉树的
     * z 插入的结点
     */
    private void insert(BSTree<E> bst, Node<E> z) {
        int cmp;
        Node<E> y = null;
        Node<E> x = bst.root;

        // 查找z的插入位置
        while (x != null) {
            y = x;
            cmp = z.value.compareTo(x.value);
            if (cmp < 0)
                x = x.left;
            else
                x = x.right;
        }

        z.parent = y;
        if (y == null)
            bst.root = z;
        else {
            cmp = z.value.compareTo(y.value);
            if (cmp < 0)
                y.left = z;
            else
                y.right = z;
        }
    }

    /**
     * 新建结点(key)，并将其插入到二叉树中
     * <p>
     * 参数说明：
     * tree 二叉树的根结点
     * key 插入结点的键值
     */
    public void insert(E value) {
        Node<E> z = new Node<E>(value, null, null, null);
        // 如果新建结点失败，则返回。
        if (z != null)
            insert(this, z);
    }
    @Test
    public void test() throws InterruptedException {
        BSTree bsTree = new BSTree();
        bsTree.insert(1);
        Thread.sleep(50);
        TreePrintUtil.pirnt(bsTree.root);Thread.sleep(50);
        bsTree.insert(6);Thread.sleep(50);
        TreePrintUtil.pirnt(bsTree.root);Thread.sleep(50);
        bsTree.insert(9);Thread.sleep(50);
        TreePrintUtil.pirnt(bsTree.root);
        bsTree.insert(3);TreePrintUtil.pirnt(bsTree.root);Thread.sleep(50);
        bsTree.insert(2);TreePrintUtil.pirnt(bsTree.root);Thread.sleep(50);
        bsTree.insert(5);TreePrintUtil.pirnt(bsTree.root);Thread.sleep(50);
        bsTree.insert(4);TreePrintUtil.pirnt(bsTree.root);Thread.sleep(50);
        bsTree.insert(11);TreePrintUtil.pirnt(bsTree.root);Thread.sleep(50);
        bsTree.insert(13);TreePrintUtil.pirnt(bsTree.root);Thread.sleep(50);
        bsTree.insert(14);TreePrintUtil.pirnt(bsTree.root);Thread.sleep(50);
        bsTree.insert(12);TreePrintUtil.pirnt(bsTree.root);Thread.sleep(50);

        bsTree.insert(10);TreePrintUtil.pirnt(bsTree.root);Thread.sleep(50);
        bsTree.postOrder();



    }


}
