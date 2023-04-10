import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		
		for (int i=0; i<N; i++) {
			num[i] = sc.nextInt();
		}
		
		int[] increase = new int[N];
		int[] decrease = new int[N];
		Arrays.fill(increase, 1);
		
		for (int i=0; i<N; i++) {
			for (int j=i-1; j>=0; j--) {
				if (num[j] < num[i]) 
					increase[i] = Math.max(increase[i], increase[j] + 1);
			}
			
		}

		for (int i=N-1; i>=0; i--) {
			for (int j=i+1; j<N; j++) {
				if (num[j] < num[i])
					decrease[i] = Math.max(decrease[i], decrease[j] + 1);
			}
		}

		int[] dp = new int[N];

		int max = 0;
		
		for (int i=0; i<N; i++) {
			dp[i] = increase[i] + decrease[i];
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}