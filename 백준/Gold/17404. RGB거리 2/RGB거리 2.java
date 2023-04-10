import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int[][] cost;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N][3];
		for (int i=0; i<3; i++) {
			dp[0][i] = cost[0][i];
		}
		
		// 1번이 R일때
		
		dp[1][0] = INF;
		dp[1][1] = cost[0][0] + cost[1][1];
		dp[1][2] = cost[0][0] + cost[1][2];
		
		for (int i=2; i<N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
		}

		int min = Math.min(dp[N-1][1], dp[N-1][2]);
	
		// 1번이 G일때
		dp[1][0] = cost[0][1] + cost[1][0];
		dp[1][1] = INF;
		dp[1][2] = cost[0][1] + cost[1][2];
		
		for (int i=2; i<N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
		}

		min = Math.min(min, Math.min(dp[N-1][0], dp[N-1][2]));
		
		// 1번이 B일때
		dp[1][0] = cost[0][2] + cost[1][0];
		dp[1][1] = cost[0][2] + cost[1][1];
		dp[1][2] = INF;
		
		for (int i=2; i<N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
		}

		min = Math.min(min, Math.min(dp[N-1][0], dp[N-1][1]));
	
		System.out.println(min);
		
	}
	
}