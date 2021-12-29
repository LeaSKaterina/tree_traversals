package main.java;


public class TreeNode<T> {

    T data;
    TreeNode<T> parent = null;
    TreeNode<T> rightNeighbour = null;
    TreeNode<T> leftChild = null;

    public TreeNode(T data) {
        this.data = data;
    }

    public void addChild(TreeNode<T> child) {
        child.parent = this;
        if (leftChild == null){
            leftChild = child;
        } else{
            if (leftChild.getRightNeighbour() == null){
                leftChild.setRightNeighbour(child);
            } else {
                TreeNode buffer = leftChild.getRightNeighbour();
                while (buffer.getRightNeighbour() != null){
                    buffer = buffer.getRightNeighbour();
                }
                buffer.setRightNeighbour(child);
            }
        }
    }

    public T getData(){
        return data;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public TreeNode<T> getRightNeighbour() {
        return rightNeighbour;
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public void setRightNeighbour(TreeNode<T> rightNeighbour) {
        this.rightNeighbour = rightNeighbour;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }
}

