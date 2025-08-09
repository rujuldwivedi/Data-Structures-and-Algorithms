package Important;

class SparseTable {
    int[][] st;
    int[] log;

    SparseTable(int[] arr) {
        int n = arr.length;
        log = new int[n + 1];
        for (int i = 2; i <= n; i++)
            log[i] = log[i / 2] + 1;

        int K = log[n] + 1;
        st = new int[n][K];
        for (int i = 0; i < n; i++) st[i][0] = arr[i];

        for (int j = 1; j < K; j++)
            for (int i = 0; i + (1 << j) <= n; i++)
                st[i][j] = Math.min(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
    }

    int query(int L, int R) {
        int j = log[R - L + 1];
        return Math.min(st[L][j], st[R - (1 << j) + 1][j]);
    }
}
