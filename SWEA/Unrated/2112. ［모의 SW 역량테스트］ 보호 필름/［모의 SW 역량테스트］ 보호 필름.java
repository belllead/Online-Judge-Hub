import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int D, W, K, min;
	static boolean[] visited;
	static int[] one, zero;
	static int[][] copy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			int[][] film = new int[D][W];
			copy = new int[D][W];
			visited = new boolean[D];
			one = new int[W];
			zero = new int[W];
			Arrays.fill(one, 1);
			Arrays.fill(zero, 0);
			
			for (int r=0; r<D; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c=0; c<W; c++) {
					int t = Integer.parseInt(st.nextToken());
					film[r][c] = t;
					copy[r][c] = t;
				}
			}
			
			min = K;
			
			treat(film, 0, 0);
			
			sb.append("#" + tc + " ");
			sb.append(min);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void treat(int[][] film, int treatCnt, int row) {
		if (treatCnt >= min) {
			return;
		}
		
		if (row == D) {
			if (check(film)) {
				min = Math.min(min, treatCnt);
			}
			return;
		}
				
		treat(film, treatCnt, row+1);
		
		film[row] = one;
		treat(film, treatCnt+1, row+1);
		
		film[row] = zero;
		treat(film, treatCnt+1, row+1);
		
		film[row] = copy[row];
	}
	
	
	static boolean check(int[][] film) {
		for (int c=0; c<W; c++) {
			int prev = film[0][c];
			int cnt = 1;
			for (int r=1; r<D; r++) {
				if (film[r][c] == prev) {
					cnt++;
				} else {
					prev = film[r][c];
					cnt = 1;
				}
				
				if (cnt >= K) break;
				
				if (r == D-1 && cnt < K) {
					return false;
				}
			}
		}
		
		return true;
	}
}