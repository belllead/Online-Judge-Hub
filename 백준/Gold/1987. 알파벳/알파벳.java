import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int R, C, max;
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	static char[][] map;
	static boolean[][] visited;
	static Set<Character> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for (int r=0; r<R; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		visited[0][0] = true;
		set.add(map[0][0]);
		dfs(0, 0, 1);
	
		System.out.println(max);
	}

	private static void dfs(int row, int col, int cnt) {
		for (int i=0; i<4; i++) {
			int tr = row + dr[i];
			int tc = col + dc[i];
		
			if (tr >= 0 && tr < R && tc >= 0 && tc < C
					&& !visited[tr][tc] && !set.contains(map[tr][tc])) {

				visited[tr][tc] = true;
				set.add(map[tr][tc]);

				dfs(tr, tc, cnt+1);
				
				visited[tr][tc] = false;
				set.remove(map[tr][tc]);
			}
		}
		
		max = Math.max(max, cnt);
	}
}