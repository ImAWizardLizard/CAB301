package com.company;

public class BSTree {

    private Node root;

    public BSTree() {
        this.root = null;
    }

    // Check if the BSTree is empty
    public boolean isEmpty() {
        return this.root == null;
    }

    // Find if an element exists within the BSTree given the movie title
    public boolean find(String title) {
        return find(title, this.root);
    }

    public boolean find(String title, Node node) {
        if (node != null) {
            if (title.compareTo(node.getData().getTitle()) == 0) {
                return true;
            } else {
                if (title.compareTo(node.getData().getTitle()) < 0) {
                    return find(title, node.getLeft());
                } else {
                    return find(title, node.getRight());
                }
            }
        } else {
            return false;
        }
    }

    // Retrieve a movie object from the BSTree given a movie title
    public Movie get(String title) {
        return get(title, this.root);
    }

    public Movie get(String title, Node node) {
        if (node != null) {
            if (title.compareTo(node.getData().getTitle()) == 0) {
                return node.getData();
            } else {
                if (title.compareTo(node.getData().getTitle()) < 0) {
                    return get(title, node.getLeft());
                } else {
                    return get(title, node.getRight());
                }
            }
        } else {
            return null;
        }
    }

    // Insert a movie into the BSTree given the movie object
    public void insert(Movie movie) {
        if (this.root == null) {
            this.root = new Node(movie);
        } else {
            insert(movie, this.root);
        }
    }

    public void insert(Movie movie, Node node) {
        if (movie.compare(node.getData()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(movie));
            } else {
                insert(movie, node.getLeft());
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new Node(movie));
            } else {
                insert(movie, node.getRight());
            }
        }
    }

    // Delete an element from the BSTree given the movie title
    public void delete(String title) {
        Node ptr = this.root;
        Node parent = null;
        while ((ptr != null) && (title.compareTo(ptr.getData().getTitle()) != 0)) {
            parent = ptr;
            if (title.compareTo(ptr.getData().getTitle()) < 0) {
                ptr = ptr.getLeft();
            } else {
                ptr = ptr.getRight();
            }
        }

        if (ptr != null) {
            if ((ptr.getLeft() != null) && (ptr.getRight() != null)) {
                if (ptr.getLeft().getRight() == null) {
                    ptr.setData(ptr.getLeft().getData());
                    ptr.setLeft(ptr.getLeft().getLeft());
                } else {
                    Node p = ptr.getLeft();
                    Node pp = ptr;
                    while (p.getRight() != null) {
                        pp = p;
                        p = p.getRight();
                    }
                    ptr.setData(p.getData());
                    pp.setRight(p.getLeft());
                }
            } else {
                Node c;
                if (ptr.getLeft() != null) {
                    c = ptr.getLeft();
                } else {
                    c = ptr.getRight();
                }
                if (ptr == this.root) {
                    this.root = c;
                } else {
                    if (ptr == parent.getLeft()) {
                        parent.setLeft(c);
                    } else {
                        parent.setRight(c);
                    }
                }
            }
        }
    }

    // Traverse the BSTree in order (from lowest values elements to highest valued
    public void InOrderTraverse() {
        this.InOrderTraverse(this.root);
        System.out.println();
    }

    public void InOrderTraverse(Node root) {
        if (root != null) {
            this.InOrderTraverse(root.getLeft());
            System.out.println(root.getData().getTitle());
            this.InOrderTraverse(root.getRight());
        }
    }

    // Get the size of the BSTree
    public int getSize() {
        return getSize(this.root);
    }

    public int getSize(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + getSize(root.getLeft()) + getSize(root.getRight());
    }

    public void clear() {
        this.root = null;
    }

}
