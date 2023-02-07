class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
                continue;
            }
            char[] binary = ("0" + Long.toBinaryString(numbers[i])).toCharArray();
            for (int j = binary.length -1; j >= 0 ; j--) {
                if (binary[j] == '0') {
                    binary[j] = '1';
                    binary[j + 1] = '0';
                    break;
                }
            }
            answer[i] = Long.parseLong(String.valueOf(binary), 2);
        }
        return answer;
    }
}