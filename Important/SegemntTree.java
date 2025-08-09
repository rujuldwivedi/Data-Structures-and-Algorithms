package Important;

class SegmentTree {
    int[] tree, arr;
    int n;

    SegmentTree(int[] arr) {
        this.arr = arr;
        n = arr.length;
        tree = new int[4 * n];
        build(0, 0, n - 1);
    }

    void build(int node, int l, int r) {
        if (l == r) tree[node] = arr[l];
        else {
            int mid = (l + r) / 2;
            build(2 * node + 1, l, mid);
            build(2 * node + 2, mid + 1, r);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    int query(int node, int l, int r, int ql, int qr) {
        if (qr < l || ql > r) return 0; // no overlap
        if (ql <= l && r <= qr) return tree[node]; // total overlap
        int mid = (l + r) / 2;
        return query(2 * node + 1, l, mid, ql, qr) +
               query(2 * node + 2, mid + 1, r, ql, qr);
    }

    void update(int node, int l, int r, int idx, int val) {
        if (l == r) tree[node] = val;
        else {
            int mid = (l + r) / 2;
            if (idx <= mid) update(2 * node + 1, l, mid, idx, val);
            else update(2 * node + 2, mid + 1, r, idx, val);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }
}
