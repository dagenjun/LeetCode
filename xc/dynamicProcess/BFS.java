package dynamicProcess;

import java.util.*;

/**
 * @description:
 * @author: YCKJ2932
 * @create: 2021-01-20
 **/
public class BFS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rightNode = new TreeNode(20);
        TreeNode leftNode = new TreeNode(9);
        rightNode.left = new TreeNode(15);
        rightNode.right = new TreeNode(7);
        leftNode.left = new TreeNode(5);
        leftNode.right = new TreeNode(6);
        root.right = rightNode;
        root.left = leftNode;
        System.out.println(levelOrder1(root));
        System.out.println(levelOrder2(root));
    }

    public static List<List<Integer>> levelOrder1(TreeNode root) {
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        Queue<Integer> indexQueue = new ArrayDeque<>();
        List<List<Integer>> re = new ArrayList<>();
        if (root != null) {
            treeNodeQueue.add(root);
            indexQueue.add(0);
        } else {
            return re;
        }
        int temp = 0;
        while (!treeNodeQueue.isEmpty()) {
            int index = indexQueue.poll();
            TreeNode element = treeNodeQueue.poll();
            levelAdd(element, treeNodeQueue, indexQueue, index + 1);
            List<Integer> mid;
            if (temp < index) {
                temp = index;
                mid = new ArrayList<>();
                mid.add(element.val);
            } else {
                if (re.isEmpty()) {
                    mid = new ArrayList<>();
                    mid.add(element.val);
                } else {
                    mid = re.get(re.size() - 1);
                    mid.add(element.val);
                    re.remove(re.size() - 1);
                }
            }
            re.add(mid);
        }
        return re;
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    private static void levelAdd(TreeNode root, Queue<TreeNode> treeNodeQueue, Queue<Integer> indexQueue, int k) {
        if (root.left != null) {
            treeNodeQueue.add(root.left);
            indexQueue.add(k + 1);
        }
        if (root.right != null) {
            treeNodeQueue.add(root.right);
            indexQueue.add(k + 1);
        }
    }
}
