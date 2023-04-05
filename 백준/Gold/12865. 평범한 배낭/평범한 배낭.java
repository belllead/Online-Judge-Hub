import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] sack = new int[N+1][2];
		int[][] dp = new int[N+1][K+1];
		
		for (int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			sack[i] = new int[] {w, v};
		}
		
		for (int s=1; s<N+1; s++) {
			for (int w=1; w<K+1; w++) {
				if (sack[s][0] > w) dp[s][w] = dp[s-1][w];
				else {
					dp[s][w] = Math.max(dp[s-1][w], dp[s-1][w-sack[s][0]] + sack[s][1]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
	}
}