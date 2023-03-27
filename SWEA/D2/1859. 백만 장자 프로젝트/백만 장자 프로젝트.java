import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] ans = new long[T];
		
		
		for (int i=0; i<T; i++) {
			int N = sc.nextInt();
			int[] price = new int[N];
			long profit = 0;
			
			for (int j=0; j<N; j++) {
				price[j] = sc.nextInt();
			}
			
			int max = price[N-1];
			
			for (int j=N-1; j>=0; j--) {
				if (price[j] > max)	max = price[j];
				else profit += max - price[j];
			}
			ans[i] = profit;	
		}
		
		
		for (int i=0; i<T; i++) {
			System.out.println("#" + (i+1) + " " + ans[i]);
		}
		
	}
	
}

// 1 1 5 1 2 4