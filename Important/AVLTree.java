package Important;

class AVLNode {
    int val, height;
    AVLNode left, right;
    AVLNode(int val) { this.val = val; height = 1; }
}

class AVLTree {
    AVLNode root;

    int height(AVLNode n) { return n == null ? 0 : n.height; }
    int balance(AVLNode n) { return n == null ? 0 : height(n.left) - height(n.right); }

    AVLNode rotateRight(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T = x.right;
        x.right = y;
        y.left = T;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T = y.left;
        y.left = x;
        x.right = T;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    AVLNode insert(AVLNode node, int val) {
        if (node == null) return new AVLNode(val);
        if (val < node.val) node.left = insert(node.left, val);
        else if (val > node.val) node.right = insert(node.right, val);

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int bf = balance(node);

        if (bf > 1 && val < node.left.val) return rotateRight(node);
        if (bf < -1 && val > node.right.val) return rotateLeft(node);
        if (bf > 1 && val > node.left.val) { node.left = rotateLeft(node.left); return rotateRight(node); }
        if (bf < -1 && val < node.right.val) { node.right = rotateRight(node.right); return rotateLeft(node); }

        return node;
    }
}
