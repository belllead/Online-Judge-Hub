import java.util.Scanner;

public class Main {

	static final int INF = 9876543;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] dp = new int[N+1];
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 0;

		for (int i=3; i<N+1; i++) {
			int t3 = i % 3 == 0 ? i / 3 : INF;
			int t5 = i % 5 == 0 ? i / 5 : INF;
			int d3 = i > 6 ? dp[i-3] + 1 : INF;
			int d5 = i > 10 ? dp[i-5] + 1 : INF;
			
			dp[i] = Math.min(t3, Math.min(t5, Math.min(d3, d5)));
		}
		
		System.out.println(dp[N] == INF ? -1 : dp[N]);
	}
}