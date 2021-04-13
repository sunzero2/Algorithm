package baekjoon_20200413;

public class BinarySearchTree {

    private static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public Node search(int searchNode) {
        Node currentNode = root;

        while (true) {
            if (currentNode == null) {
                return null;
            }

            if (searchNode == currentNode.value) {
                return currentNode;
            } else if (searchNode < currentNode.value) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
    }

    public void add(int node) {
        root = addNode(root, node);
    }

    private Node addNode(Node currentNode, int addNode) {
        if (currentNode == null) {
            return new Node(addNode);
        }

        if (addNode < currentNode.value) {
            currentNode.left = addNode(currentNode.left, addNode);
        } else if (addNode > currentNode.value) {
            currentNode.right = addNode(currentNode.right, addNode);
        }

        return currentNode;
    }

    public boolean delete(int deleteNode) {
        Node currentNode = root;
        Node parentNode = null;
        boolean isLeftChild = true;

        while (true) {
            if (currentNode == null) {
                return false;
            }

            if (deleteNode == currentNode.value) {
                break;
            } else {
                parentNode = currentNode;

                if (deleteNode < currentNode.value) {
                    isLeftChild = true;
                    currentNode = currentNode.left;
                } else {
                    isLeftChild = false;
                    currentNode = currentNode.right;
                }
            }
        }

        if (currentNode.left == null) {
            if (currentNode == root) {
                root = currentNode.right;
            } else if (isLeftChild) {
                parentNode.left = currentNode.right;
            } else {
                parentNode.right = currentNode.right;
            }
        } else if (currentNode.right == null) {
            if (currentNode == root) {
                root = currentNode.left;
            } else if (isLeftChild) {
                parentNode.left = currentNode.left;
            } else {
                parentNode.right = currentNode.left;
            }
        } else {
            parentNode = currentNode;
            Node left = currentNode.left;
            isLeftChild = true;

            while (left.right != null) {
                parentNode = left;
                left = left.right;
                isLeftChild = false;
            }

            root = left;

            if (isLeftChild) {
                parentNode.left = left.left;
            } else {
                parentNode.right = left.left;
            }
        }

        return true;
    }
}
