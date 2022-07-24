import java.util.*;

public class Main {
    public static void main(String[] args){
        StringTokenizer st = new StringTokenizer(new Scanner(System.in).nextLine(), "-");

        int result = Integer.MAX_VALUE;

        while (st.hasMoreTokens()){
            int temp = 0;

            StringTokenizer temp_st = new StringTokenizer(st.nextToken(), "+");

            // 덧셈으로 나뉜 토큰들을 모두 더한다.
            while (temp_st.hasMoreTokens()) {
                temp += Integer.parseInt(temp_st.nextToken());
            }

            if(result == Integer.MAX_VALUE)
                result = temp;
            else
                result -= temp;
        }
        System.out.println(result);
    }
}
