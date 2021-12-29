package main.java;

import java.util.LinkedList;

public class DomTree {

    private final TreeNode<String> root;
    private Integer height = 0;

    public DomTree(TreeNode<String> root) {
        this.root = root;
    }

    private TreeNode<String> goDown(TreeNode<String> node) {
        height++;
        return node.getLeftChild();
    }

    private TreeNode<String> goUp(TreeNode<String> node) {
        height--;
        return node.getParent();
    }

    private TreeNode<String> goRight(TreeNode<String> node) {
        return node.getRightNeighbour();
    }

    private void printResult(LinkedList<TreeNode<String>> result) {
        while (!result.isEmpty()) {
            System.out.print(result.poll().getData());
        }
        System.out.println();
    }


    public void preorderTraversal() {

        LinkedList<TreeNode<String>> result = new LinkedList<>();
        TreeNode<String> current = root;
        result.add(current);
        while (current.getLeftChild() != null) {
            current = goDown(current);
            result.add(current);
        }

        while (height > 0) {
            while (current.getRightNeighbour() != null) {
                current = goRight(current);
                result.add(current);
                while (current.getLeftChild() != null) {
                    current = goDown(current);
                    result.add(current);
                }
            }
            current = goUp(current);
        }
        printResult(result);
    }


    public void postorderTraversal() {
        LinkedList<TreeNode<String>> result = new LinkedList<>();

        TreeNode<String> current = root;
        while (current.getLeftChild() != null) {
            current = goDown(current);
        }

        while (height > 0) {
            result.add(current);
            while (current.getRightNeighbour() != null) {
                current = goRight(current);
                while (current.getLeftChild() != null) {
                    current = goDown(current);
                }
                result.add(current);
            }
            current = goUp(current);
        }

        result.add(current);
        printResult(result);
    }

    public void levelOrderTraversal() {
        LinkedList<TreeNode<String>> result = new LinkedList<>();
        LinkedList<TreeNode<String>> list = new LinkedList<>();

        TreeNode<String> current;
        list.add(root);
        result.add(root);

        while (!list.isEmpty()) {
            current = list.poll();

            if (current.getLeftChild() != null) {
                current = goDown(current);
                result.add(current);
                list.add(current);

                while (current.getRightNeighbour() != null) {
                    current = goRight(current);
                    result.add(current);
                    list.add(current);
                }
            }
        }
        printResult(result);
    }

    public void recursivePreorderTraversal(TreeNode<String> node) { //root, left, right
//        if (node) {
//            printf("%d ", root->data);
//            recursivePreorderTraversal(???? root->left);
//            recursivePreorderTraversal(???? root->right);
//        }
    }

    public void recursivePostorderTraversal(TreeNode<String> node) { //left, right, root
//        if (node) {
//            recursivePostorderTraversal(??? root->left);
//            recursivePostorderTraversal(??? root->right);
//            printf("%d ", root->data);
//        }
    }


    private void recursiveLvlTraversalOnLists(LinkedList<TreeNode<String>> list, LinkedList<TreeNode<String>> result) {
        if (list.isEmpty()) return;
        TreeNode<String> node = list.poll();
        if (node.getLeftChild() == null) {
            while (node.getLeftChild() == null && !list.isEmpty()) {
                node = list.poll();
            }
            if (list.isEmpty()) return;
        }
        node = goDown(node);
        result.add(node);
        list.add(node);
        while (node.getRightNeighbour() != null) {
            node = node.getRightNeighbour();
            result.add(node);
            list.add(node);
        }
        recursiveLvlTraversalOnLists(list, result);
    }

    public void recursiveLevelOrderTraversal() {
        LinkedList<TreeNode<String>> list = new LinkedList<>();
        LinkedList<TreeNode<String>> result = new LinkedList<>();
        list.add(root);
        result.add(root);
        recursiveLvlTraversalOnLists(list, result);
        printResult(result);
    }

}
