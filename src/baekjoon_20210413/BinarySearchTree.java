package baekjoon_20210413;

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

    public boolean search(int searchNode) {
        Node currentNode = root;

        while (true) {
            if (currentNode == null) {
                return false;
            }

            if (searchNode == currentNode.value) {
                return true;
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

    public void delete(int deleteNode) {
        Node currentNode = root;
        Node parentNode = null;
        boolean isLeftChild = true;

        while (true) {
            if (currentNode == null) {
                return;
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

        Node childNode = currentNode.left == null ? currentNode.right : currentNode.left;

        if (currentNode.left != null && currentNode.right != null) {
            parentNode = currentNode;
            isLeftChild = true;

            while (childNode.right != null) {
                parentNode = childNode;
                childNode = childNode.right;
                isLeftChild = false;
            }

            currentNode = childNode;

            if (isLeftChild) {
                parentNode.left = childNode.left;
            } else {
                parentNode.right = childNode.left;
            }
        } else {
            if (currentNode == root) {
                root = childNode;
            } else if (isLeftChild) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
        }
    }

    public void print() {
        printSubTree(root);
    }

    private void printSubTree(Node node) {
        if (node != null) {
            printSubTree(node.left);
            System.out.print(node.value + ", ");
            printSubTree(node.right);
        }
    }
}
