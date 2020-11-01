class SolveNQueens {
    private final char dot = '.';
    private final char q = 'Q';

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            for (int i = 0; i < chars.length; ++i) {
                chars[i] = dot;
            }
        }
        List<List<String>> res = new ArrayList<>();
        dfs(board, 0, res);
        return res;
    }

    private void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if (board.length == colIndex) {
            res.add(construct(board));
            return;
        }
        for (int i = 0; i < board.length; ++i) {
            if (validate(board, i, colIndex)) {
                board[i][colIndex] = q;
                dfs(board, colIndex+1, res);
                board[i][colIndex] = dot;
            }
        }
    }

    private boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == q && (x+j==y+i || x+y == i+j || x==i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>(board.length);
        for (char[] cs : board) {
            list.add(new String(cs));
        }
        return list;
    }
}