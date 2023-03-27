import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] memo = new int[12];
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;
		
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(dp(N) + "\n");
		}
		
		System.out.println(sb);
	}
	
	static int dp(int N) {
		if (memo[N] > 0)
			return memo[N];
		
		return dp(N-1) + dp(N-2) + dp(N-3);
	}
}