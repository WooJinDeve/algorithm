import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        List<String> bit1 = convertToBinaryString(n, arr1);
        List<String> bit2 = convertToBinaryString(n, arr2);

        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (bit1.get(i).charAt(j) == '1' || bit2.get(i).charAt(j) == '1') {
                    sb.append("#");
                    continue;
                }
                sb.append(" ");
            }
            answer[i] = sb.toString();
        }

        return answer;
    }

    private List<String> convertToBinaryString(int n, int[] arr) {
        return Arrays.stream(arr)
                .mapToObj(Integer::toBinaryString)
                .map(binary -> addEmptyBinaryString(binary, n))
                .collect(Collectors.toList());
    }

    private String addEmptyBinaryString(String binary, int n){
        if (binary.length() == n) {
            return binary;
        }
        return "0".repeat(n - binary.length()) + binary;
    }
}