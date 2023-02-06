import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int groupA = 0;
        int groupB = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < cards.length; i++) {
            Set<Integer> size = choose(i, cards, new HashSet<>());
            if (groupA < size.size()){
                groupA = size.size();
                visited = size;
            }

            if (size.size() == cards.length) {
                return 0;
            }
        }

        for (int i = 0; i < cards.length; i++) {
            if (!visited.contains(i)) {
                int size = choose(i, cards, new HashSet<>(visited)).size() - groupA;
                if (groupB < size) {
                    groupB = size;
                }
            }
        }
        return groupA * groupB;
    }

    private Set<Integer> choose(int i, int[] cards, Set<Integer> boxing) {
        boxing.add(i);
        int idx = i;

        for (int j = 0; j < cards.length; j++) {
            idx = cards[idx] - 1;
            if (!boxing.add(idx)){
                return boxing;
            }
        }
        return boxing;
    }
}