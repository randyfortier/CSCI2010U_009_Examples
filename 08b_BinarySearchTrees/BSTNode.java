public class BSTNode {
    public BSTNode parent = null;
    public BSTNode left = null;
    public BSTNode right = null;
    public int value = 0;

    public void insert(int newValue) {
        if (newValue < this.value) {
            // go left (insert into the left subtree)
            if (this.left == null) {
                // we have no left child, so add it there
                BSTNode newNode = new BSTNode();
                newNode.parent = this;
                newNode.value = newValue;
                this.left = newNode;
            } else {
                // recursively insert into the left subtree
                this.left.insert(newValue);
            }
        } else {
            if (this.right == null) {
                // we have no right child, so add it there
                BSTNode newNode = new BSTNode();
                newNode.parent = this;
                newNode.value = newValue;
                this.right = newNode;
            } else {
                // recursively insert into the right subtree
                this.right.insert(newValue);
            }
        }
    }

    public void print() {
        print(0);
    }

    public void print(int depth) {
        // right child (depth + 1)
        if (this.right != null) {
            this.right.print(depth + 1);
        }

        // node (depth)
        for (int i = 0; i < depth; i++) {
            System.out.print("   ");
        }
        System.out.println(this.value);

        // left child (depth + 1)
        if (this.left != null) {
            this.left.print(depth + 1);
        }
    }

    public static void main(String[] args) {
        BSTNode root = new BSTNode();
        root.value = 10;
        root.insert(8);
        root.insert(16);
        root.print();
    }
}