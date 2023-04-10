import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] coin = new int[n];
		
		for (int i=0; i<n; i++) {
			coin[i] = sc.nextInt();
		}
		
		int[][] dp = new int[n][k+1];
		
		for (int r=0; r<n; r++) {
			for (int c=0; c<k+1; c++) {
				if (c == 0) dp[r][c] = 1;
				else if (r == 0) {
					if (c % coin[r] == 0) dp[r][c] = 1;
					else dp[r][c] = 0;
				} else {
					if (coin[r] > c) dp[r][c] = dp[r-1][c];
					else {
						for (int cc=c; cc>=0; cc-=coin[r]) {
							dp[r][c] += dp[r-1][cc];
						}
					}
				}
			}
		}
		
		System.out.println(dp[n-1][k]);
		sc.close();
		
	}
}