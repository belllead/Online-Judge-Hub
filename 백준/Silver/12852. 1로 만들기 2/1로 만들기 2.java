import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] memo = new int[1000001];
	static int[] prev = new int[1000001];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		memo[1] = 0;
		memo[2] = 1;
		memo[3] = 1;
		
		prev[1] = 1;
		prev[2] = 1;
		prev[3] = 1;
		
		for (int i=4; i<=N; i++) {
			memo[i] = memo[i-1] + 1;
			prev[i] = i-1;
			
			if (i % 3 == 0) {
				int t3 = memo[i/3] + 1;
				if (memo[i] > t3) {
					memo[i] = t3;
					prev[i] = i/3;
				}
			}
			
			if (i % 2 == 0) {
				int t2 = memo[i/2] + 1;
				if (memo[i] > t2) {
					memo[i] = t2;
					prev[i] = i/2;
				}
			}
			
		}
		
		printPath(N);
		
		System.out.println(memo[N]);
		System.out.println(sb);
	}
	
	private static void printPath(int n) {
		sb.append(n + " ");

		if (n == 1) {
			return;
		}
		
		printPath(prev[n]);
	}

}