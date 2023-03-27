import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr, memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];		
		memo = new int[N][N];
		
		int temp = 0;
		
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if (r == 0) {
					temp += arr[r][c];
					memo[r][c] = temp;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken()) - 1; 
			int c1 = Integer.parseInt(st.nextToken()) - 1; 
			int r2 = Integer.parseInt(st.nextToken()) - 1; 
			int c2 = Integer.parseInt(st.nextToken()) - 1;
			
			int sum = dp(r1, c1, r2, c2);
			
			sb.append(sum + "\n");
		}
		
		System.out.println(sb);
	}
	
	static int dp(int r1, int c1, int r2, int c2) {
		int a = sum(r2, c2);
		int b = r1-1 >= 0 ? sum(r1-1, c2) : 0;
		int c = c1-1 >= 0 ? sum(r2, c1-1) : 0;
		int d = (r1-1 >= 0 && c1-1 >= 0) ? sum(r1-1, c1-1) : 0;
		
		return a - b - c + d;
	}
	
	static int sum(int row, int col) {
		if (memo[row][col] > 0)
			return memo[row][col];
		
		int sum = 0;
		
		for (int c=0; c<=col; c++) {
			sum += arr[row][c];
		}
		
		memo[row][col] = sum(row-1, col) + sum; 
		
		return memo[row][col];
	}
}