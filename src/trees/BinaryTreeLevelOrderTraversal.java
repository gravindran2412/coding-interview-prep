package trees;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeLevelOrderTraversal {

    /**
     * Solution
     *
     * @param root
     */
    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                continue;
            }
            System.out.print(current.data + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
            queue.add(null);
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }

    public static Node constructTree(int[] data) {
        Node root = null;
        for (int i = 0; i < data.length; i++) {
            root = insert(root, data[i]);
        }
        return root;
    }
}

class TestBinaryTreeLevelOrderTraversal {
    @Test
    public void TestBinaryTreeHeight() {
        Node root = BinaryTreeLevelOrderTraversal.constructTree(new int[]{1, 2, 5, 3, 6, 4});
        String expected = "1 2 5 3 6 4 ";
        BinaryTreeLevelOrderTraversal.levelOrder(root);
    }
}
