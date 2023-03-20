class Solution {
    public int solution(String s) {
        String[] table = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i < table.length; i++)
            s = s.replaceAll(table[i], String.valueOf(i));
        return Integer.parseInt(s);
    }
}