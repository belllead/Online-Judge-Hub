import java.util.Scanner;

public class Main {

	static int N, max;
	static int[] stair, memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		stair = new int[N];
		for (int i=0; i<N; i++) {
			stair[i] = sc.nextInt();
		}
		
		memo = new int[301];
		
		memo[0] = stair[0];
		
		System.out.println(dp(N-1));
		sc.close();
	}
	
	private static int dp(int n) {
		if (n < 0)
			return 0;
		
		if (memo[n] != 0)
			return memo[n];
		
		if (n == 1)
			memo[1] = memo[0] + stair[1];
		
		if (n == 2)
			memo[2] = Math.max(memo[0], memo[1]) + stair[2];
		
		if (N >= 3) 
			memo[n] = Math.max(dp(n-2), dp(n-3) + stair[n-1]) + stair[n];
		
		return memo[n];
	}
}