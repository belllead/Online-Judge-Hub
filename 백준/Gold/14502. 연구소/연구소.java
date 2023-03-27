import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, max = 0;
	static int[][] lab;
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	static ArrayList<int[]> virusCoord = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][M];
		
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<M; c++) {
				lab[r][c] = Integer.parseInt(st.nextToken());
				if (lab[r][c] == 2) 
					virusCoord.add(new int[] {r, c});
			}
		}
		
//		for (int[] virus : virusCoord)
//			System.out.println(Arrays.toString(virus));
//		
//		for (int[] i : lab)
//			System.out.println(Arrays.toString(i));
//		System.out.println();
//				
//		System.out.println(checkSafeArea());
		
		setUpWalls(0);
		System.out.println(max);
		
	}
	
	static void setUpWalls(int n) {
		if (n == 3) {
			int[][] testLab = new int[N][M];
			for (int r=0; r<N; r++)
				testLab[r] = Arrays.copyOf(lab[r], M);
			
//			for (int[] i : testLab)
//				System.out.println(Arrays.toString(i));
//			System.out.println();
			
			boolean[][] visited = new boolean[N][M];
			
			for (int[] virus : virusCoord)
				bfs(virus, testLab, visited);
			
//			if (max < checkSafeArea(testLab)) {
//				for (int[] i : testLab)
//					System.out.println(Arrays.toString(i));
//				System.out.println(max);
//					
//				max = Math.max(max, checkSafeArea(testLab));
//			}
			
			max = Math.max(max, checkSafeArea(testLab));
			return;
			
		}
			
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				if (lab[r][c] == 0) {
					lab[r][c] = 1;
					setUpWalls(n + 1);
					lab[r][c] = 0;
				}				
			}
		}
	}
	
	static void bfs(int[] coord, int[][] lab, boolean[][] visited) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(coord);
		visited[coord[0]][coord[1]] = true;
		
		while (!q.isEmpty()) {
			int[] tempCoord = q.poll();
			lab[tempCoord[0]][tempCoord[1]] = 2;
			
			for (int i=0; i<4; i++) {
				int tr = tempCoord[0] + dr[i];
				int tc = tempCoord[1] + dc[i];
				
				if (tr >= 0 && tr < N && tc >= 0 && tc < M) {
					if (lab[tr][tc] == 0 && !visited[tr][tc]) {
						int[] temp = {tr, tc};
						q.offer(temp);
						visited[tr][tc] = true;
					}
				}
			}
		}
	}
	
	static int checkSafeArea(int[][] lab) {
		int cnt = 0;
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				if (lab[r][c] == 0)
					cnt++;
			}
		}
		
		return cnt;
	}
	
}