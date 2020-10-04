class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0, rowLen = grid.length; i < rowLen; ++i) {
            for (int j = 0, colLen = grid[0].length; j < colLen; ++j) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfsErase(grid, i, j);
                }
            }
        }
        return islands;
    }

    private void dfsErase(char[][]grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfsErase(grid, row-1, col);
        dfsErase(grid, row+1, col);
        dfsErase(grid, row, col-1);
        dfsErase(grid, row, col+1);
    }
}