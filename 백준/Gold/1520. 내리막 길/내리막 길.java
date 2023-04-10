import java.util.Scanner;

public class Main {

	static int M, N;
	static int[][] mount, dp;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1}; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		mount = new int[M][N];
		dp = new int[M][N];
		for (int r=0; r<M; r++) {
			for (int c=0; c<N; c++) {
				mount[r][c] = sc.nextInt();
				dp[r][c] = -1;
			}
		}
		
		System.out.println(dfs(0, 0));
		
		sc.close();
	}
	
	private static int dfs(int r, int c) {
		if (r == M-1 && c == N-1) {
			return 1;
		}
		
		if (dp[r][c] != -1)
			return dp[r][c];
		
		dp[r][c] = 0;
		
		for (int i=0; i<4; i++) {
			int tr = r + dr[i];
			int tc = c + dc[i];
			
			if (tr >= 0 && tr < M && tc >= 0 && tc < N && mount[tr][tc] < mount[r][c]) {
				dp[r][c] += dfs(tr, tc);
			}
		}
		
		return dp[r][c];
	}
}