import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1];
		
		int max = 0;
		
		for (int i=1; i<N+1; i++) {
			dp[i] = 1;
			
			for (int j=i-1; j>=1; j--) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1); 
				}
			}
			max = Math.max(max, dp[i]);

		}
		
		System.out.println(max);
	}
}