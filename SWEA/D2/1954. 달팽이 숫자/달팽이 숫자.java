import java.util.Scanner;

public class Solution {
	static int cnt, N;
	static int[][] snail;
	static StringBuilder sb = new StringBuilder();	

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			snail = new int[N][N];
			
			sb.append("#" + tc + "\n");
			
			snailNum(0, 0, N-1, N-1, 1);
		}
		
		System.out.println(sb.toString());
		sc.close();
						
	}
	
	public static void snailNum(int startRow, int startCol, int endRow, int endCol, int startCnt) {			
		cnt = startCnt;
		
		for (int c=startCol; c<=endCol; c++) {
			snail[startRow][c] = cnt++;
		}
		
		for (int r=startRow+1; r<=endRow; r++) {
			snail[r][endCol] = cnt++;
		}
		
		for (int c=endCol-1; c>=startCol; c--) {
			snail[endRow][c] = cnt++;
		}
		
		for (int r=endRow-1; r>=startRow+1; r--) {
			snail[r][startCol] = cnt++;
		}
		
		if (cnt == N * N + 1) {
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					sb.append(snail[r][c] + " ");
				}
				sb.append("\n");
			}
			return;
		} else {
			snailNum(startRow+1, startCol+1, endRow-1, endCol-1, cnt);
		}
			
	}
	
}