import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        return IntStream.range(0, n)
                .mapToObj(i -> Integer.toBinaryString(arr1[i] | arr2[i]))
                .map(binary -> String.format("%" + n + "s", binary))
                .map(binary -> binary.replaceAll("1", "#").replaceAll("0", " "))
                .toArray(String[]::new);
    }
}