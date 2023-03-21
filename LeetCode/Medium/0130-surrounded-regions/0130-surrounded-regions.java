class Solution {
    
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    
    // new char[board.length][board[0].length]
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] boards;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O' && validateSurroundRegions(i, j, n, m)){
                    boards = new int[n][m];
                    if(bfs(board, boards, i, j, n, m)) paintedX(board, boards, n, m);
                }                
            }
        }
    }
    
    
    public boolean bfs(char[][] board, int[][] boards, int i, int j, int n, int m){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        boards[i][j] = 1;
        
        while(!q.isEmpty()){
            int e[] = q.remove();
            for(int k = 0; k < 4; k++){
                int x = e[0] + dx[k];
                int y = e[1] + dy[k];
                if(x >= 0 && x < n && y >= 0 && y < m && board[x][y] == 'O' && boards[x][y] == 0){
                    if(!validateSurroundRegions(x, y, n, m)) return false;
                    q.add(new int[]{x, y});
                    boards[x][y] = 1;
                }
            }
        }
        return true;
    }
    
    private boolean validateSurroundRegions(int x, int y, int n, int m){
        for(int k = 0; k < 4; k++){
            if(x + dx[k] >= 0 && x + dx[k] < n && y + dy[k] >= 0 && y + dy[k] < m)
                continue;
            return false;
        }
        return true;
    }
    
    private void paintedX(char[][] board, int[][] boards, int n, int m){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(boards[i][j] == 1) board[i][j] = 'X';
            }
        }
    }
}