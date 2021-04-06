package hss.basic.dynamicProcess;


/**
 * 二叉搜索子树的最大键值和
 * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 * <p>
 * 二叉搜索树的定义如下：
 * <p>
 * 任意节点的左子树中的键值都 小于 此节点的键值。
 * 任意节点的右子树中的键值都 大于 此节点的键值。
 * 任意节点的左子树和右子树都是二叉搜索树。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
 * 输出：20
 * 解释：键值为 3 的子树是和最大的二叉搜索树。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [4,3,null,1,2]
 * 输出：2
 * 解释：键值为 2 的单节点子树是和最大的二叉搜索树。
 * 示例 3：
 * <p>
 * 输入：root = [-4,-2,-5]
 * 输出：0
 * 解释：所有节点键值都为负数，和最大的二叉搜索树为空。
 * 示例 4：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：6
 * 示例 5：
 * <p>
 * 输入：root = [5,4,8,3,null,6,3]
 * 输出：7
 *  
 * <p>
 * 提示：
 * <p>
 * 每棵树最多有 40000 个节点。
 * 每个节点的键值在 [-4 * 10^4 , 4 * 10^4] 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @param
 * @author HSS
 * @return
 * @date 15:16 2021/1/25
 */
public class ChildrenTreeValueDp {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode rightNode = new TreeNode(11);
        TreeNode leftNode = new TreeNode(9);
        root.right = rightNode;
        root.left = leftNode;
        int res = maxSumBST(root);
        System.out.println(res);
    }

    public static int max = 0;


    public static int maxSumBST(TreeNode root) {

        if (root == null) {
            return 0;
        }
        dfsSumTree(root);
        return max;
    }

    private static int dfsSumTree(TreeNode root) {
        //左子树和
        int sumLeftTree = 0;
        //右子树和
        int sumRightTree = 0;
        Boolean leftFlag = false;
        Boolean rightFlag = false;
        //左子树不为空
        if (root.left != null) {
            //递归遍历左儿子节点的子树和的最大值
            sumLeftTree = dfsSumTree(root.left);
            if (sumLeftTree != Integer.MIN_VALUE && root.left.val > Integer.MIN_VALUE) {
                leftFlag = true;
            } else {
                sumLeftTree = Integer.MIN_VALUE;
            }
        } else {
            //左子树为空，则返回左子树的和为0
            sumLeftTree=0;

        }
        //右子树不为空
        if (root.right != null) {
            sumRightTree = dfsSumTree(root.right);
            if (sumRightTree != Integer.MIN_VALUE && root.right.val > root.val) {
                rightFlag = true;
            } else {
                sumRightTree = Integer.MIN_VALUE;
            }
        } else {
            //右子树为空，返回右子树的和为0
            return root.right.val;
        }

        if (leftFlag && rightFlag) {
            int sumRootTree = sumLeftTree + sumRightTree;
            if (max < sumRootTree) {
                max = sumRootTree;
            } else {
                return sumRootTree;
            }
        }

        return Integer.MIN_VALUE;


    }

}
