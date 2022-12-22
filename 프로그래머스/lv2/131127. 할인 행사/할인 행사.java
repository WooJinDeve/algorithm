import java.util.Arrays;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int count = 0;
        int maxDay = 0;
        for (int i : number) {
            maxDay += i;
        }
        maxDay = discount.length - maxDay + 1;

        for (int i = 0; i < maxDay; i++) {
            int[] dummyArr = Arrays.copyOf(number, number.length);
            boolean ok = true;
            for (int j = 0; j < number.length; j++) {
                for (int k = i; k < i + 10; k++) {
                    if (k >= discount.length)
                        break;
                    if(want[j].equals(discount[k]))
                        dummyArr[j]--;
                }
            }

            for (int dummy : dummyArr) {
                if (dummy > 0) {
                    ok = false;
                    break;
                }
            }

            if (ok)
                count++;
        }
        return count;
    }
}