import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int N, max;
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
    static int[][] cheese;
    static boolean[][] visited;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        StringBuilder sb = new StringBuilder();
 
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            cheese = new int[N][N];
 
            for (int r = 0; r < N; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    cheese[r][c] = Integer.parseInt(st.nextToken());
                }
            }
 
            int max = 0;
             
            for (int i = 0; i <= 100; i++) {
                int cnt = 0;
                visited = new boolean[N][N];
 
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (cheese[r][c] == i)
                            cheese[r][c] = 0;
                    }
                }
 
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (!visited[r][c] && cheese[r][c] != 0) {
                            cnt++;
                            bfs(r, c);
                        }
                    }
                }
                 
                max = Math.max(max, cnt); 
            }
 
            sb.append("#" + tc + " ");
            sb.append(max);
            sb.append("\n");
        }
        System.out.println(sb);
    }
 
    static void bfs(int row, int col) {
        Queue<int[]> q = new ArrayDeque<>();
 
        q.offer(new int[] { row, col });
        visited[row][col] = true;
 
        while (!q.isEmpty()) {
            int[] tCoord = q.poll();
 
            for (int i = 0; i < 4; i++) {
                int tr = tCoord[0] + dr[i];
                int tc = tCoord[1] + dc[i];
 
                if (tr >= 0 && tr < N && tc >= 0 && tc < N 
                        && !visited[tr][tc] && cheese[tr][tc] != 0) {
                    q.offer(new int[] { tr, tc });
                    visited[tr][tc] = true;
 
                }
            }
        }
    }
}