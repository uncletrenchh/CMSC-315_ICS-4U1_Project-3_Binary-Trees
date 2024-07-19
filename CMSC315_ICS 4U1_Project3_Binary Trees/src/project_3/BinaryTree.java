package project_3;

/**
 * @author Kelvin Njenga
 *
 */

public class BinaryTree {
    private static class Node {
        private char data;
        private Node left;
        private Node right;

        public Node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public char getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(String treeString) throws InvalidTreeSyntax {
        this.root = constructTree(treeString);
    }

    public Node constructTree(String treeString) throws InvalidTreeSyntax {
        if (treeString.isEmpty()) {
            return null;
        }

        int start = 0;
        int end = treeString.length();
        char data = treeString.charAt(start);
        Node root = new Node(data);

        if (start + 1 < end && treeString.charAt(start + 1) == '(') {
            int leftSubtreeEnd = findMatchingParenthesis(treeString, start + 2);
            String leftSubtreeString = treeString.substring(start + 2, leftSubtreeEnd);
            Node leftSubtree = constructTree(leftSubtreeString);
            if (leftSubtree != null) {
                root.setLeft(leftSubtree);
            }

            if (leftSubtreeEnd + 2 < end && treeString.charAt(leftSubtreeEnd + 2) == '(') {
                int rightSubtreeEnd = findMatchingParenthesis(treeString, leftSubtreeEnd + 3);
                String rightSubtreeString = treeString.substring(leftSubtreeEnd + 3, rightSubtreeEnd);
                Node rightSubtree = constructTree(rightSubtreeString);
                if (rightSubtree != null) {
                    root.setRight(rightSubtree);
                }
            }
        }

        return root;
    }

    private int findMatchingParenthesis(String s, int start) throws InvalidTreeSyntax {
        int count = 1;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
                if (count == 0) {
                    return i;
                }
            }
        }
        throw new InvalidTreeSyntax("Invalid tree syntax.");
    }
    
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());

        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(node.getLeft()) && isBalanced(node.getRight());
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isFull() {
        return isFull(root);
    }

    private boolean isFull(Node node) {
        if (node == null)
            return true;

        if (node.getLeft() == null && node.getRight() == null)
            return true;

        if ((node.getLeft() != null) && (node.getRight() != null))
            return (isFull(node.getLeft()) && isFull(node.getRight()));

        return false;
    }
    
    public int getNodeCount() {
        return getNodeCount(root);
    }

    private int getNodeCount(Node node) {
        if (node == null)
            return 0;
        else
            return (getNodeCount(node.getLeft()) + 1 + getNodeCount(node.getRight()));
    }
    
    public String getInorderTraversal() {
        StringBuilder result = new StringBuilder();
        inorderTraversal(root, result);
        return result.toString();
    }

    private void inorderTraversal(Node node, StringBuilder result) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.getLeft(), result);
        result.append(node.getData()).append(" ");
        inorderTraversal(node.getRight(), result);
    }

    public boolean isProper() {
        return isProper(root);
    }

    private boolean isProper(Node node) {
        if (node == null)
            return true;

        if (node.getLeft() == null && node.getRight() == null)
            return true;

        if ((node.getLeft() != null) && (node.getRight() != null))
            return (isProper(node.getLeft()) && isProper(node.getRight()));

        return false;
    }


}