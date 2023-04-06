import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M, min = Integer.MAX_VALUE;
	static int[][] village;
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	static List<int[]> chicken, home;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		village = new int[N][N];
		chicken = new ArrayList<>();
		home = new ArrayList<>();
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				village[r][c] = sc.nextInt();
				if (village[r][c] == 2)
					chicken.add(new int[] {r, c});
				if (village[r][c] == 1)
					home.add(new int[] {r, c});
			}
		}
		
		powerSet(0, 0);
		
		System.out.println(min);
	}
	
	private static void powerSet(int ch, int m) {
		if (m == chicken.size() - M) {
			int cnt = 0;
			for (int[] h : home)
				cnt += bfs(h[0], h[1]);
			min = Math.min(min, cnt);
		}
		
		if (m == chicken.size() - M)
			return;
		
		if (ch == chicken.size())
			return;
		
		village[chicken.get(ch)[0]][chicken.get(ch)[1]] = 0;
		powerSet(ch+1, m+1);
		village[chicken.get(ch)[0]][chicken.get(ch)[1]] = 2;
		powerSet(ch+1, m);
	}

	private static int bfs(int row, int col) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		q.offer(new int[] {row, col});
		visited[row][col] = true;
		
		int cnt = -1;
		
		while (!q.isEmpty()) {
			int size = q.size();
		
			cnt++;
			
			while (size-- > 0 ) {
				int[] curr = q.poll();
				
				if (village[curr[0]][curr[1]] == 2) {
					return cnt;
				}
				
				for (int i=0; i<4; i++) {
					int tr = curr[0] + dr[i];
					int tc = curr[1] + dc[i];
					
					if (tr >= 0 && tr < N && tc >= 0 && tc < N
							&& !visited[tr][tc]) {
						q.offer(new int[] {tr, tc});
						visited[tr][tc] = true;
					}
				}
			}
			
		}
		return 987654;
	}
	
}