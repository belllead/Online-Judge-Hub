import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] c1 = sc.next().toCharArray();
		char[] c2 = sc.next().toCharArray();
		
		int[][] dp = new int[c1.length][c2.length];
		dp[0][0] = c1[0] == c2[0] ? 1 : 0;
		
		for (int i=0; i<c1.length; i++) {
			for (int j=0; j<c2.length; j++) {
				if (i == 0 && j == 0) continue;
				if (i==0) {
					if (c1[i] == c2[j]) dp[i][j] = 1;
					else dp[i][j] = dp[i][j-1];
				} else if (j == 0) {
					if (c1[i] == c2[j]) dp[i][j] = 1;
					else dp[i][j] = dp[i-1][j];
				} else {
					if (c1[i] == c2[j]) dp[i][j] = dp[i-1][j-1] + 1; 
					else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[c1.length-1][c2.length-1]);
		
		sc.close();
	}
}