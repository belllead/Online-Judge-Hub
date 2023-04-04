import java.util.Scanner;

public class Main {

	static long[] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		memo = new long[N+1];
		
		System.out.println(dp(N));
		sc.close();
	}

	private static long dp(int n) {
		if (n == 0)
			return 0;
		
		if (n == 1)
			return 1;
		
		if (n == 2)
			return 2;
		
		if (memo[n] != 0)
			return memo[n];
		
		memo[n] = (dp(n-1) + dp(n-2)) % 10007;
		
		return memo[n];
	}
}