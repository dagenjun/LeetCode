package xc;

import xc.dynamicProcess.TreeNode;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @description: 二叉树的两个节点之间的最短路径
 * @author: YCKJ2932
 * @create: 2021-06-23
 **/
public class FindDistance {
    //共同祖先
    public TreeNode getPar(TreeNode root,TreeNode p,TreeNode q){
        if(root==null||root==p||root==q){
            return root;
        }
        TreeNode left = getPar(root.left,p,q);
        TreeNode right = getPar(root.right,p,q);
        if(left!=null&&right!=null){
            return root;
        }
        return left==null?right:left;
    }
    //到祖先的距离
    static boolean visited = false;
    public void getDisToPar(TreeNode root, TreeNode p, LinkedList<Integer> stack){
        if(root==null){
            return ;
        }
        //将节点添加到栈中
        stack.push(root.val);
        //如果找到了
        if(!visited&&root==p){
            visited  = true;
            return;
        }
        //先找左子树
        if(!visited){
            getDisToPar(root.left,p,stack);
        }
        //左子树没找到再找右子树
        if(!visited){
            getDisToPar(root.right,p,stack);
        }
        //如果还没找到，说明不在这个节点下面，弹出来
        if(!visited){
            stack.pop();
        }
        return;
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.right = node7;
        node6.left = node8;

        FindDistance findDistance = new FindDistance();
        //找到最近公共祖先
        TreeNode par = findDistance.getPar(node1, node3, node7);
        System.out.println(par.val);
        //stack存路径，存的就是路径上的所有节点
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        findDistance.getDisToPar(par,node3,stack1);
        //复位
        visited = false;
        findDistance.getDisToPar(par,node7,stack2);
        Collections.reverse(stack2);
        stack2.removeFirst();
        stack1.addAll(stack2);
        System.out.println(stack1);
    }
}
