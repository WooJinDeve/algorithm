import java.util.*;

class Solution {
    private List<int[]> saleEmoticons = new ArrayList<>();

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        int n = emoticons.length;
        setSaleEmoticons(0, new int[n], n);


        for (int[] sales : saleEmoticons) {

            int plus = 0;
            int sale = 0;

            for (int[] user : users) {
                int percent = user[0];
                int money = user[1];

                int totalPrice = 0;

                for (int i = 0; i < sales.length; i++) {
                    if (sales[i] >= percent) {
                        totalPrice += emoticons[i] - (emoticons[i] * sales[i]) / 100;
                    }
                }

                if (money <= totalPrice) {
                    totalPrice = 0;
                    plus++;
                }
                sale += totalPrice;
            }

            if (answer[0] == plus && answer[1] < sale) {
                answer[1] = sale;
            }

            if (answer[0] < plus) {
                answer[0] = plus;
                answer[1] = sale;
            }
        }

        return answer;
    }

    private void setSaleEmoticons(int depth, int[] emoticons, int N){
        if (depth == N) {
            saleEmoticons.add(emoticons.clone());
            return;
        }

        for (int i = 10; i <= 40; i += 10) {
            emoticons[depth] = i;
            setSaleEmoticons(depth + 1, emoticons, N);
        }
    }
}