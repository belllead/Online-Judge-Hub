import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] dp = new int[1000001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		for (int i=4; i<=N; i++) {
			dp[i] = dp[i-1] + 1;
			
			if (i % 3 == 0) {
				int t3 = Math.min(dp[i/3], dp[i-1]) + 1;
				dp[i] = Math.min(dp[i], t3);	
			}
			
			if (i % 2 == 0) {
				int t2 = Math.min(dp[i/2], dp[i-1]) + 1;
				dp[i] = Math.min(dp[i], t2);
			}
			
		}
		System.out.println(dp[N]);
	}
	
}