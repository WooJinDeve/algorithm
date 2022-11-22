import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack[] boardStack = new Stack[board[0].length];
        Stack<Integer> bag = new Stack<>();
        for (int i = 0; i < board[0].length; i++)
            boardStack[i] = new Stack<Integer>();


        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] != 0)
                    boardStack[j].push(board[i][j]);
        }

        for (int move : moves) {
            if (boardStack[move - 1].isEmpty())
                continue;
            int doll = (int) boardStack[move - 1].pop();

            if (!bag.isEmpty() && Objects.equals(bag.peek(), doll)) {
                answer+=2;
                bag.pop();
                continue;
            }

            bag.add(doll);
        }

        return answer;
    }
}