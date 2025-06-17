import java.util.*;

public class Main {
    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static int N, X, D;
    static Node root = null;
    static List<Integer> vec = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input(sc);
        settings();
        printAnswer();
    }

    static void input(Scanner sc) {
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            vec.add(sc.nextInt());
        }
        X = sc.nextInt();
    }

    static Node insertNode(Node node, int value) {
        if (node == null) return new Node(value);

        if (value < node.value) {
            node.left = insertNode(node.left, value);
        } else if (value > node.value) {
            node.right = insertNode(node.right, value);
        }

        return node;
    }

    static Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    static Node deleteNode(Node node, int value) {
        if (node == null) return null;

        if (value < node.value) {
            node.left = deleteNode(node.left, value);
        } else if (value > node.value) {
            node.right = deleteNode(node.right, value);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            Node temp = findMin(node.right);
            node.value = temp.value;
            node.right = deleteNode(node.right, temp.value);
        }

        return node;
    }

    static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    static void collectValues(Node node, List<Integer> values) {
        if (node == null) return;
        collectValues(node.left, values);
        collectValues(node.right, values);
        values.add(node.value);
    }

    static Node constructTree(List<Integer> values, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node node = new Node(values.get(mid));
        node.left = constructTree(values, start, mid - 1);
        node.right = constructTree(values, mid + 1, end);

        return node;
    }

    static Node getBSTree(Node node) {
        List<Integer> values = new ArrayList<>();
        collectValues(node, values);
        Collections.sort(values);
        return constructTree(values, 0, values.size() - 1);
    }

    static void settings() {
        for (int i = 0; i < N; i++) {
            if (vec.get(i) == -1) {
                int value;
                if (i == 0) {
                    value = vec.get(i + 1) + 1;
                } else {
                    int index = i + 1;
                    if (index % 2 == 0) {
                        value = vec.get((index / 2) - 1) - 1;
                    } else {
                        value = vec.get((index / 2) - 1) + 1;
                    }
                }
                vec.set(i, value);
                D = value;
            }
            root = insertNode(root, vec.get(i));
        }

        root = deleteNode(root, D);
        root = insertNode(root, X);
        root = getBSTree(root);
    }

    static void printAnswer() {
        postOrder(root);
        System.out.println();
    }
}
