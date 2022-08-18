import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //정수입력
        Byte N = sc.nextByte();
        Byte M = sc.nextByte();
        
        // A,B 2차배열 생성
        int [][] A = new int[N][M];
        int [][] B = new int[N][M];
        
        //A 2차배열 값 입력
        for(int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                A[i][j] = sc.nextByte();
            }
        }
        //B 2차배열 값 입력
        for(int i = 0 ; i < N ; i++) {
            for (int j = 0; j < M; j++) {
                B[i][j] = sc.nextByte();
            }
        }
        // A와 B의 각각의 인덱스 값 합 출력
        for(int i = 0 ; i < N ; i++) {
             for (int j = 0 ; j < M ; j++) {
                System.out.print(A[i][j]+B[i][j]+" ");
                if(j == M-1)
                    System.out.println();
             }
         }
    }
}