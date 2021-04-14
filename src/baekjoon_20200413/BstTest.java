package baekjoon_20200413;

public class BstTest {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(9);
        binarySearchTree.add(5);
        binarySearchTree.add(2);
        binarySearchTree.add(7);
        binarySearchTree.add(6);
        binarySearchTree.add(8);
        binarySearchTree.add(1);
        binarySearchTree.add(4);
        binarySearchTree.add(3);
        binarySearchTree.add(10);
        binarySearchTree.add(11);
        binarySearchTree.add(12);

        binarySearchTree.print();
        System.out.println();
        binarySearchTree.delete(5);
        binarySearchTree.print();
    }
}
