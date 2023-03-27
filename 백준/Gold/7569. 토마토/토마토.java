import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][][] box;
	static int[] dr = {-1, 1, 0, 0, 0, 0}, dc = {0, 0, -1, 1, 0, 0}, dh = {0, 0, 0, 0, -1, 1};
	static int N, M, H, day = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		
		box = new int[H][N][M];
		
		ArrayList<int[]> tomato = new ArrayList<>();
		
		for (int h=0; h<H; h++) {
			for (int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c=0; c<M; c++) {
					box[h][r][c] = Integer.parseInt(st.nextToken());
					if (box[h][r][c] == 1) {
						int[] temp = {h, r, c};
						tomato.add(temp);
					}
				}
			}
		}
		
		bfs(tomato);
		
//		for (int h=0; h<H; h++) {
//			for (int r=0; r<N; r++) {
//				for (int c=0; c<M; c++) {
//					System.out.print(box[h][r][c]);
//				}
//				System.out.println();
//			}
//		System.out.println();
//		}
		
		boolean flag = true;
		
		outer: for (int h=0; h<H; h++) { 
			for (int r=0; r<N; r++) {
				for (int c=0; c<M; c++) {
					if (box[h][r][c] == 0) {
						flag = false;
						break outer;
					}
				}
			}
		}
		
		if (flag)
			System.out.println(day);
		else
			System.out.println(-1);
		
	}
	
	static void bfs(ArrayList<int[]> startCoord) {
		Queue<ArrayList<int[]>> q = new ArrayDeque<>();
				
		q.offer(startCoord);
		
		while (!q.isEmpty()) {
			ArrayList<int[]> coord = q.poll();
			ArrayList<int[]> temp = new ArrayList<>();
						
			for (int l=0; l<coord.size(); l++) {
				int h = coord.get(l)[0];
				int r = coord.get(l)[1];
				int c = coord.get(l)[2];
				
				for (int i=0; i<6; i++) {
					int th = h + dh[i];
					int tr = r + dr[i];
					int tc = c + dc[i];
					if (th >= 0 && th < H && tr >= 0 && tr < N && tc >= 0 && tc < M) {
						if (box[th][tr][tc] == 0) {
							box[th][tr][tc] = 1;
							temp.add(new int[] {th, tr, tc});
						}
					}
				}
			}
			
			if (temp.size() != 0)
				q.offer(temp);
			day++;
		}
	}
	
}