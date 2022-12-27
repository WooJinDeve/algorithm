import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<Move> dist = new HashSet<>();
        int x = 0;
        int y = 0;
        for (char ch : dirs.toCharArray()) {
            int[] point = getPoint(ch);
            int dx = point[0] + x;
            int dy = point[1] + y;
            if (dx >= -5 && dx <= 5 && dy >= -5 && dy <= 5) {
                    dist.add(new Move(x, y, dx, dy));
                    dist.add(new Move(dx, dy, x, y));
                x = dx;
                y = dy;
            }
        }
        return dist.size() / 2;
    }

    private int[] getPoint(char ch) {
        switch (ch) {
            case 'U': return new int[]{0, 1};
            case 'D': return new int[]{0, -1};
            case 'R': return new int[]{1, 0};
            case 'L': return new int[]{-1, 0};
            default: return null;
        }
    }

    class Move {
        private int preX;
        private int preY;
        private int curX;
        private int curY;

        public Move(int preX, int preY, int curX, int curY) {
            this.preX = preX;
            this.preY = preY;
            this.curX = curX;
            this.curY = curY;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Move)) return false;
            Move move = (Move) o;
            return preX == move.preX && preY == move.preY && curX == move.curX && curY == move.curY;
        }

        @Override
        public int hashCode() {
            return Objects.hash(preX, preY, curX, curY);
        }
    }
}