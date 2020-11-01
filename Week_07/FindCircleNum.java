class FindCircleNum {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (parent[i] == -1) count++;
        }
        return count;
    }

    private void union(int[] parent, int x, int y) {
        int xP = find(parent, x);
        int yP = find(parent, y);
        if (xP != yP) parent[xP] = yP;
    }

    private int find(int[] parent, int x) {
        if (-1 == parent[x]) return x;
        return find(parent, parent[x]);
    }
}