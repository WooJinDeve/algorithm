import java.io.*;
import java.util.*;

public class Main {
	static int[] tmp;
	static int count = 0;
	static int result = -1;
	static int K;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		tmp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		merge_sort(arr, 0, arr.length-1);
		System.out.print(result);
		
	}	
	
	public static void merge_sort(int A[], int start, int end) { // A[p..r]을 오름차순 정렬한다.
		if (start < end) {
	        int mid = (start + end) / 2;      // q는 p, r의 중간 지점
	        merge_sort(A, start, mid);      // 전반부 정렬
	        merge_sort(A, mid + 1, end);  // 후반부 정렬
	        merge(A, start, mid, end);        // 병합
	    }
	}

	//A[p..q]와 A[q+1..r]을 병합 A[p..r] 오름차순 정렬
	//A[p..q]와 A[q+1..r]은 이미 오름차순 정렬
	public static void merge(int A[],int start,int mid,int end) {
	    int i = start;
	    int j = mid + 1;
	    int t = 0;
	    
	    //A배열에서 비교하고 작은 쪽 tmp배열에 저장
	    while (i <= mid && j <= end) {
	        if (A[i] <= A[j]) { //A배열에 i번째 tmp배열에 저장
	        	tmp[t++] = A[i++]; //i번째 저장하고 다음 t, i로 넘어감
	        }
	        else { //A배열에 j번째 tmp배열에 저장
	        	tmp[t++] = A[j++]; //j번째 저장했으므로 다음 t, j로 넘어감
	        }
	    }
	    while (i <= mid)  //왼쪽 배열 부분이 남은 경우
	        tmp[t++] = A[i++];
	    while (j <= end)  //오른쪽 배열 부분이 남은 경우
	        tmp[t++] = A[j++];
	    
	    i = start;
	    t = 0;
	    while (i <= end) { //tmp에 저장한 결과를 A[p..r]에 저장
	    	count++;
	    	if(count==K) { //K번째로 저장
	    		result = tmp[t]; //K번째로 저장되는 수
	    		break;
	    	}
	        A[i++] = tmp[t++];
	    }
	}
		
	
}