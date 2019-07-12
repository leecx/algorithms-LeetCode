package 树.tree;

import org.junit.Test;

import java.util.Stack;

/**
 * 二叉排序树   左小右大
 */
public class BSTree<E extends Comparable<E>> {

    /**
     * 根结点
     */
    private Node<E> root;

    /**
     * 前序遍历     中左右
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

    private void preOrderByStack(Node<E> tree){
        Stack<Node<E>> stack = new Stack();
        while(tree!=null){
            System.out.print(tree.value+" ");
            if(tree.right!=null){
                stack.push(tree.right);
            }
            if(tree.left!=null){
                tree = tree.left;
            }else{
                if(stack.empty()){
                    tree = null;
                }else{
                    tree = stack.pop();
                }
            }
        }
    }

    private void preOrderByStack1(Node<E> tree){
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            System.out.print(pop.value + " ");
            //result.add(pop);
            if(pop.right!=null){
                stack.push(pop.right);
            }
            if(pop.left!=null){
                stack.push(pop.left);
            }
        }
    }

    public void preOrderByStack() {
        preOrderByStack(root);
    }

    public void preOrder() {
        preOrder(root);
    }

    /**
     * 中序遍历      左中右
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

    /**
     * 中序 用栈遍历，把每个节点拆开来看
     * @param tree
     */
    private void inOrderByStack(Node<E> tree){
        Stack<Node> stack = new Stack<>();
        while (tree != null || !stack.isEmpty()) {
            while (tree != null) {
                stack.push(tree);
                tree = tree.left;
            }
            if (!stack.isEmpty()) {
                tree = stack.pop();
                System.out.print(tree.value + " ");
                tree = tree.right;
            }
        }
    }

    public void inOrderByStack(){
        inOrderByStack(root);
    }

    public void inOrder() {
        inOrder(root);
    }

    /**
     * 后序遍历     左右中
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

    /**
     * 非递归 后序遍历，拆开节点  左右中
     * @param tree
     */
    private void postOrderByStack(Node<E> tree){
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        while (tree != null || !stack.isEmpty()) {
            while (tree != null) {
                stack.push(tree);
                stack2.push(tree);
                tree = tree.right;
            }
            if (!stack.isEmpty()) {
                tree = stack.pop().left;
            }
        }

        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().value + " ");
        }
    }

    public void postOrderByStack(){
        postOrderByStack(root);
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
        bsTree.insert(6);
        bsTree.insert(9);
        bsTree.insert(3);
        bsTree.insert(2);
        bsTree.insert(5);
        bsTree.insert(4);
        bsTree.insert(11);
        bsTree.insert(13);
        bsTree.insert(14);
        bsTree.insert(12);

        //bsTree.insert(10);
        //TreePrintUtil.pirnt(bsTree.root);
        bsTree.postOrder();
        System.out.println();
        bsTree.postOrderByStack();
        System.out.println();
        bsTree.inOrder();
        System.out.println();
        bsTree.inOrderByStack();
        System.out.println();
        bsTree.preOrder();
        System.out.println();
        bsTree.preOrderByStack();

        System.out.println();
        TreePrintUtil.pirnt(bsTree.root);



    }


}
