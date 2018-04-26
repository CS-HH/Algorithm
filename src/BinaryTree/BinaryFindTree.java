package BinaryTree;

/**
 * 二叉查找树(ADT)
 *
 * @author exphuhong
 * @since 19:27 2018/4/26
 */
public class BinaryFindTree {
    class Node {
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }
    }

    Node root;//保存树的根

    public boolean find(int key) {//查找指定节点
        Node currentNode = root;
        while (currentNode != null && currentNode.key != key) {
            if (key < currentNode.key) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        if (currentNode != null) {
            return true;
        }
        return false;
    }


    public void insert(int key) {//插入节点
        if (root == null) {
            root = new Node(key);
            return;
        }
        Node currentNode = root;

        //用来记录最后一个currentNode的父节点以便最后插入数据
        Node parentNode = root;
        boolean isLeftChild = true;
        while (currentNode != null) {
            parentNode = currentNode;
            if (key < currentNode.key) {
                currentNode = currentNode.left;
                isLeftChild = true;
            } else {
                currentNode = currentNode.right;
                isLeftChild = false;
            }
        }
        Node newNode = new Node(key);
        if (isLeftChild) {
            parentNode.left = newNode;
        } else {
            parentNode.right = newNode;
        }

    }

    /*public boolean delete(int key) {//删除指定节点

    }

    private Node getDirectPostNode(Node delNode) {//得到待删除节点的直接后继节点

    }*/

    public void preOrder(Node rootNode) {//先序遍历树
        if (rootNode != null) {
            System.out.println(rootNode.key);
            preOrder(rootNode.left);
            preOrder(rootNode.right);
        }
    }

    public void inOrder(Node rootNode) {//中序遍历树

    }

    public void postOrder(Node rootNode) {//后序遍历树

    }

    public static void main(String[] args) {
        BinaryFindTree tree = new BinaryFindTree();
        tree.insert(1);
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(21);
        tree.insert(2);
        tree.insert(19);
        tree.insert(16);

        tree.find(3);
        tree.find(8);

        tree.preOrder(tree.root);
    }

}
