import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] house;
	static int N, cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		house = new int[N+1][N+1];
		
		for (int r=1; r<N+1; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c=1; c<N+1; c++) {
				house[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for (int r=0; r<N+1; r++) {
//			for (int c=0; c<N+1; c++) {
//				System.out.print(house[r][c]);
//			}
//			System.out.println();
//		}
		
		dfs(0, 1, 2);
		
		System.out.println(cnt);
		
	}
	
	static void dfs(int state, int endRow, int endCol) {
//		System.out.println(state);
//		System.out.println(endRow);
//		System.out.println(endCol);
//		System.out.println();
		if (endRow > N || endCol > N)
			return;
		
		if (house[endRow][endCol] == 1)
			return;
		
		if (state == 2) {
			if (house[endRow-1][endCol] == 1 || house[endRow][endCol-1] == 1)
				return;
		}
		
		if (endRow == N && endCol == N) {
			cnt++;
			return;
		}
		
		if (state == 0) {
			dfs(0, endRow, endCol + 1); // 0 1 3 // 0 1 4
			dfs(2, endRow + 1, endCol + 1); // 2 2 4
		} else if (state == 1) {
			dfs(1, endRow + 1, endCol);
			dfs(2, endRow + 1, endCol + 1);
		} else {			
			dfs(0, endRow, endCol + 1);
			dfs(1, endRow + 1, endCol);
			dfs(2, endRow + 1, endCol + 1);
		}
	}
	
}