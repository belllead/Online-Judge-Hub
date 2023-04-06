import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, min;
	static char[][] maze;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static char[] keyChar = {'a', 'b', 'c', 'd', 'e', 'f'}, lockChar = {'A', 'B', 'C', 'D', 'E', 'F'};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maze = new char[N][M];

		for (int r = 0; r < N; r++) {
			maze[r] = br.readLine().toCharArray();
		}

		int[] start = new int[2];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (maze[r][c] == '0') {
					start[0] = r;
					start[1] = c;
				}
			}
		}

		// 입력 완료
		
		min = Integer.MAX_VALUE;

		bfs(start[0], start[1]);

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	private static void bfs(int row, int col) {
		Queue<Node> q = new LinkedList<>();
		boolean[][][] visited = new boolean[N][M][(int) (Math.pow(2, 7) - 1)]; 
		
		q.offer(new Node(row, col, 0, 1));
		visited[row][col][0] = true;
		
		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			for (int i=0; i<4; i++) {
				int tr = curr.row + dr[i];
				int tc = curr.col + dc[i];
				
				//경계조건 내에서 
				if (tr >= 0 && tr < N && tc >= 0 && tc < M) {
					//출구일 때
					if (maze[tr][tc] == '1') {
						min = curr.cnt;
						return;
					}
					
					//시작위치 또는 빈칸일 때
					if ((maze[tr][tc] == '0' || maze[tr][tc] == '.') 
							&& !visited[tr][tc][curr.key]) {
						q.offer(new Node(tr, tc, curr.key, curr.cnt+1));
						visited[tr][tc][curr.key] = true;
					}
					
					//벽일 때
					if (maze[tr][tc] == '#') continue;
					
					//열쇠일 때
					for (int k=0; k<6; k++) {
						// 열쇠가 없이 열쇠를 만났을 때
						if (maze[tr][tc] == keyChar[k] && ((curr.key & (1<<(6-1-k))) == 0)
								&& !visited[tr][tc][curr.key]) {
							// key에 열쇠를 추가하고 넘겨
							q.offer(new Node(tr, tc, (curr.key ^ (1<<(6-1-k))), curr.cnt+1));
							visited[tr][tc][(curr.key ^ (1<<(6-1-k)))] = true;
						}

						// 열쇠를 이미 갖고 있을 때
						if (maze[tr][tc] == keyChar[k] && ((curr.key & (1<<(6-1-k))) != 0)
								&& !visited[tr][tc][curr.key]) {
							q.offer(new Node(tr, tc, curr.key, curr.cnt+1));
							visited[tr][tc][curr.key] = true;
						}
					}
					
					//자물쇠 문일 때
					for (int d=0; d<6; d++) {
						// 열쇠를 가지고 있다면
						if (maze[tr][tc] == lockChar[d] && ((curr.key & (1<<(6-1-d))) != 0)
								&& !visited[tr][tc][curr.key]) {
							q.offer(new Node(tr, tc, curr.key, curr.cnt+1));
							visited[tr][tc][curr.key] = true;
						}
					}
				}
			}
		}
	}
	
	static class Node {
		int row, col, key, cnt;

		public Node(int row, int col, int key, int cnt) {
			super();
			this.row = row;
			this.col = col;
			this.key = key;
			this.cnt = cnt;
		}

	}
	
}