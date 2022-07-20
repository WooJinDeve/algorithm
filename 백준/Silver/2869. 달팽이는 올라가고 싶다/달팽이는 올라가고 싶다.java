import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			st = new StringTokenizer(br.readLine(), " ");
			int up = Integer.parseInt(st.nextToken());
			int down = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
	 
			int day = (length - down) / (up - down);
			if ((length - down) % (up - down) != 0)
				day++;
	 
			System.out.println(day);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
