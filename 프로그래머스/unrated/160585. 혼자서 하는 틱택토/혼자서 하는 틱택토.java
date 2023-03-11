import java.util.*;
import java.util.stream.*;

class Solution {
     public int solution(String[] board) {
        List<char[]> listBoard = Arrays.stream(board).map(String::toCharArray).collect(Collectors.toList());

        int a1, b1, x1, y1;
        a1 = b1 = x1 = y1 = 0;

        for (String b : board) {
            for (char c : b.toCharArray()) {
                if (c == 'O') a1++;
                else if(c == 'X') b1++;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[i].equals("OOO")) x1++;
            if (board[i].equals("XXX")) y1++;
            if (listBoard.get(0)[i] == 'O' && listBoard.get(1)[i] == 'O' && listBoard.get(2)[i] == 'O') x1++;
            if (listBoard.get(0)[i] == 'X' && listBoard.get(1)[i] == 'X' && listBoard.get(2)[i] == 'X') y1++;
        }
        if (listBoard.get(0)[0] == 'O' && listBoard.get(0)[0] == listBoard.get(1)[1] && listBoard.get(0)[0] == listBoard.get(2)[2]) x1++;
        if (listBoard.get(0)[0] == 'X' && listBoard.get(0)[0] == listBoard.get(1)[1] && listBoard.get(0)[0] == listBoard.get(2)[2]) y1++;
        if (listBoard.get(0)[2] == 'O' && listBoard.get(0)[2] == listBoard.get(1)[1] && listBoard.get(0)[2] == listBoard.get(2)[0]) x1++;
        if (listBoard.get(0)[2] == 'X' && listBoard.get(0)[2] == listBoard.get(1)[1] && listBoard.get(0)[2] == listBoard.get(2)[0]) y1++;

        if(a1 - b1 > 1 || a1 < b1) return 0;
        if (x1 + y1 > 1) return x1 > 1 && a1 - b1 == 1 ? 1 : 0;
        if ((x1 == 1 && a1 - b1 != 1) || (y1 == 1 && a1 - b1 != 0)) return 0;
        return 1;
    }
}