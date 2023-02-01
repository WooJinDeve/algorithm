import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        answer = Math.max(answer, find(arrayA, arrayB));
        answer = Math.max(answer, find(arrayB, arrayA));
        return answer;
    }

    private int find(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        List<Integer> divisions = prime(arr1[0]);
        divisions.sort(Collections.reverseOrder());

        for (Integer division : divisions) {
            if (divisionCheck(division, arr1) && nonDivisionCheck(division, arr2) ||
                    divisionCheck(division, arr2) && nonDivisionCheck(division, arr1)) {
                return division;
            }
        }
        return 0;
    }

    private boolean divisionCheck(int div, int[] arr) {
        for (int element : arr) {
            if (element % div != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean nonDivisionCheck(int div, int[] arr) {
        for (int element : arr) {
            if (element % div == 0) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> prime(int num) {
        List<Integer> prime = new LinkedList<>();
        prime.add(num);
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                prime.add(i);
                prime.add(num / i);
            }
        }
        return prime;
    }
}