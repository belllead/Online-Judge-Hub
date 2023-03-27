import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static char[][] grid;
	static boolean[][] visitedN, visitedJ;
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid = new char[N][N];
		visitedN = new boolean[N][N];
		visitedJ = new boolean[N][N];
		
		
		for (int r=0; r<N; r++) {
			grid[r] = br.readLine().toCharArray();
		}
		
//		for (char[] c : grid)
//			System.out.println(Arrays.toString(c));

		System.out.print(normal(grid) + " ");
		System.out.println(JJJ(grid));

//		for (boolean[] b : visitedJ)
//			System.out.println(Arrays.toString(b));
		
	}
	
	static int normal(char[][] grid) {
		int cnt = 0;
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				if (!visitedN[r][c]) {
					switch (grid[r][c]) {
					case 'R': 
						visitR(r, c);
						cnt++;
						break;
					case 'G': 
						visitG(r, c);
						cnt++;
						break;
					case 'B': 
						visitB(r, c);
						cnt++;
						break;
					}
				}
			}
		}
		
		return cnt;
	}
	
	static int JJJ(char[][] grid) {
		int cnt = 0;
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				if (!visitedJ[r][c]) {
					switch (grid[r][c]) {
					case 'R': 
						visitRG(r, c);
						cnt++;
						break;
					case 'G': 
						visitRG(r, c);
						cnt++;
						break;
					case 'B': 
						visitB2(r, c);
						cnt++;
						break;
					}
				}
			}
		}
		
		return cnt;
	}
	

	
	static void visitR(int row, int col) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {row, col});
		visitedN[row][col] = true;
		
		while (!q.isEmpty()) {
			int[] t = q.poll();
			
			for (int i=0; i<4; i++) {
				int tr = t[0];
				int tc = t[1];
				
				tr += dr[i];
				tc += dc[i];
				
				if (tr >= 0 && tr < N && tc >= 0 && tc < N && grid[tr][tc] == 'R' && !visitedN[tr][tc]) {
					q.offer(new int[] {tr, tc});
					visitedN[tr][tc] = true;
				}
			}
		}
	}

	static void visitG(int row, int col) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {row, col});
		visitedN[row][col] = true;
		
		while (!q.isEmpty()) {
			int[] t = q.poll();
			
			for (int i=0; i<4; i++) {
				int tr = t[0];
				int tc = t[1];
				
				tr += dr[i];
				tc += dc[i];
				
				if (tr >= 0 && tr < N && tc >= 0 && tc < N && grid[tr][tc] == 'G' && !visitedN[tr][tc]) {
					q.offer(new int[] {tr, tc});
					visitedN[tr][tc] = true;
				}
			}
		}
	}

	static void visitB(int row, int col) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {row, col});
		visitedN[row][col] = true;
		
		while (!q.isEmpty()) {
			int[] t = q.poll();
			
			for (int i=0; i<4; i++) {
				int tr = t[0];
				int tc = t[1];
				
				tr += dr[i];
				tc += dc[i];
				
				if (tr >= 0 && tr < N && tc >= 0 && tc < N && grid[tr][tc] == 'B' && !visitedN[tr][tc]) {
					q.offer(new int[] {tr, tc});
					visitedN[tr][tc] = true;
				}
			}
		}
	}

	static void visitRG(int row, int col) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {row, col});
		visitedJ[row][col] = true;
		
		while (!q.isEmpty()) {
			int[] t = q.poll();
			
			for (int i=0; i<4; i++) {
				int tr = t[0];
				int tc = t[1];
				
				tr += dr[i];
				tc += dc[i];
				
				if (tr >= 0 && tr < N && tc >= 0 && tc < N && (grid[tr][tc] == 'R' || grid[tr][tc] == 'G') && !visitedJ[tr][tc]) {
					q.offer(new int[] {tr, tc});
					visitedJ[tr][tc] = true;
				}
			}
		}
	}

	static void visitB2(int row, int col) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {row, col});
		visitedJ[row][col] = true;
		
		while (!q.isEmpty()) {
			int[] t = q.poll();
			
			for (int i=0; i<4; i++) {
				int tr = t[0];
				int tc = t[1];
				
				tr += dr[i];
				tc += dc[i];
				
				if (tr >= 0 && tr < N && tc >= 0 && tc < N && grid[tr][tc] == 'B' && !visitedJ[tr][tc]) {
					q.offer(new int[] {tr, tc});
					visitedJ[tr][tc] = true;
				}
			}
		}
	}

}