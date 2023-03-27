import java.util.Scanner;

public class Solution {

	static int T, N, M, sum, max;
	static int[][] field;
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();


	
	public static void main(String[] args) {
		
		T = sc.nextInt();
		
		sum = 0;
		max = 0;
		
		for (int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			chae(tc, N, M);
		}
		
		System.out.println(sb);
		
	}
	
	
	public static void chae(int testCase, int N, int M) {
		
		field = new int[N][N];
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				field[r][c] = sc.nextInt();
			}
		}
		
		for (int i=0; i<=N-M; i++) {
			for (int j=0; j<=N-M; j++) {
				for (int r=i; r<i+M; r++) {
					for (int c=j; c<j+M; c++) {
						sum += field[r][c];
					}
				}
				if (max < sum) max = sum;
				sum = 0;
			}			
		}
		
		sb.append("#").append(testCase).append(" ").append(max).append("\n");
		max = 0;		
		
	}
	
	
	
}