import java.util.HashSet;

class Solution {
    
    final Integer MAX = 10000000;
    HashSet<Integer> uniquePrime = new HashSet<>();
    boolean[] visited = null;
    String[] strList = null;
    boolean[] prime = new boolean[MAX];
    
    public int solution(String numbers) {
        prime[0] = true;
        prime[1] = true;


        for(int i = 2; i <= Math.sqrt(MAX); i++) {
            if(prime[i]) continue;
            for(int j = i * i; j < MAX; j += i) {
                prime[j] = true;
            }
        }

        strList = numbers.split("");
        visited = new boolean[strList.length];

        recursionForPrime(0, "");

        System.out.println(uniquePrime);
        return uniquePrime.size();
    }
    
    
    public void recursionForPrime(int depth, String numToStr){
        if (!numToStr.isEmpty()){
            int number = Integer.parseInt(numToStr);
            if (!prime[number])
                uniquePrime.add(number);
        }

        if (depth >= strList.length)
            return;

        for (int i = 0; i < strList.length; i++) {
            if (!visited[i]){
                visited[i] = true;
                recursionForPrime(depth + 1, numToStr + strList[i]);
                visited[i] = false;
            }
        }
    }
}