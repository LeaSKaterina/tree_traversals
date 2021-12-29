package main.java;


public class Main {

    public static void main(String[] args) {

        TreeNode<String> root = new TreeNode<>("L");

        DomTree tree = new DomTree(root);

        TreeNode<String> nodeB = new TreeNode<>("B");
        TreeNode<String> nodeF = new TreeNode<>("F");
        TreeNode<String> nodeI = new TreeNode<>("I");
        TreeNode<String> nodeA = new TreeNode<>("A");
        TreeNode<String> nodeD = new TreeNode<>("D");
        TreeNode<String> nodeC = new TreeNode<>("C");
        TreeNode<String> nodeE = new TreeNode<>("E");
        TreeNode<String> nodeH = new TreeNode<>("H");
        TreeNode<String> nodeJ = new TreeNode<>("J");
        TreeNode<String> nodeK = new TreeNode<>("K");
        TreeNode<String> nodeG = new TreeNode<>("G");


        root.addChild(nodeB);
        root.addChild(nodeF);
        root.addChild(nodeI);
        nodeB.addChild(nodeA);
        nodeB.addChild(nodeD);
        nodeD.addChild(nodeC);
        nodeF.addChild(nodeE);
        nodeI.addChild(nodeH);
        nodeI.addChild(nodeJ);
        nodeI.addChild(nodeK);
        nodeH.addChild(nodeG);

        tree.preorderTraversal();
        tree.recursivePreorderTraversal(root);

        tree.postorderTraversal();
        tree.recursivePostorderTraversal(root);

        tree.levelOrderTraversal();
        tree.recursiveLevelOrderTraversal();

    }

}
