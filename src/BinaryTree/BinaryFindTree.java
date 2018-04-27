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

    public void insertNode(int key) {
        root = insert(key, root);
    }

    public Node insert(int key, Node node) {//插入节点
        if (node == null) {
            node = new Node(key);
        }
        if (key < node.key) {
            node.left = insert(key, node.left);
        } else if (key > node.key) {
            node.right = insert(key, node.right);
        }

        return node;
    }


    public void deleteNode(int key) {
        root = delete(key, root);
    }

    public Node delete(int key,Node node) {//删除指定节点
        if (node == null) {
            return node;
        }
        if (key < node.key) {
            node.left = delete(key,node.left);
        } else if (key > node.key) {
            node.right = delete(key, node.right);
        } else if (node.left != null && node.right != null) {
            node.key = findMin(node.right);
            node.right = delete(node.key, node.right);
        } else {
            node = (node.left != null) ? node.left : node.right;
        }
        return node;
    }

    public int findMin(Node node) {
        if (node != null) {
            return findMin(node.left);
        }
        return node.key;
    }

    public void preOrder(Node rootNode) {//先序遍历树
        if (rootNode != null) {
            System.out.println(rootNode.key);
            preOrder(rootNode.left);
            preOrder(rootNode.right);
        }
    }

    public void inOrder(Node rootNode) {//中序遍历树
        if (rootNode != null) {
            inOrder(rootNode.left);
            System.out.println(rootNode.key);
            inOrder(rootNode.right);
        }
    }

    public void postOrder(Node rootNode) {//后序遍历树

    }

    public static void main(String[] args) {
        BinaryFindTree tree = new BinaryFindTree();
        tree.insertNode(6);
        tree.insertNode(1);
        tree.insertNode(2);
        tree.insertNode(7);
        tree.insertNode(5);
        tree.insertNode(10);
        tree.insertNode(21);
        tree.insertNode(11);
        tree.insertNode(13);
        tree.insertNode(12);



        tree.inOrder(tree.root);

        tree.delete(7, tree.root);

        tree.inOrder(tree.root);
    }

}
