import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	static int N, startR, startC, max;
	static int[] dr = {-1, -1, 1, 1}, dc = {-1, 1, 1, -1};
	static int[][] cafe;
	static boolean[][] visited;
	static Set<Integer> set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			cafe = new int[N][N];
			
			for (int r=0; r<N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c=0; c<N; c++) {
					cafe[r][c] = Integer.parseInt(st.nextToken());
				}
			}
					
			max = -1;
			
			outer: for (int i=N; i>=3; i--) {
				for (int r=0; r<=N-i; r++) {
					for (int c=0; c<=N-i; c++) {
						if (isPossibleRoute(r, c, i)) {
							max = 2*(i-1); 
							break outer;
						}
					}
				}
			}
			
			sb.append("#" + tc + " ");
			sb.append(max);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static boolean isPossibleRoute(int row, int col, int size) {
		int[][] test = new int[size][size];
		
		for (int r=0; r<size; r++) {
			for (int c=0; c<size; c++) {
				test[r][c] = cafe[row+r][col+c];
			}
		}
		
		for (int i=1; i<=size-2; i++) {
			set = new HashSet<>();
			boolean flag = true;
			
			outer: for (int r=0; r<size; r++) {
				for (int c=0; c<size; c++) {
					
					if (Math.abs(r-c) == i) {
						if (set.contains(test[r][c])) {
							flag = false;
							break outer;
						}
						else set.add(test[r][c]);
					}
					
					else {
						if (r+c == i || r+c == 2*(size-1)-i) {
							if (set.contains(test[r][c])) {
								flag = false;
								break outer;
							}
							else set.add(test[r][c]);
						}
					}
				}
			}
			
			if (flag) return true;
		}
		return false;
	}
	
}