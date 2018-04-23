package BinaryTree;


/**
 * 重建二叉树
 * 已知前序遍历和中序遍历还原二叉树得出后序遍历
 *@author exphuhong
 *@since  22:00 2018/4/21
 *
 */
public class RebuildTree {
    class TreeNode{
        String val;
        TreeNode left;
        TreeNode right;

        TreeNode(String val) {
            this.val = val;
        }
    }

    public TreeNode reConstructBinaryTree(String[] pre,String[] in) {
        /*
         * 输入合法性判断， 不能为空，先序和后序长度要一致
         */
        if(pre == null || in == null || pre.length != in.length)
            return null;

        return construct(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    /**
     *
     * @param pre    前序遍历
     * @param ps    前序遍历的开始位置
     * @param pe    前序遍历的结束位置
     * @param in    中序遍历
     * @param is    中序遍历的开始位置
     * @param ie    中序遍历的结束位置
     * @return        数的根节点
     */
    private TreeNode construct(String[] pre, int ps, int pe, String[] in, int is, int ie) {
        if(ps > pe) return null;

        // 取前序遍历的第一个数字就是根节点
        String value = pre[ps];
        // 在中序遍历中中寻找根节点
        int index =is;
        while(index <= ie && value != in[index]) {
            index ++;
        }
        // 如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的，抛出异常
        if(index > ie)
            throw new RuntimeException("Invalid Iuput!");

        // 创建当前根节点，并为根节点赋值
        TreeNode node = new TreeNode(value);
        // 递归调用构建当前节点的左子树
        node.left = construct(pre, ps+1, ps+index-is, in, is, index-1);
        // 递归调用构建当前节点的右子树
        node.right = construct(pre, ps+index-is+1, pe, in, index+1, ie);

        return node;
    }


    private void printTree(TreeNode root) {
        if(root != null) {
            printTree(root.left);
            printTree(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args) {
        String[] pre = {"A", "B", "D", "C", "E", "F"};
        String[] in = {"B", "D", "A", "C", "F", "E"};
        RebuildTree binaryTree = new RebuildTree();
        TreeNode treeNode = binaryTree.reConstructBinaryTree(pre, in);
        binaryTree.printTree(treeNode);

    }
}
