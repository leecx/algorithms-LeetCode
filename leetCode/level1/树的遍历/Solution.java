package level1.树的遍历;


import 树.tree.Node;
import 树.tree.TreePrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static Node node;
    {
        //构造一颗树
        node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node2.right = node5;
        TreePrintUtil.pirnt(node);
    }

    /**
     * 树的前序遍历(中左右)   栈
     * @param root
     * @return
     */
    public List<Node> preorderTraversal(Node root) {
        List<Node> result = new ArrayList();
        if(root == null){
            return result;
        }
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            result.add(pop);
            if(pop.right!=null){
                stack.push(pop.right);
            }
            if(pop.left!=null){
                stack.push(pop.left);
            }
        }
        return result;
    }

    /**
     * 前序遍历，递归   中左右
     * @param root
     */
    public void voidPreorderTraversal(Node root){
        //递归结束条件
        if(root!=null){
            System.out.println(root.value);
            voidPreorderTraversal(root.left);
            voidPreorderTraversal(root.right);
        }
    }

    /**
     * 中序遍历    左中右
     * @param root
     */
    public void voidInorderTraversal(Node root){
        //递归结束条件
        if(root!=null){
            voidInorderTraversal(root.left);
            System.out.println(root.value);
            voidInorderTraversal(root.right);
        }
    }

    /**
     * 后序遍历     左右中
     * @param root
     */
    public void voidPostorderTraversal(Node root){
        //递归结束条件
        if(root!=null){
            voidPostorderTraversal(root.left);
            voidPostorderTraversal(root.right);
            System.out.println(root.value);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.voidInorderTraversal(node);
        List<Node> nodes = solution.preorderTraversal(node);
        nodes.forEach(i->{
            System.out.print(i.value);
        });

    }


}


