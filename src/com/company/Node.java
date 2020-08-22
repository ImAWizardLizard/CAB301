package com.company;

public class Node {
    private Movie data;
    private Node left;
    private Node right;

    public Node(Movie data) {
        this.data = data;
        left = null;
        right = null;

    }

    public Movie getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setData(Movie data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    // Get the size of the sub-trees including the current node
    public int getSize() {
        int leftNodeSize = 0;
        int righNodeSize = 0;

        // If the left subtree is not null
        if (this.left != null) {
            this.left.getSize();
        }

        // If the right subtree is not null
        if (this.right != null) {
            this.right.getSize();
        }

        // Add the current node + the size of the left and right subtrees
        return 1 + leftNodeSize + righNodeSize;

    }

}
