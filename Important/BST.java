package Important;

class BSTNode {
    int val;
    BSTNode left, right;
    BSTNode(int val) { this.val = val; }
}

class BST {
    BSTNode root;

    void insert(int val) {
        root = insertRec(root, val);
    }

    BSTNode insertRec(BSTNode node, int val) {
        if (node == null) return new BSTNode(val);
        if (val < node.val) node.left = insertRec(node.left, val);
        else if (val > node.val) node.right = insertRec(node.right, val);
        return node;
    }

    boolean search(int val) {
        BSTNode cur = root;
        while (cur != null) {
            if (cur.val == val) return true;
            cur = val < cur.val ? cur.left : cur.right;
        }
        return false;
    }
}
